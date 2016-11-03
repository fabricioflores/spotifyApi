package com.example.fabricioflores.spotifyapi.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fabricioflores.spotifyapi.R;
import com.example.fabricioflores.spotifyapi.models.Item;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by fabricioflores on 3/11/16.
 */

public class ArtistsAdapter extends ArrayAdapter<Item> {
    private final Context contexto;
    private final ArrayList<Item> array_personas;

    public ArtistsAdapter(Context context, ArrayList<Item> array_personas) {
        super(context, -1, array_personas);
        this.contexto = context;
        this.array_personas = array_personas;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) contexto
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View layoutPersona = inflater.inflate(R.layout.custom_list_layout, parent, false);

        // Referencias UI.
        ImageView image = (ImageView) layoutPersona.findViewById(R.id.imagePlaceholder);
        TextView name = (TextView) layoutPersona.findViewById(R.id.artistName);

        // Lead actual.
        Item artista = getItem(position);

        // Setup.
        if(artista.getImages().size() > 0){
            Picasso.with(contexto).load(artista.getImages().get(0).getUrl()).placeholder(android.R.drawable.btn_default).into(image);
        }else{
            Bitmap largeIcon = BitmapFactory.decodeResource(contexto.getResources(), android.R.drawable.btn_default);
            image.setImageBitmap(largeIcon);
        }
        name.setText(artista.getName());
        return layoutPersona;
    }

}
