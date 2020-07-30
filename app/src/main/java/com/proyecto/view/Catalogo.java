package com.proyecto.view;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.proyecto.model.Pais;
import com.proyecto.myapplicationpaloma.R;
import com.proyecto.myapplicationpaloma.databinding.ActivityCatalogoBinding;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Catalogo extends AppCompatActivity{
    private Activity _activity;

    ActivityCatalogoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        binding = ActivityCatalogoBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.recyclerViewPaises.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recyclerViewPaises.setLayoutManager(layoutManager);

        List<Pais> paises = getListaPaises();
        RecyclerView.Adapter mAdapter = new AdaptadorPais(paises,this);
        binding.recyclerViewPaises.setAdapter(mAdapter);

    }

    protected List<Pais> getListaPaises() {
        List<Pais> paises = new ArrayList<>() ;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(getAssets().open("Paises.csv")));
            String line;
            Log.e("Reader Stuff",reader.readLine());
            while ((line = reader.readLine()) != null) {
                Log.e("code",line);
                String[] d = line.split(";");

                Pais p = new Pais(d[0],d[1],d[2],d[3],d[4],d[5]);
                paises.add(p);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return paises;
    }
}
