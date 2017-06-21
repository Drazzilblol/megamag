package by.instinctools.megamag.presentation.event_details.event_sessions.models;

public class Day extends Node {
    public Day(String id, String day) {
        super(id);
        this.data = day;
    }

    @Override
    public String getData() {
        return data;
    }
}
