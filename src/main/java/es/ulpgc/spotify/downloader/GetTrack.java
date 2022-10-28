package es.ulpgc.spotify.downloader;

import java.util.ArrayList;

public class GetTrack {
    private String href;
    private ArrayList<Track> items;
    private Integer limit;
    private String next;
    private Integer offset;
    private String previous;
    private Integer total;

    public GetTrack(String href, ArrayList<Track> items, Integer limit, String next, Integer offset, String previous, Integer total) {
        this.href = href;
        this.items = items;
        this.limit = limit;
        this.next = next;
        this.offset = offset;
        this.previous = previous;
        this.total = total;
    }

    public ArrayList<Track> getItems() {
        return items;
    }

    public Integer getTotal() {
        return total;
    }
}
