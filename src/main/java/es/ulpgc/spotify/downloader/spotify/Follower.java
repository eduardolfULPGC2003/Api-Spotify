package es.ulpgc.spotify.downloader.spotify;

public class Follower {
    private String href;
    private int total;

    public Follower(String href, Integer total) {
        this.href = href;
        this.total = total;
    }

    public String getHref() {
        return href;
    }

    public int getTotal() {
        return total;
    }

}
