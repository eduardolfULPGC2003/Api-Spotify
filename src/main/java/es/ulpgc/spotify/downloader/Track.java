package es.ulpgc.spotify.downloader;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;

public class Track {
    private ArrayList<Artist> artists;
    private ArrayList<String> available_markets;
    private Integer disc_number;
    private Integer duration_ms;
    private boolean explicit;
    private Map<String, String> external_urls;
    private String id;
    private boolean is_local;
    private String name;
    private String preview_url;
    private Integer track_number;
    private String type;
    private String uri;

    public Track(ArrayList<Artist> artists, ArrayList<String> availableMarkets, Integer discNumber, Integer durationMs, boolean explicit, Map<String, String> external_Urls, String id, boolean isLocal, String name, String previewUrl, Integer trackNumber, String type, String uri) {
        this.artists = artists;
        this.available_markets = availableMarkets;
        this.disc_number = discNumber;
        this.duration_ms = durationMs;
        this.explicit = explicit;
        this.external_urls = external_Urls;
        this.id = id;
        this.is_local = isLocal;
        this.name = name;
        this.preview_url = previewUrl;
        this.track_number = trackNumber;
        this.type = type;
        this.uri = uri;
    }

    public ArrayList<Artist> getArtists() {
        return artists;
    }

    public ArrayList<String> getAvailableMarkets() {
        return available_markets;
    }

    public Integer getDiscNumber() {
        return disc_number;
    }

    public Integer getDurationMs() {
        return duration_ms;
    }

    public boolean isExplicit() {
        return explicit;
    }

    public Map<String, String> getExternal_Urls() {
        return external_urls;
    }

    public String getId() {
        return id;
    }

    public boolean isLocal() {
        return is_local;
    }

    public String getName() {
        return name;
    }

    public String getPreviewUrl() {
        return preview_url;
    }

    public Integer getTrackNumber() {
        return track_number;
    }

    public String getType() {
        return type;
    }

    public String getUri() {
        return uri;
    }
}
