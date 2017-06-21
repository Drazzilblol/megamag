package by.instinctools.megamag.presentation.event_details.event_sessions.models;

public class Place extends Node {
    public Place(String id, String place) {
        super(id);
        this.data = place;
    }

    @Override
    public String getData() {
        return data;
    }
}
