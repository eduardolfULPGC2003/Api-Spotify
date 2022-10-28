package es.ulpgc.spotify.downloader;

import java.util.ArrayList;

public class GetAlbum {
    private final String href;
    private final ArrayList<Album> albums;
    private final Integer limit;
    private final String next;
    private final Integer offset;
    private final String previous;
    private final Integer total;

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
