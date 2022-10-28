package es.ulpgc.spotify.downloader;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws Exception {
        SpotifyAccessor accessor = new SpotifyAccessor();
        String json = accessor.get("/artists/4LbuSjHhhAddvN44qXpRJo/albums?include_groups=album", Collections.emptyMap());
        System.out.println(json);
        GetAlbum prueba = new Gson().fromJson(json, GetAlbum.class);
        ArrayList<Album> albums = prueba.getItems();
        for (Album album : albums) {
            System.out.println(album.getId());
        }
    }

    //TO DO
    //List<Artist> getArtists(...) filtering by some criteria
    //List<Album> getAlbums(artist)
    //List<Track> getTracks(artist),

    //String prueba = "https://open.spotify.com/album/0TYKKzAVX7gjUYtovNTFNE";
    //String busqueda =  "/albums/" + prueba.substring(prueba.indexOf("album/")+6) + "/tracks";
    //String json = accessor.get(busqueda, Collections.emptyMap());
    //System.out.println(json);
}
