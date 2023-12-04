package pe.usat.moviles.rapidisimoapp_cliente.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pe.usat.moviles.rapidisimoapp_cliente.R;

public class AgregarEstadoFragment extends Fragment {

    private int solicitudId;


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
        final View view = inflater.inflate(R.layout.fragment_agregar_solicitud, container, false);


        return view;
    }
}