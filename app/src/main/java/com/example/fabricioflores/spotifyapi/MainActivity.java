package com.example.fabricioflores.spotifyapi;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.fabricioflores.spotifyapi.adapters.ArtistsAdapter;
import com.example.fabricioflores.spotifyapi.interfaces.SpotifyService;
import com.example.fabricioflores.spotifyapi.models.ArtistResponse;
import com.example.fabricioflores.spotifyapi.models.Item;

import java.util.ArrayList;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends Activity {

    SpotifyService service;
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.spotify.com/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(SpotifyService.class);
        list = (ListView) findViewById(R.id.artistList);
    }

    public void search(View v) {
        EditText editText = (EditText) findViewById(R.id.inputSearch);
        String artist = editText.getText().toString();

        Call<ArtistResponse> call_async = service.listArtists(artist);

        call_async.enqueue(new Callback<ArtistResponse>() {
            @Override
            public void onResponse(Response<ArtistResponse> response, Retrofit retrofit) {
                ArtistResponse artistList = response.body();
                ArrayList<Item> itemsArray = (ArrayList<Item>) artistList.getArtists().getItems();
                ArtistsAdapter adaptador = new ArtistsAdapter(getBaseContext(), itemsArray);
                list.setAdapter(adaptador);

            }

            @Override
            public void onFailure(Throwable t) {
                Toast.makeText(
                        getApplicationContext(),
                        "ERROR: " + t.getMessage(),
                        Toast.LENGTH_LONG
                ).show();
            }
        });
    }
}
