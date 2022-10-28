package es.ulpgc.spotify.downloader;

import java.util.ArrayList;
import java.util.Map;

public class Artist {
    private final Map<String, String> externalUrls;
    private final Follower follower;
    private final ArrayList<String> genres;
    private final String  href;
    private final String id;
    private final ArrayList<Image> images;
    private final String name;
    private final Integer popularity;
    private final String type;
    private final String uri;

    public Artist(Map<String, String> externalUrls, Follower follower, ArrayList<String> genres, String href, String id, ArrayList<Image> images, String name, Integer popularity, String type, String uri) {
        this.externalUrls = externalUrls;
        this.follower = follower;
        this.genres = genres;
        this.href = href;
        this.id = id;
        this.images = images;
        this.name = name;
        this.popularity = popularity;
        this.type = type;
        this.uri = uri;
    }

    public Map<String, String> getExternalUrls() {
        return externalUrls;
    }

    public Follower getFollower() {
        return follower;
    }

    public ArrayList<String> getGenres() {
        return genres;
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

    public Integer getPopularity() {
        return popularity;
    }

    public String getType() {
        return type;
    }

    public String getUri() {
        return uri;
    }

    public class Follower{
        private String href;
        private Integer total;


        public Follower(String href, Integer total) {
            this.href = href;
            this.total = total;
        }

        public String getHref() {
            return href;
        }

        public Integer getTotal() {
            return total;
        }
    }

}
