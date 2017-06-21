package by.instinctools.megamag.presentation.event_details.event_sessions.models;

public class Time extends Node {

    private int count;

    public Time(String id, String time, int count) {
        super(id);
        this.data = time;
        this.count = count;
    }

    @Override
    public String getData() {
        return data;
    }

    public int getCount() {
        return count;
    }
}
