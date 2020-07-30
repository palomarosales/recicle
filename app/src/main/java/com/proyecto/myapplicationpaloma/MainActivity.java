package com.proyecto.myapplicationpaloma;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.proyecto.model.Pais;
import com.proyecto.myapplicationpaloma.databinding.ActivityCatalogoBinding;
import com.proyecto.view.AdaptadorPais;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{
//    private  activityPrimariaBinding binding;
    private ActivityCatalogoBinding _binding;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);


        _binding=ActivityCatalogoBinding.inflate(getLayoutInflater());
        View view=_binding.getRoot();
        setContentView(view);

        _binding.recyclerViewPaises.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        _binding.recyclerViewPaises.setLayoutManager(layoutManager);

        List<Pais>paises=getListaProductos();
        RecyclerView.Adapter adapter=new AdaptadorPais(paises,this);
        _binding.recyclerViewPaises.setAdapter(adapter);

    }

    protected List<Pais> getListaProductos(){

        List<Pais> productos = new ArrayList<>();

        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(getAssets().open("Paises.csv")));
            String line;
            Log.e("Reader Stuff",reader.readLine());
            while ((line = reader.readLine()) != null){
                Log.e("code",line);
                String[] d = line.split(";");
                Pais p = new Pais(d[0],d[1],d[2],d[3],d[4],d[5]);
                productos.add(p);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return productos;
    }





}