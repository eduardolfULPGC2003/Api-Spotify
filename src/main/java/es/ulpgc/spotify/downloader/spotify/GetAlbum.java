package es.ulpgc.spotify.downloader.spotify;

import es.ulpgc.spotify.downloader.spotify.Album;

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

    public ArrayList<Album> getItems() {
        return items;
    }

    public Integer getTotal() {
        return total;
    }
}
