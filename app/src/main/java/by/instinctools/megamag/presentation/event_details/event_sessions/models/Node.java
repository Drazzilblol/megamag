package by.instinctools.megamag.presentation.event_details.event_sessions.models;


public abstract class Node {

    private String id;

    protected String data;

    public Node(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public abstract String getData();
}
