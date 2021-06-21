package com.example.proyecto_macondo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    ArrayList<Departamento> listaDeDepartamentos = new ArrayList<>();
    FirebaseFirestore baseDatos = FirebaseFirestore.getInstance();
    RecyclerView listadoGrafico;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listadoGrafico=findViewById(R.id.listDeps);
        listadoGrafico.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        llenarListado();
        AdaptadorDepartamentos adaptadorDep = new AdaptadorDepartamentos(listaDeDepartamentos);
        listadoGrafico.setAdapter(adaptadorDep);
    }

    public void llenarListado() {

        baseDatos.collection("Departamentos")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {

                        if (task.isSuccessful()){
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                String nombre = document.get("Nombre").toString();
                                String foto = document.get("Imagen").toString();

                                listaDeDepartamentos.add(new Departamento(nombre,foto));

                            }
                            AdaptadorDepartamentos adaptador = new AdaptadorDepartamentos(listaDeDepartamentos);
                            listadoGrafico.setAdapter(adaptador);
                        }else{
                            Toast.makeText(MainActivity.this, "Error en la consulta", Toast.LENGTH_SHORT).show();

                        }
                    }
                });
    }
    public void cambiarIdioma(String lenguaje){
        Locale idioma = new Locale(lenguaje);
        Locale.setDefault(idioma);

        Configuration configuracionTelefono = getResources().getConfiguration();
        configuracionTelefono.locale=idioma;

        getBaseContext().getResources().updateConfiguration(configuracionTelefono,getBaseContext().getResources().getDisplayMetrics());

    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);

        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        switch (id){
            case(R.id.opcion1):
                cambiarIdioma("es");
                Intent intent1=new Intent(MainActivity.this,MainActivity.class);
                startActivity(intent1);
                break;
            case(R.id.opcion2):
                cambiarIdioma("en");
                Intent intent2=new Intent(MainActivity.this,MainActivity.class);
                startActivity(intent2);
                break;

            case(R.id.opcion3):
                Intent intent3=new Intent(MainActivity.this,Acercade.class);
                startActivity(intent3);
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}