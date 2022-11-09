package es.ulpgc.spotify.downloader.spotify;

import es.ulpgc.spotify.downloader.spotify.Artist;

import java.util.ArrayList;
import java.util.Map;

public class Track {
    private final ArrayList<Artist> artists;
    private final ArrayList<String> available_markets;
    private final Integer disc_number;
    private final Integer duration_ms;
    private final boolean explicit;
    private final Map<String, String> external_urls;
    private final String id;
    private final boolean is_local;
    private final String name;
    private final String preview_url;
    private final Integer track_number;
    private final String type;
    private final String uri;

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

    public String getName() {
        return name;
    }

    public Integer getTrackNumber() {
        return track_number;
    }

    public String getUri() {
        return uri;
    }
}
