
package com.example.fabricioflores.spotifyapi.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class ArtistResponse {

    @SerializedName("artists")
    @Expose
    private Artists artists;

    /**
     * No args constructor for use in serialization
     *
     */
    public ArtistResponse() {
    }

    /**
     *
     * @param artists
     */
    public ArtistResponse(Artists artists) {
        this.artists = artists;
    }

    /**
     *
     * @return
     *     The artists
     */
    public Artists getArtists() {
        return artists;
    }

    /**
     *
     * @param artists
     *     The artists
     */
    public void setArtists(Artists artists) {
        this.artists = artists;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
