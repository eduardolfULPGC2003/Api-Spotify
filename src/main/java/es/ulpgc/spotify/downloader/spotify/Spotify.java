package es.ulpgc.spotify.downloader.spotify;

import com.google.gson.Gson;
import es.ulpgc.spotify.downloader.MusicStreaming;
import es.ulpgc.spotify.downloader.spotify.*;
import es.ulpgc.spotify.downloader.spotify.access.SpotifyAccessor;

import java.util.ArrayList;
import java.util.Collections;

public class Spotify implements MusicStreaming {
    private static SpotifyAccessor accessor;

    static {
        try {
            accessor = new SpotifyAccessor();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Artist getArtist(String urlArtist) throws Exception {
        String json = accessor.get("/artists/" + urlArtist, Collections.emptyMap());
        return new Gson().fromJson(json, Artist.class);
    }

    public ArrayList<Album> getAlbum(String urlArtist) throws Exception {
        String json2 = accessor.get("/artists/" + urlArtist + "/albums?include_groups=album&limit=50", Collections.emptyMap());
        GetAlbum getAlbum = new Gson().fromJson(json2, GetAlbum.class);
        return getAlbum.getItems();
    }

    public ArrayList<Track> getTrack(String idAlbum) throws Exception {
        String json3 = accessor.get("/albums/" + idAlbum + "/tracks?limit=50", Collections.emptyMap());
        GetTrack getTrack = new Gson().fromJson(json3, GetTrack.class);
        return getTrack.getItems();
    }
}
