package by.instinctools.megamag.presentation.event_details.event_sessions.models;

import by.instinctools.megamag.domain.models.EventSession;

public class Time extends Node {

    private int count;

    private String day;

    public Time(EventSession session, int count) {
        super(session.getSessionId(), session.getTime());
        this.day = session.getDay();
        this.count = count;
    }

    public String getDay() {
        return day;
    }

    public int getCount() {
        return count;
    }
}
