package pe.usat.moviles.rapidisimoapp_cliente.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.JsonObject;

import pe.usat.moviles.rapidisimoapp_cliente.R;
import pe.usat.moviles.rapidisimoapp_cliente.response.DetalleSolicitudResponse;
import pe.usat.moviles.rapidisimoapp_cliente.retrofit.ApiService;
import pe.usat.moviles.rapidisimoapp_cliente.retrofit.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetalleSolicitudFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetalleSolicitudFragment extends Fragment {

    private int solicitudId;
    private FloatingActionButton btnRegistrarEstado;
    private TextView txtOrigen, txtDestino;
    private TextView lblNombre, txtNombre, txtDoc, txtTelefono, txtEmail, txtDirección;
    private TextView txtClase, txtTipo, txtCategoria,txtDescripcion, txtPeso;

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            solicitudId = getArguments().getInt("solicitudId");
        }
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_detalle_solicitud, container, false);

        txtOrigen = view.findViewById(R.id.txtOrigen);
        txtDestino = view.findViewById(R.id.txtDestino);
        lblNombre = view.findViewById(R.id.lblNombre);
        txtNombre = view.findViewById(R.id.txtNombre);
        txtDoc = view.findViewById(R.id.txtDoc);
        txtTelefono = view.findViewById(R.id.txtTelefono);
        txtEmail = view.findViewById(R.id.txtEmail);
        txtDirección = view.findViewById(R.id.txtDirección);
        txtClase = view.findViewById(R.id.txtClase);
        txtTipo = view.findViewById(R.id.txtTipo);
        txtCategoria = view.findViewById(R.id.txtCategoria);
        txtDescripcion = view.findViewById(R.id.txtDescripcion);
        txtPeso = view.findViewById(R.id.txtPeso);

        btnRegistrarEstado = view.findViewById(R.id.btnRegistrarEstado);

        cargarDatos();

        btnRegistrarEstado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                final Bundle bundle = new Bundle();
                bundle.putInt("solicitudId", solicitudId);

                final NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment_content_navigation);
                navController.navigate(R.id.agregarEstadoFragment, bundle);
            }
        });

        return view;
    }

    private void cargarDatos() {
        final ApiService apiService = RetrofitClient.createService();
        final Call<DetalleSolicitudResponse> call = apiService.obtenerDetalleSolicitud(solicitudId);
        call.enqueue(new Callback<DetalleSolicitudResponse>() {
            @Override
            public void onResponse(final Call<DetalleSolicitudResponse> call, final Response<DetalleSolicitudResponse> response) {
                if (response.code() == 200) {
                    if (response.body().isStatus()) {
                        final JsonObject data = response.body().getData();
                        Log.i("LOGS", data.toString());

                        final JsonObject cliente = data.getAsJsonObject("cliente");

                        //Mostramos los datos obtenidos
                        txtOrigen.setText(data.get("direccionOrigen").getAsString());
                        txtDestino.setText(data.get("direccionDestino").getAsString());

                        if (cliente.get("tipoDoc").getAsString().equals("DNI")) {
                            lblNombre.setText("Nombre:");
                            txtNombre.setText(cliente.get("nombres").getAsString());
                        } else {
                            lblNombre.setText("Razón Social:");
                            txtNombre.setText(cliente.get("razonSocial").getAsString());
                        }

                        txtDoc.setText(cliente.get("tipoDoc").getAsString() + " - " + cliente.get("numeroDoc").getAsString());
                        txtTelefono.setText(cliente.get("telefono").getAsString());
                        txtEmail.setText(cliente.get("email").getAsString());
                        txtDirección.setText(cliente.get("direccion").getAsString());

                        txtClase.setText(data.get("claseCarga").getAsString());
                        txtTipo.setText(data.get("tipoCarga").getAsString());
                        txtCategoria.setText(data.get("categoriaCarga").getAsString());
                        txtDescripcion.setText(data.get("descripcionCarga").getAsString());
                        txtPeso.setText(data.get("pesoKg").getAsString());

                    }
                } else {
                    Log.e("Error al acceder al servicio web", response.message());
                    Toast.makeText(getContext(), response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(final Call<DetalleSolicitudResponse> call, final Throwable t) {
                Log.e("Falla al conectarse al servicio web", t.getMessage());
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}