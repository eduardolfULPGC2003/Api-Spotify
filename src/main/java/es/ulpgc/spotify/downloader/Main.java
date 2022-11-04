package es.ulpgc.spotify.downloader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;

import static javax.management.remote.JMXConnectorFactory.connect;

public class Main {

    public static void main(String[] args) throws Exception {
        ArrayList<String> urlArtists = new ArrayList<>();
        //urlArtists.add("3oZa8Xs6IjlIUGLAhVyK4G");
        urlArtists.add("6qGkLCMQkNGOJ079iEcC5k");
        //urlArtists.add("4LbuSjHhhAddvN44qXpRJo");
        //urlArtists.add("5MmVJVhhYKQ86izuGHzJYA");
        //urlArtists.add("47BNWfpngeFHYvBlPPyraM");
        //urlArtists.add("6zFYqv1mOsgBRQbae3JJ9e");
        //urlArtists.add("7H55rcKCfwqkyDFH9wpKM6");
        SpotifyAccessor accessor = new SpotifyAccessor();
        //System.out.println(json);
        String dbPath = "C:\\Users\\Eduardo\\IdeaProjects\\spotify_2\\spotify.db";
        try(Connection conn = connect(dbPath)) {
            Statement statement = conn.createStatement();
            String columns = "ArtistID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "Name TEXT NOT NULL, " +
                    "Followers INTEGER, " +
                    "Genres TEXT NOT NULL, " +
                    "Popularity INTEGER, " +
                    "ID TEXT NOT NULL, " +
                    "Uri TEXT";
            Table.create("artists",columns,statement);
            statement.execute("CREATE TABLE IF NOT EXISTS albums (" +
                    "AlbumID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "ArtistID INTEGER NOT NULL, " +
                    "Name TEXT NOT NULL, " +
                    "ReleaseDate TEXT NOT NULL, " +
                    "TotalTracks INTEGER NOT NULL, " +
                    "AvailableMarkets TEXT NOT NULL, " +
                    "ID TEXT NOT NULL, " +
                    "Uri TEXT" +
                    ")");
            statement.execute("CREATE TABLE IF NOT EXISTS tracks (" +
                    "TrackID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "AlbumID INTEGER NOT NULL, " +
                    "Name TEXT NOT NULL, " +
                    "TrackNumber INTEGER NOT NULL, " +
                    "DurationMs INTEGER NOT NULL, " +
                    "AvailableMarkets TEXT NOT NULL, " +
                    "ID TEXT NOT NULL, " +
                    "Uri TEXT" +
                    ")");
            for (String urlArtist : urlArtists) {
                String json = accessor.get("/artists/" + urlArtist, Collections.emptyMap());
                Artist artist = new Gson().fromJson(json, Artist.class);
                Table.insertArtist(artist,statement);
                String json2 = accessor.get("/artists/" + urlArtist + "/albums?include_groups=album", Collections.emptyMap());
                GetAlbum getAlbum = new Gson().fromJson(json2, GetAlbum.class);
                ArrayList<Album> albums = getAlbum.getItems();
                for (Album album : albums) {
                    System.out.println(new Gson().toJson(album));
                    ResultSet resultSet = statement.executeQuery("SELECT ArtistID FROM artists WHERE ID='" + artist.getId() + "'");
                    Table.insertAlbum(album, resultSet.getInt("ArtistID"), conn);
                    String idAlbum = album.getId();
                    String json3 = accessor.get("/albums/" + idAlbum + "/tracks", Collections.emptyMap());
                    GetTrack getTrack = new Gson().fromJson(json3, GetTrack.class);
                    ArrayList<Track> tracks = getTrack.getItems();
                    System.out.println("Hello world");

                    for (Track track : tracks) {
                        resultSet = statement.executeQuery("SELECT AlbumID FROM albums WHERE ID=\"" + album.getId() + "\"");
                        System.out.println(new Gson().toJson(track));
                        Table.insertTrack(track, resultSet.getInt("AlbumID"),conn);
                    }


                }
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

    //TODO
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

    /*
        statement.execute("INSERT INTO tracks (AlbumID,Name,TrackNumber,DurationMs,AvailableMarkets,ID,Uri) VALUES (" +
            resultSet.getInt("AlbumID") + "," +
            "\"" + track.getName() + "\"," +
            track.getTrackNumber() + "," +
            track.getDurationMs() + "," +
            "'" + track.getAvailableMarkets().toString() + "'," +
            "'" + track.getId() + "'," +
            "'" + track.getUri() + "'" +
        ")");
   */

    /*
        String secuencia = "INSERT INTO albums (ArtistID,Name,ReleaseDate,TotalTracks,AvailableMarkets,ID,Uri) VALUES ("+
                resultSet.getInt("ArtistID") + "," +
                "\"" + album.getName() + "\"," +
                "'" + album.getReleaseDate() + "'," +
                album.getTotalTracks() + "," +
                "'" + album.getAvailableMarkets().toString() + "'," +
                "'" + album.getId() + "'," +
                "'" + album.getUri() + "'" +
                ")";
        statement.execute(secuencia);
     */
}
