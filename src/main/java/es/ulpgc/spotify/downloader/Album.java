package es.ulpgc.spotify.downloader;

import java.util.ArrayList;
import java.util.Map;

public class Album {
    private final String albumGroup;
    private final String albumType;
    private final ArrayList<Artist> artistas;
    private final ArrayList<String> availableMarkets;
    private final Map<String, String> externalUrls;
    private final String href;
    private final String id;
    private final ArrayList<Image> images;
    private final String name;
    private final String releaseDate;
    private final String releaseDatePrecision;
    private final Integer totalTracks;
    private final String type;
    private final String uri;

    public Album(String albumGroup, String albumType, ArrayList<Artist> artistas, ArrayList<String> availableMarkets, Map<String, String> externalUrls, String href, String id, ArrayList<Image> images, String name, String releaseDate, String releaseDatePrecision, Integer totalTracks, String type, String uri) {
        this.albumGroup = albumGroup;
        this.albumType = albumType;
        this.artistas = artistas;
        this.availableMarkets = availableMarkets;
        this.externalUrls = externalUrls;
        this.href = href;
        this.id = id;
        this.images = images;
        this.name = name;
        this.releaseDate = releaseDate;
        this.releaseDatePrecision = releaseDatePrecision;
        this.totalTracks = totalTracks;
        this.type = type;
        this.uri = uri;
    }

    public String getAlbumGroup() {
        return albumGroup;
    }

    public String getAlbumType() {
        return albumType;
    }

    public ArrayList<Artist> getArtistas() {
        return artistas;
    }

    public ArrayList<String> getAvailableMarkets() {
        return availableMarkets;
    }

    public Map<String, String> getExternalUrls() {
        return externalUrls;
    }

    public String getHref() {
        return href;
    }

    public String getId() {
        return id;
    }

    public ArrayList<Image> getImages() {
        return images;
    }

    public String getName() {
        return name;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getReleaseDatePrecision() {
        return releaseDatePrecision;
    }

    public Integer getTotalTracks() {
        return totalTracks;
    }

    public String getType() {
        return type;
    }

    public String getUri() {
        return uri;
    }
}
