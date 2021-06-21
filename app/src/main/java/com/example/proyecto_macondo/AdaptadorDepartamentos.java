package com.example.proyecto_macondo;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdaptadorDepartamentos extends RecyclerView.Adapter<AdaptadorDepartamentos.viewHolderDep> {

    ArrayList<Departamento> listaDeDep;
    public AdaptadorDepartamentos(ArrayList<Departamento> listaDeDep){
        this.listaDeDep= listaDeDep;
    }

    @NonNull
    @NotNull
    @Override
    public AdaptadorDepartamentos.viewHolderDep onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View vistaItemDep = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista,parent,false);
        return new viewHolderDep(vistaItemDep);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull AdaptadorDepartamentos.viewHolderDep holder, int position) {
        holder.actualizarDep(listaDeDep.get(position));
    }

    @Override
    public int getItemCount() {
        return listaDeDep.size();
    }

    public class viewHolderDep extends RecyclerView.ViewHolder {
        TextView nombreDep;
        ImageView imgDep;
        public viewHolderDep(@NonNull @NotNull View itemView) {
            super(itemView);
            nombreDep = itemView.findViewById(R.id.name);
            imgDep = itemView.findViewById(R.id.img);
        }

        public void actualizarDep(Departamento departamento) {
            nombreDep.setText(departamento.getNombreDep());
            Picasso.with(itemView.getContext()).load(departamento.getImgDep()).into(imgDep);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(itemView.getContext(),MainMunicipios.class);
                    intent.putExtra("datosDep",departamento);
                    itemView.getContext().startActivity(intent);
                }
            });
        }
    }
}
