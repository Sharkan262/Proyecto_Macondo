package com.example.proyecto_macondo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;

public class AdaptadorInformacion extends RecyclerView.Adapter<AdaptadorInformacion.viewHolderInf> {
    ArrayList<Informacion> listaDeInf;


    public AdaptadorInformacion(ArrayList<Informacion> listainformacion) {
        this.listaDeInf = listainformacion;
    }

    @NonNull
    @NotNull
    @Override
    public AdaptadorInformacion.viewHolderInf onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View vistainfo = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_inf,parent,false);
        return new viewHolderInf(vistainfo);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull AdaptadorInformacion.viewHolderInf holder, int position) {
    holder.actualizarInf(listaDeInf.get(position));
    }

    @Override
    public int getItemCount() {
        return listaDeInf.size();
    }

    public class viewHolderInf extends RecyclerView.ViewHolder {
        TextView titulo,desc;
        ImageView imagenInf;

        public viewHolderInf(@NonNull @NotNull View itemView) {
            super(itemView);
            Collections.reverse(listaDeInf);
            titulo = itemView.findViewById(R.id.titulo);
            desc = itemView.findViewById(R.id.descripcion);
            imagenInf = itemView.findViewById(R.id.imgInf);

        }

        public void actualizarInf(Informacion informacion) {
        titulo.setText(informacion.getTitulo());
        desc.setText(informacion.getDescripcion());
        Picasso.with(itemView.getContext()).load(informacion.getImagen()).into(imagenInf);

        }
    }
}
