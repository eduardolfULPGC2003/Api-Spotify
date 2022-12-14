package es.ulpgc.spotify.downloader.spotify;

import java.util.ArrayList;
import java.util.Map;

public class Album {
    private final String album_group;
    private final String album_type;
    private final ArrayList<Artist> artists;
    private final ArrayList<String> available_markets;
    private final Map<String, String> external_urls;
    private final String href;
    private final String id;
    private final ArrayList<Image> images;
    private final String name;
    private final String release_date;
    private final String release_date_precision;
    private final Integer total_tracks;
    private final String type;
    private final String uri;

    public Album(String albumGroup, String albumType, ArrayList<Artist> artists, ArrayList<String> availableMarkets, Map<String, String> externalUrls, String href, String id, ArrayList<Image> images, String name, String releaseDate, String releaseDatePrecision, Integer totalTracks, String type, String uri) {
        this.album_group = albumGroup;
        this.album_type = albumType;
        this.artists = artists;
        this.available_markets = availableMarkets;
        this.external_urls = externalUrls;
        this.href = href;
        this.id = id;
        this.images = images;
        this.name = name;
        this.release_date = releaseDate;
        this.release_date_precision = releaseDatePrecision;
        this.total_tracks = totalTracks;
        this.type = type;
        this.uri = uri;
    }

    public String getArtists() {
        if (artists.size() == 1) return artists.get(0).getName();
        ArrayList<String> artistsName = new ArrayList<>();
        for (Artist artist : artists) {
            artistsName.add(artist.getName());
        }
        return artistsName.toString();
    }

    public ArrayList<String> getAvailableMarkets() {
        return available_markets;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getReleaseDate() {
        return release_date;
    }

    public Integer getTotalTracks() {
        return total_tracks;
    }

    public String getUri() {
        return uri;
    }
}
