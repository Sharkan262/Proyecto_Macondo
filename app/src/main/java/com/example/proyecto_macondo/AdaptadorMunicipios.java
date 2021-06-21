package com.example.proyecto_macondo;

import android.content.Intent;
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

public class AdaptadorMunicipios  extends RecyclerView.Adapter<AdaptadorMunicipios.viewHolderMun> {
    ArrayList<Municipio> listaDeMun;
    public AdaptadorMunicipios(ArrayList<Municipio> listaDeMun){
        this.listaDeMun = listaDeMun;
    }

    @NonNull
    @NotNull
    @Override
    public AdaptadorMunicipios.viewHolderMun onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View vistaItemMun = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mun,parent,false);

        return new viewHolderMun(vistaItemMun);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull AdaptadorMunicipios.viewHolderMun holder, int position) {
        holder.actualizarMun(listaDeMun.get(position));
    }

    @Override
    public int getItemCount() {
        return listaDeMun.size();
    }

    public static class viewHolderMun extends RecyclerView.ViewHolder {
        TextView nombreMun;
        ImageView imgMun;

        public viewHolderMun(@NonNull @NotNull View itemView) {
            super(itemView);
            nombreMun= itemView.findViewById(R.id.nameMun);
            imgMun = itemView.findViewById(R.id.imgMun);



        }

        public void actualizarMun(Municipio municipio) {

            nombreMun.setText(municipio.getNombreMun());
            Picasso.with(itemView.getContext()).load(municipio.getImagen()).into(imgMun);




            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(itemView.getContext(),InfMunicipio.class);
                    intent.putExtra("datosMun",municipio);
                    itemView.getContext().startActivity(intent);

                }
            });

        }
    }
}
