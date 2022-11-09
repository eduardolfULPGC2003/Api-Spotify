package es.ulpgc.spotify.downloader;

import es.ulpgc.spotify.downloader.spotify.Artist;
import es.ulpgc.spotify.downloader.spotify.Album;
import es.ulpgc.spotify.downloader.spotify.Track;

import java.util.ArrayList;

public interface MusicStreaming {
    Artist getArtist(String urlArtist) throws Exception;
    ArrayList<Album> getAlbum(String urlArtist) throws Exception;
    ArrayList<Track> getTrack(String idAlbum) throws Exception;
}
