package es.ulpgc.spotify.downloader;

import es.ulpgc.spotify.downloader.spotify.Artist;
import es.ulpgc.spotify.downloader.spotify.Album;
import es.ulpgc.spotify.downloader.spotify.Spotify;
import es.ulpgc.spotify.downloader.spotify.Track;
import es.ulpgc.spotify.downloader.sql.SQL;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        DataBase db = new SQL();
        MusicStreaming sp = new Spotify();
        List<String> urlArtists = new ArrayList<>();
        urlArtists.add("2IqcwWZoG2iCPE9CkHMO8f");
        urlArtists.add("7EK1bQADBoqbYXnT4Cqv9w");
        urlArtists.add("6qGkLCMQkNGOJ079iEcC5k");
        urlArtists.add("5MmVJVhhYKQ86izuGHzJYA");
        urlArtists.add("1JbemQ1fPt2YmSLjAFhPBv");
        urlArtists.add("6zFYqv1mOsgBRQbae3JJ9e");
        urlArtists.add("0JDkhL4rjiPNEp92jAgJnS");
        String dbPath = "C:\\Users\\Eduardo\\IdeaProjects\\spotify_2\\spotify.db";
        try(Connection conn = connect(dbPath)) {
            Statement statement = conn.createStatement();
            for (String urlArtist : urlArtists) {
                Artist artist = sp.getArtist(urlArtist);
                db.add(artist,conn);
                List<Album> albums = sp.getAlbum(urlArtist);
                for (Album album : albums) {
                    ResultSet resultSet = statement.executeQuery("SELECT ArtistID FROM artists WHERE ID='" + artist.getId() + "'");
                    db.add(album, resultSet.getInt("ArtistID"), conn);
                    String idAlbum = album.getId();
                    List<Track> tracks = sp.getTrack(idAlbum);
                    for (Track track : tracks) {
                        resultSet = statement.executeQuery("SELECT AlbumID FROM albums WHERE ID=\"" + album.getId() + "\"");
                        db.add(track, resultSet.getInt("AlbumID"),conn);
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static Connection connect(String dbPath) {
        Connection conn;
        try {
            String url = "jdbc:sqlite:" + dbPath;
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }

    //TODO
    //List<Artist> getArtists(...) filtering by some criteria
    //List<Album> getAlbums(artist)
    //List<Track> getTracks(artist)
}
