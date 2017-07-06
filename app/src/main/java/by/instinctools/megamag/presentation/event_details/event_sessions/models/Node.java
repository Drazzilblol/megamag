package by.instinctools.megamag.presentation.event_details.event_sessions.models;


public abstract class Node {

    private String id;

    protected String data;

    public Node(String id, String data) {
        this.id = id;
        this.data = data;
    }

    public String getId() {
        return id;
    }

    public String getData(){
        return data;
    };
}
