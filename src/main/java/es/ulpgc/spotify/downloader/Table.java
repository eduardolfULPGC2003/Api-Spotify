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
        PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO albums (ArtistID,Name,ReleaseDate,TotalTracks,AvailableMarkets,ID,Uri) " +
                "VALUES (?,?,?,?,?,?,?)");
        preparedStatement.setInt(1,ArtistID);
        preparedStatement.setString(2,album.getName());
        preparedStatement.setString(3,album.getReleaseDate());
        preparedStatement.setInt(4,album.getTotalTracks());
        preparedStatement.setString(5,album.getAvailableMarkets().toString());
        preparedStatement.setString(6,album.getId());
        preparedStatement.setString(7,album.getUri());
        preparedStatement.execute();
        //preparedStatement.clearParameters();
    }

    public static void insertTrack(Track track, Integer AlbumID, Connection conn) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO tracks (AlbumID,Name,TrackNumber,DurationMs,AvailableMarkets,ID,Uri) " +
                "VALUES (?,?,?,?,?,?,?)");
        preparedStatement.setInt(1,AlbumID);
        preparedStatement.setString(2,track.getName());
        preparedStatement.setInt(3,track.getTrackNumber());
        preparedStatement.setInt(4,track.getDurationMs());
        preparedStatement.setString(5,track.getAvailableMarkets().toString());
        preparedStatement.setString(6,track.getId());
        preparedStatement.setString(7,track.getUri());
        preparedStatement.execute();
        //preparedStatement.clearParameters();
    }
}
