package es.ulpgc.spotify.downloader;

import java.util.ArrayList;

public class GetAlbum {
    private String href;
    private ArrayList<Album> albums;
    private Integer limit;
    private String next;
    private Integer offset;
    private String previous;
    private Integer total;

    public GetAlbum(String href, ArrayList<Album> albums, Integer limit, String next, Integer offset, String previous, Integer total) {
        this.href = href;
        this.albums = albums;
        this.limit = limit;
        this.next = next;
        this.offset = offset;
        this.previous = previous;
        this.total = total;
    }

    public String getHref() {
        return href;
    }

    public ArrayList<Album> getAlbums() {
        return albums;
    }

    public Integer getLimit() {
        return limit;
    }

    public String getNext() {
        return next;
    }

    public Integer getOffset() {
        return offset;
    }

    public String getPrevious() {
        return previous;
    }

    public Integer getTotal() {
        return total;
    }
}
