package es.ulpgc.spotify.downloader;

import com.google.gson.Gson;

import java.sql.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {
        ArrayList<String> urlArtists = new ArrayList<>();
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
                Artist artist = Spotify.getArtist(urlArtist);
                DataBase.add(artist,conn);
                ArrayList<Album> albums = Spotify.getAlbum(urlArtist);
                for (Album album : albums) {
                    //System.out.println(new Gson().toJson(album));
                    ResultSet resultSet = statement.executeQuery("SELECT ArtistID FROM artists WHERE ID='" + artist.getId() + "'");
                    DataBase.add(album, resultSet.getInt("ArtistID"), conn);
                    String idAlbum = album.getId();
                    ArrayList<Track> tracks = Spotify.getTrack(idAlbum);
                    for (Track track : tracks) {
                        resultSet = statement.executeQuery("SELECT AlbumID FROM albums WHERE ID=\"" + album.getId() + "\"");
                        System.out.println(new Gson().toJson(track));
                        DataBase.add(track, resultSet.getInt("AlbumID"),conn);
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
