package es.ulpgc.spotify.downloader.spotify;

public class Image {
    private String url;

    private Integer height;

    private Integer width;
    public Image(String url, Integer height, Integer width) {
        this.url = url;
        this.height = height;
        this.width = width;
    }

    public String getUrl() {
        return url;
    }

    public Integer getHeight() {
        return height;
    }

    public Integer getWidth() {
        return width;
    }
}
