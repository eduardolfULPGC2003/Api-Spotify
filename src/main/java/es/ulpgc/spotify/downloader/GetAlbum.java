package es.ulpgc.spotify.downloader;

import java.util.ArrayList;

public class GetAlbum {
    private final String href;
    private final ArrayList<Album> items;
    private final Integer limit;
    private final String next;
    private final Integer offset;
    private final String previous;
    private final Integer total;

    public GetAlbum(String href, ArrayList<Album> items, Integer limit, String next, Integer offset, String previous, Integer total) {
        this.href = href;
        this.items = items;
        this.limit = limit;
        this.next = next;
        this.offset = offset;
        this.previous = previous;
        this.total = total;
    }

    public String getHref() {
        return href;
    }

    public ArrayList<Album> getItems() {
        return items;
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
