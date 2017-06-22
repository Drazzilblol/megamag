package by.instinctools.megamag.presentation.event_details.event_sessions.models;

import by.instinctools.megamag.domain.models.EventSession;

public class Time extends Node {

    private int count;

    private String day;

    public Time(EventSession session, int count) {
        super(session.getSessionId());
        this.data = session.getTime();
        this.day = session.getDay();
        this.count = count;
    }

    @Override
    public String getData() {
        return data;
    }

    public String getDay() {
        return day;
    }

    public int getCount() {
        return count;
    }
}
