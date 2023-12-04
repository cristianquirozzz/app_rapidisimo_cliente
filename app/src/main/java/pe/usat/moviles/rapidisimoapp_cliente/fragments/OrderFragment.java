package pe.usat.moviles.rapidisimoapp_cliente.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import pe.usat.moviles.rapidisimoapp_cliente.R;
import pe.usat.moviles.rapidisimoapp_cliente.adapter.SolicitudAdapter;
import pe.usat.moviles.rapidisimoapp_cliente.databinding.FragmentOrderBinding;
import pe.usat.moviles.rapidisimoapp_cliente.model.Solicitud;
import pe.usat.moviles.rapidisimoapp_cliente.response.DetalleSolicitudResponse;
import pe.usat.moviles.rapidisimoapp_cliente.response.SolicitudListadoClienteResponse;
import pe.usat.moviles.rapidisimoapp_cliente.response.SolicitudListadoResponse;
import pe.usat.moviles.rapidisimoapp_cliente.retrofit.ApiService;
import pe.usat.moviles.rapidisimoapp_cliente.retrofit.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrderFragment extends Fragment {

    private FragmentOrderBinding binding;

    RecyclerView recyclerViewSolicitudes;
    SolicitudAdapter solicitudAdapter;
    List<Solicitud> solicitudesListaCliente = new ArrayList<>();
    SwipeRefreshLayout swipeRefreshLayoutSolicitudes;


    public View onCreateView(@NonNull final LayoutInflater inflater,
                             final ViewGroup container, final Bundle savedInstanceState) {

        //binding = FragmentOrderBinding.inflate(inflater, container, false);
        //View root = binding.getRoot();

        final View view = inflater.inflate(R.layout.fragment_order, container, false);

        //Configurar el recyclerview
        recyclerViewSolicitudes = view.findViewById(R.id.recyclerViewSolicitudes);
        recyclerViewSolicitudes.setLayoutManager(new LinearLayoutManager(getContext()));
        solicitudAdapter = new SolicitudAdapter(solicitudesListaCliente, true);
        recyclerViewSolicitudes.setAdapter(solicitudAdapter);

        //Configurar el swipeRefreshLayoutClientes
        swipeRefreshLayoutSolicitudes = view.findViewById(R.id.swipeRefreshLayoutSolicitudes);

        //Reconozca el evento onRefresh
        swipeRefreshLayoutSolicitudes.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                listarSolicitudes(); //Refrescar el contenido de la lista
                swipeRefreshLayoutSolicitudes.setRefreshing(false); //Desactivar la animación
            }
        });
        swipeRefreshLayoutSolicitudes.setColorSchemeResources(R.color.primaryColor, R.color.primaryColorDark, R.color.colorAccent);



        listarSolicitudes();

        return view;
    }

    private void listarSolicitudes(){
        final int clienteID = 1;

        final ApiService apiService = RetrofitClient.createService();
        final Call<SolicitudListadoClienteResponse> call = apiService.listadoSolicitudesCliente(clienteID);
        call.enqueue(new Callback<SolicitudListadoClienteResponse>() {

            @Override
            public void onResponse(final Call<SolicitudListadoClienteResponse> call, final Response<SolicitudListadoClienteResponse> response) {
                if(response.code() == 200) {
                    final boolean status = response.body().isStatus();
                    if (status){
                        solicitudesListaCliente.clear();
                        solicitudesListaCliente.addAll(Arrays.asList(response.body().getData()));

                        solicitudAdapter.notifyDataSetChanged();
                    }
                } else {
                Log.e("Error al acceder al servicio web", response.message());
                Toast.makeText(getContext(), response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(final Call<SolicitudListadoClienteResponse> call, final Throwable t) {
                Log.e("Falla al conectarse al servicio web", t.getMessage());
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //binding = null;
    }
}