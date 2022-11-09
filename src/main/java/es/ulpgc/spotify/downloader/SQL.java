package es.ulpgc.spotify.downloader;

import com.google.gson.Gson;

import java.sql.*;
import java.sql.SQLException;

public class SQL implements DataBase{
    private static boolean ArtistsTable = false;
    private static boolean AlbumsTable = false;
    private static boolean TracksTable = false;
    private static void create(String name, String fields, Statement statement) throws SQLException {
        statement.execute("CREATE TABLE " + name + "(" + fields + ")");
    }

    public void add(Artist artist, Connection conn) throws SQLException {
        Statement statement = conn.createStatement();
        if (!ArtistsTable){
            String fields = "ArtistID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "Name TEXT NOT NULL, " +
                    "Followers INTEGER, " +
                    "Genres TEXT NOT NULL, " +
                    "Popularity INTEGER, " +
                    "ID TEXT NOT NULL, " +
                    "Uri TEXT";
            SQL.create("artists",fields,statement);
            ArtistsTable = true;
        }
        System.out.println("Introducing into Artists: " + new Gson().toJson(artist));
        statement.execute("INSERT INTO artists (Name,Followers,Genres,Popularity,ID,Uri) VALUES ('" +
                artist.getName() + "'," +
                artist.getFollower().getTotal() + "," +
                "'" + artist.getGenres().toString() + "'," +
                artist.getPopularity() + "," +
                "'" + artist.getId() + "'," +
                "'" + artist.getUri() + "'" +
                ")");
    }

    public void add(Album album,Integer ArtistID,Connection conn) throws SQLException {
        if (!AlbumsTable){
            Statement statement = conn.createStatement();
            String fields = "AlbumID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "ArtistID INTEGER NOT NULL, " +
                    "Artists TEXT NOT NULL, " +
                    "Name TEXT NOT NULL, " +
                    "ReleaseDate TEXT NOT NULL, " +
                    "TotalTracks INTEGER NOT NULL, " +
                    "AvailableMarkets TEXT NOT NULL, " +
                    "ID TEXT NOT NULL, " +
                    "Uri TEXT";
            SQL.create("albums",fields,statement);
            AlbumsTable = true;
        }
        PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO albums (ArtistID,Artists,Name,ReleaseDate,TotalTracks,AvailableMarkets,ID,Uri) " +
                "VALUES (?,?,?,?,?,?,?,?)");
        System.out.println("Introducing into Albums: " + new Gson().toJson(album));
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

    public void add(Track track, Integer AlbumID, Connection conn) throws SQLException {
        if (!TracksTable){
            Statement statement = conn.createStatement();
            String fields = "TrackID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "AlbumID INTEGER NOT NULL, " +
                    "Artists TEXT NOT NULL, " +
                    "Name TEXT NOT NULL, " +
                    "TrackNumber INTEGER NOT NULL, " +
                    "DurationMs INTEGER NOT NULL, " +
                    "AvailableMarkets TEXT NOT NULL, " +
                    "Explicit BOOLEAN NOT NULL, " +
                    "ID TEXT NOT NULL, " +
                    "Uri TEXT";
            SQL.create("tracks",fields,statement);
            TracksTable = true;
        }
        PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO tracks (AlbumID,Artists,Name,TrackNumber,DurationMs,AvailableMarkets,Explicit,ID,Uri) " +
                "VALUES (?,?,?,?,?,?,?,?,?)");
        System.out.println("Introducing into Tracks: " + new Gson().toJson(track));
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
