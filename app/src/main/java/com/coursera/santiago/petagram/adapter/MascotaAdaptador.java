package com.coursera.santiago.petagram.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.coursera.santiago.petagram.R;
import com.coursera.santiago.petagram.db.ConstructorMascotas;
import com.coursera.santiago.petagram.pojo.Mascota;

import java.util.ArrayList;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder>{

    ArrayList<Mascota> alMascotas;
    Context mContext;
    public MascotaAdaptador(ArrayList<Mascota> alMascotas){
        this.alMascotas = alMascotas;
    }
    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_mascota, parent, false);
        mContext = parent.getContext();
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MascotaViewHolder mascotaViewHolder, int position) {
        final Mascota mascota = alMascotas.get(position);
        mascotaViewHolder.ibFoto.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvNombreMascota.setText(mascota.getNombre());
        mascotaViewHolder.tvCantidadLike.setText(""+mascota.getCantidadLike());

        mascotaViewHolder.ibLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConstructorMascotas constructorMascotas = new ConstructorMascotas(mContext);
                constructorMascotas.darLikeMascota(mascota);


//                mascota.setCantidadLike(likes);
                mascotaViewHolder.tvCantidadLike.setText(""+constructorMascotas.obtenerLikesMascota(mascota));
            }
        });
    }

    @Override
    public int getItemCount() {
        return alMascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

        private ImageButton ibFoto;
        private ImageButton ibLike;
        private TextView tvNombreMascota;
        private TextView tvCantidadLike;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            ibFoto = itemView.findViewById(R.id.ibFoto);
            ibLike = itemView.findViewById(R.id.ibLike);
            tvNombreMascota = itemView.findViewById(R.id.tvNombreMascota);
            tvCantidadLike = itemView.findViewById(R.id.tvCantidadLike);


        }
    }
}
