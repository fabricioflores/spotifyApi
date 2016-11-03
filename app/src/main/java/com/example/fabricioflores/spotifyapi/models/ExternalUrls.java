
package com.example.fabricioflores.spotifyapi.models;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class ExternalUrls {

    @SerializedName("spotify")
    @Expose
    private String spotify;

    /**
     * No args constructor for use in serialization
     *
     */
    public ExternalUrls() {
    }

    /**
     *
     * @param spotify
     */
    public ExternalUrls(String spotify) {
        this.spotify = spotify;
    }

    /**
     *
     * @return
     *     The spotify
     */
    public String getSpotify() {
        return spotify;
    }

    /**
     *
     * @param spotify
     *     The spotify
     */
    public void setSpotify(String spotify) {
        this.spotify = spotify;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
