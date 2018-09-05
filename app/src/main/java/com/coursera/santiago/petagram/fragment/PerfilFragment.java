package com.coursera.santiago.petagram.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.coursera.santiago.petagram.R;
import com.coursera.santiago.petagram.adapter.MascotaAdaptador;
import com.coursera.santiago.petagram.adapter.MascotaGridAdaptador;
import com.coursera.santiago.petagram.pojo.ListadoMascotas;
import com.coursera.santiago.petagram.pojo.Mascota;

import java.util.ArrayList;


public class PerfilFragment extends Fragment {

    RecyclerView rvMascostas;
    ArrayList<Mascota> alMascotas;
    public PerfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_perfil, container, false);

        rvMascostas = v.findViewById(R.id.rvMascostas);

        GridLayoutManager gmMascota = new GridLayoutManager(getActivity(), 3);

        rvMascostas.setLayoutManager(gmMascota);
        crearListadoMascota();
        inicializarAdaptador();
        return v;
    }

    public void inicializarAdaptador(){
        MascotaGridAdaptador adaptador = new MascotaGridAdaptador(alMascotas);
        rvMascostas.setAdapter(adaptador);
    }


    public void crearListadoMascota(){
        alMascotas = new ArrayList<Mascota>();
        alMascotas.add(new Mascota("Bobby",R.drawable.cachorro1,3));
        alMascotas.add(new Mascota("Catty",R.drawable.cachorro2,2));
        alMascotas.add(new Mascota("Tommy",R.drawable.cachorro3,4));
        alMascotas.add(new Mascota("Tom",R.drawable.cachorro4,0));
        alMascotas.add(new Mascota("Lazy",R.drawable.cachorro5,5));
        alMascotas.add(new Mascota("Doki",R.drawable.cachorro6,1));
        alMascotas.add(new Mascota("Samy",R.drawable.cachorro7,3));
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("Petagram", "Cambio");
    }
}
