package es.ulpgc.spotify.downloader;

import com.google.gson.Gson;

import java.util.Collections;

public class Main {

    public static void main(String[] args) throws Exception {
        SpotifyAccessor accessor = new SpotifyAccessor();
        String json = accessor.get("/artists/4LbuSjHhhAddvN44qXpRJo/albums?include_groups=album", Collections.emptyMap());
        System.out.println(json);
    }

    //TO DO
    //List<Artist> getArtists(...) filtering by some criteria
    //List<Album> getAlbums(artist)
    //List<Track> getTracks(artist),

}
