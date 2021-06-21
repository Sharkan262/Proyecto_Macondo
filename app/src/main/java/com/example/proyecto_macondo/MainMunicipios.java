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

public class MainMunicipios extends AppCompatActivity {
    ArrayList<Municipio> listaDeMunicipios = new ArrayList<>();
    RecyclerView listadoGrafico;
    FirebaseFirestore baseDatosMun = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_municipios);
        getSupportActionBar().hide();

        listadoGrafico=findViewById(R.id.listMun);
        listadoGrafico.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        llenarListado();
        AdaptadorMunicipios adaptadorMun = new AdaptadorMunicipios(listaDeMunicipios);
        listadoGrafico.setAdapter(adaptadorMun);
    }

    public void llenarListado() {

        baseDatosMun.collection("Municipios")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {

                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                String nombre = document.get("Nombre").toString();
                                String Imagen = document.get("Imagen").toString();

                                listaDeMunicipios.add(new Municipio(nombre,Imagen));

                            }
                            AdaptadorMunicipios adaptador = new AdaptadorMunicipios(listaDeMunicipios);
                            listadoGrafico.setAdapter(adaptador);
                        } else {
                            Toast.makeText(MainMunicipios.this, "Error en la consulta", Toast.LENGTH_SHORT).show();

                        }
                    }
                });
    }
}