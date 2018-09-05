package com.coursera.santiago.petagram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.coursera.santiago.petagram.adapter.MascotaAdaptador;
import com.coursera.santiago.petagram.db.ConstructorMascotas;
import com.coursera.santiago.petagram.pojo.ListadoMascotas;
import com.coursera.santiago.petagram.pojo.Mascota;

import java.util.ArrayList;

public class MascotasFavoritas extends AppCompatActivity {

    RecyclerView rvMascostasFavoritas;
    ArrayList<Mascota> alMascotasFavoritas = new ArrayList<Mascota>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_favoritas);

        Toolbar miActionBar = findViewById(R.id.miActionBar);
        miActionBar.findViewById(R.id.ibFavoritos).setVisibility(View.INVISIBLE);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        ConstructorMascotas mConstructorMascotas = new ConstructorMascotas(getApplicationContext());


        alMascotasFavoritas = ListadoMascotas.getListadoOrdenadoPorLike(mConstructorMascotas.obtenerDatos());


        rvMascostasFavoritas = findViewById(R.id.rvMascotasFavoritas);

        LinearLayoutManager llmMascotasFavoritas = new LinearLayoutManager(this);
        llmMascotasFavoritas.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascostasFavoritas.setLayoutManager(llmMascotasFavoritas);
        inicializarAdaptador();

    }

    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(alMascotasFavoritas);
        rvMascostasFavoritas.setAdapter(adaptador);
    }


}
