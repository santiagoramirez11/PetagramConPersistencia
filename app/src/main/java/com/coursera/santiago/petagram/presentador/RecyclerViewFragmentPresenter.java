package com.coursera.santiago.petagram.presentador;

import android.content.Context;

import com.coursera.santiago.petagram.db.ConstructorMascotas;
import com.coursera.santiago.petagram.fragment.IRecyclerViewFragmentView;
import com.coursera.santiago.petagram.pojo.Mascota;

import java.util.ArrayList;

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter {

    private IRecyclerViewFragmentView mIRecyclerViewFragmentView;
    private Context mContext;
    private ConstructorMascotas mConstructorMascotas;
    private ArrayList<Mascota> mMascotas;
    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context){
        this.mIRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.mContext = context;
        obtenerMascotasBaseDatos();
    }

    @Override
    public void obtenerMascotasBaseDatos() {
        mConstructorMascotas = new ConstructorMascotas(mContext);
        mMascotas = mConstructorMascotas.obtenerDatos();
        mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {
        mIRecyclerViewFragmentView.inicializarAdaptador(mIRecyclerViewFragmentView.crearAdaptador(mMascotas));
        mIRecyclerViewFragmentView.generarLinearLayoutVertical();
    }
}
