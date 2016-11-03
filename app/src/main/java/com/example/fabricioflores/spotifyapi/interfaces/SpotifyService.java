package com.example.fabricioflores.spotifyapi.interfaces;


import com.example.fabricioflores.spotifyapi.models.ArtistResponse;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by fabricioflores on 3/11/16.
 */

public interface SpotifyService {
    @GET("search?type=artist")
    Call<ArtistResponse> listArtists(@Query("q") String artist);
}
