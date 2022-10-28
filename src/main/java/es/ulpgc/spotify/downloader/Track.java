package es.ulpgc.spotify.downloader;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;

public class Track {
    private ArrayList<Artist> artists;
    private ArrayList<String> availableMarkets;
    private Integer discNumber;
    private Integer durationMs;
    private boolean explicit;
    private Map<String, String> external_Urls;
    private String id;
    private boolean isLocal;
    private String name;
    private String previewUrl;
    private Integer trackNumber;
    private String type;
    private String uri;

    public Track(ArrayList<Artist> artists, ArrayList<String> availableMarkets, Integer discNumber, Integer durationMs, boolean explicit, Map<String, String> external_Urls, String id, boolean isLocal, String name, String previewUrl, Integer trackNumber, String type, String uri) {
        this.artists = artists;
        this.availableMarkets = availableMarkets;
        this.discNumber = discNumber;
        this.durationMs = durationMs;
        this.explicit = explicit;
        this.external_Urls = external_Urls;
        this.id = id;
        this.isLocal = isLocal;
        this.name = name;
        this.previewUrl = previewUrl;
        this.trackNumber = trackNumber;
        this.type = type;
        this.uri = uri;
    }

    public ArrayList<Artist> getArtists() {
        return artists;
    }

    public ArrayList<String> getAvailableMarkets() {
        return availableMarkets;
    }

    public Integer getDiscNumber() {
        return discNumber;
    }

    public Integer getDurationMs() {
        return durationMs;
    }

    public boolean isExplicit() {
        return explicit;
    }

    public Map<String, String> getExternal_Urls() {
        return external_Urls;
    }

    public String getId() {
        return id;
    }

    public boolean isLocal() {
        return isLocal;
    }

    public String getName() {
        return name;
    }

    public String getPreviewUrl() {
        return previewUrl;
    }

    public Integer getTrackNumber() {
        return trackNumber;
    }

    public String getType() {
        return type;
    }

    public String getUri() {
        return uri;
    }
}
