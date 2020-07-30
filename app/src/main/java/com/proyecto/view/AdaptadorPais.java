package com.proyecto.view;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.proyecto.model.Pais;
import com.proyecto.myapplicationpaloma.R;
import java.util.List;

public class AdaptadorPais extends RecyclerView.Adapter<AdaptadorPais.MyViewHolder>{

    private List<Pais> paises;
    private Activity actividad;

    // Provee una referencia a la vista para cada item de datos
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // cada item de datos es solo una cadena para este ejemplo
        public TextView textViewPais;
        public TextView textViewCapital;
        public ImageView imageViewB;
        public TextView textViewPoblacion;
        public ImageView imageViewM;
        public WebView himno;
        public MyViewHolder(View v) {
            super(v);

          textViewPais= v.findViewById(R.id.textViewPais);
            textViewCapital=v.findViewById(R.id.textViewCapital);
           imageViewB = v.findViewById(R.id.imageViewBandera);
           textViewPoblacion=v.findViewById(R.id.textViewPoblacion);
           imageViewM= v.findViewById(R.id.imageViewMapa);
           himno=v.findViewById(R.id.himnoWeb);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)


    public AdaptadorPais(List<Pais> paises, Activity actividad) {
        this.paises = paises;
        this.actividad = actividad;
    }

    @Override
    public AdaptadorPais.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                              int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.complex_row_item, parent, false);

        return new AdaptadorPais.MyViewHolder(v);
    }


    @Override
    public void onBindViewHolder(AdaptadorPais.MyViewHolder holder,int position ){
        Pais p = paises.get(position);
        holder.textViewPais.setText(p.getNombre());
       holder.textViewCapital.setText(p.getCapital());
       Glide.with(holder.itemView.getContext()).load(p.getBandera()).into(holder.imageViewB);
       holder.textViewPoblacion.setText(p.getPoblacion());
       Glide.with(holder.imageViewM.getContext()).load(p.getMapa()).into(holder.imageViewM);
       holder.himno.getSettings().setJavaScriptEnabled(true);
        holder.himno.loadData(p.getHimno(),"text/html","utf-8");
        holder.himno.setWebChromeClient(new WebChromeClient(){});

    }


    @Override
    public int getItemCount() {
        return paises.size();
    }

}
