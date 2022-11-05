package es.ulpgc.spotify.downloader;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.sql.SQLException;

public class Table {
    public static void create(String name, String columns, Statement statement) throws SQLException {
        statement.execute("CREATE TABLE IF NOT EXISTS " + name + "(" + columns + ")");
    }

    public static void insertArtist(Artist artist, Statement statement) throws SQLException {
        statement.execute("INSERT INTO artists (Name,Followers,Genres,Popularity,ID,Uri) VALUES ('" +
                artist.getName() + "'," +
                artist.getFollower().getTotal() + "," +
                "'" + artist.getGenres().toString() + "'," +
                artist.getPopularity() + "," +
                "'" + artist.getId() + "'," +
                "'" + artist.getUri() + "'" +
                ")");
    }

    public static void insertAlbum(Album album,Integer ArtistID,Connection conn) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO albums (ArtistID,Artists,Name,ReleaseDate,TotalTracks,AvailableMarkets,ID,Uri) " +
                "VALUES (?,?,?,?,?,?,?,?)");
        preparedStatement.setInt(1,ArtistID);
        preparedStatement.setString(2, album.getArtists());
        preparedStatement.setString(3,album.getName());
        preparedStatement.setString(4,album.getReleaseDate());
        preparedStatement.setInt(5,album.getTotalTracks());
        preparedStatement.setString(6,album.getAvailableMarkets().toString());
        preparedStatement.setString(7,album.getId());
        preparedStatement.setString(8,album.getUri());
        preparedStatement.execute();
        //preparedStatement.clearParameters();
    }

    public static void insertTrack(Track track, Integer AlbumID, Connection conn) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO tracks (AlbumID,Artists,Name,TrackNumber,DurationMs,AvailableMarkets,Explicit,ID,Uri) " +
                "VALUES (?,?,?,?,?,?,?,?,?)");
        preparedStatement.setInt(1,AlbumID);
        preparedStatement.setString(2, track.getArtists());
        preparedStatement.setString(3,track.getName());
        preparedStatement.setInt(4,track.getTrackNumber());
        preparedStatement.setInt(5,track.getDurationMs());
        preparedStatement.setString(6,track.getAvailableMarkets().toString());
        preparedStatement.setBoolean(7,track.isExplicit());
        preparedStatement.setString(8,track.getId());
        preparedStatement.setString(9,track.getUri());
        preparedStatement.execute();
        //preparedStatement.clearParameters();
    }
}
