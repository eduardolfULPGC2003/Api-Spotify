package es.ulpgc.spotify.downloader;

import java.util.Collections;

public class Main {

    public static void main(String[] args) throws Exception {
        SpotifyAccessor accessor = new SpotifyAccessor();
        String json = accessor.get("/albums/7LUMQHRWTTILN7yR6LJwHR/tracks", Collections.emptyMap());
        System.out.println(json);
        System.out.println("Hello");
        System.out.println("Hello");
    }

    //TO DO
    //List<Artist> getArtists(...) filtering by some criteria
    //List<Album> getAlbums(artist)
    //List<Track> getTracks(artist),

}
