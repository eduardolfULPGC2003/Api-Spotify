package es.ulpgc.spotify.downloader;

import com.google.gson.Gson;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;

import static javax.management.remote.JMXConnectorFactory.connect;

public class Main {

    public static void main(String[] args) throws Exception {
        ArrayList<String> urlArtists = new ArrayList<>();
        urlArtists.add("3oZa8Xs6IjlIUGLAhVyK4G");
        urlArtists.add("4LbuSjHhhAddvN44qXpRJo");
        urlArtists.add("5MmVJVhhYKQ86izuGHzJYA");
        urlArtists.add("47BNWfpngeFHYvBlPPyraM");
        urlArtists.add("7H55rcKCfwqkyDFH9wpKM6");
        SpotifyAccessor accessor = new SpotifyAccessor();
        //System.out.println(json);
        String dbPath = "C:\\Users\\Eduardo\\IdeaProjects\\spotify_2\\spotify.db";
        try(Connection conn = connect(dbPath)) {
            Statement statement = conn.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS artists (" +
                    "ArtistID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "Name TEXT NOT NULL, " +
                    "Followers INTEGER, " +
                    "Genres TEXT NOT NULL, " +
                    "Popularity INTEGER, " +
                    "Uri TEXT" +
                    ")");
            for (String urlArtist : urlArtists) {
                String json = accessor.get("/artists/" + urlArtist, Collections.emptyMap());
                Artist artist = new Gson().fromJson(json, Artist.class);
                statement.execute("INSERT INTO artists (name,followers,genres,popularity,uri) VALUES ('" +
                        artist.getName() + "'," +
                        artist.getFollower().getTotal() + "," +
                        "'" + artist.getGenres().toString() + "'," +
                        artist.getPopularity() + "," +
                        "'" + artist.getUri() + "'" +
                        ")");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static Connection connect(String dbPath) {
        Connection conn = null;
        try {
            String url = "jdbc:sqlite:" + dbPath;
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }

    //TO DO
    //List<Artist> getArtists(...) filtering by some criteria
    //List<Album> getAlbums(artist)
    //List<Track> getTracks(artist),

    //String prueba = "https://open.spotify.com/album/0TYKKzAVX7gjUYtovNTFNE";
    //String busqueda =  "/albums/" + prueba.substring(prueba.indexOf("album/")+6) + "/tracks";
    //String json = accessor.get(busqueda, Collections.emptyMap());
    //System.out.println(json);

    //Se consigue también con el id del album

    //GetAlbum prueba = new Gson().fromJson(json, GetAlbum.class);
    //ArrayList<Album> albums = prueba.getItems();
    //for (Album album : albums) {
    //System.out.println(album.getId());
    //}
}
