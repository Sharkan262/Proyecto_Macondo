package com.example.proyecto_macondo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class InfMunicipio extends AppCompatActivity {

    ArrayList<Informacion> listainformacion = new ArrayList<>();
    RecyclerView listaInf;
    FirebaseFirestore baseDatosMun = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inf_municipio);
        getSupportActionBar().hide();

        listaInf=findViewById(R.id.listInf);
        listaInf.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        llenarListado();
        AdaptadorInformacion adaptadorInformacion = new AdaptadorInformacion(listainformacion);

    }

    public void llenarListado() {

        baseDatosMun.collection("Informacion")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {

                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                String titulo = document.get("titulo").toString();
                                String descripcion = document.get("descripcion").toString();
                                String imagen = document.get("imagen").toString();

                                listainformacion.add(new Informacion(titulo,descripcion,imagen));

                            }
                            AdaptadorInformacion adaptador = new AdaptadorInformacion(listainformacion);
                            listaInf.setAdapter(adaptador);
                        } else {
                            Toast.makeText(InfMunicipio.this, "Error en la consulta", Toast.LENGTH_SHORT).show();

                        }
                    }
                });
    }

}