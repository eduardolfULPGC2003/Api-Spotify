package es.ulpgc.spotify.downloader;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public interface DataBase {
    static void create(String name, String fields, Statement statement){};
    void add(Artist artist, Connection conn) throws SQLException;
    void add(Album album,Integer ArtistID,Connection conn) throws SQLException;
    void add(Track track, Integer AlbumID, Connection conn) throws SQLException;
}
