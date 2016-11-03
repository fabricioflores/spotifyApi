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
            new MyTask(image).execute(artista.getImages().get(0).getUrl());
        }else{
            Bitmap largeIcon = BitmapFactory.decodeResource(contexto.getResources(), android.R.drawable.btn_default);
            image.setImageBitmap(largeIcon);
        }
        name.setText(artista.getName());

        return layoutPersona;
    }

    private class MyTask extends AsyncTask<String, Void, Bitmap> {

        ImageView image;

        public MyTask(ImageView image){
            this.image = image;
        }

        protected Bitmap doInBackground(String... stringUrls) {
            try {
                String stringUrl = stringUrls[0];
                URL url = new URL(stringUrl);
                HttpURLConnection urlcon = (HttpURLConnection) url.openConnection();
                urlcon.setDoInput(true);
                urlcon.connect();
                InputStream in = urlcon.getInputStream();
                Bitmap mIcon = BitmapFactory.decodeStream(in);
                return  mIcon;
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
                return null;
            }
        }

        protected void onProgressUpdate() {
        }

        protected void onPostExecute(Bitmap result) {
            image.setImageBitmap(result);
        }
    }
}
