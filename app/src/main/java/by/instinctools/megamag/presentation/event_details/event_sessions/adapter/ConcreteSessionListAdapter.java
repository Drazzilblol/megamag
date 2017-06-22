package by.instinctools.megamag.presentation.event_details.event_sessions.adapter;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import by.instinctools.megamag.domain.models.EventSession;
import by.instinctools.megamag.presentation.event_details.event_sessions.models.Day;
import by.instinctools.megamag.presentation.event_details.event_sessions.models.Node;
import by.instinctools.megamag.presentation.event_details.event_sessions.models.Place;
import by.instinctools.megamag.presentation.event_details.event_sessions.models.Time;

public class ConcreteSessionListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int PLACE = 0;
    public static final int DAY = 1;
    public static final int HALF_TIME = 2;
    public static final int FULL_TIME = 3;

    private final List<Node> nodes = new ArrayList<>();

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == PLACE) {
            return new ConcreteSessionPlaceHolder(parent);
        } else if (viewType == DAY) {
            return new ConcreteSessionDayHolder(parent);
        } else if (viewType == HALF_TIME || viewType == FULL_TIME) {
            return new ConcreteSessionTimeHolder(parent);
        }

        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof ConcreteSessionPlaceHolder) {
            ((ConcreteSessionPlaceHolder) holder).bindData(nodes.get(position).getData());
        }
        if (holder instanceof ConcreteSessionTimeHolder) {
            ((ConcreteSessionTimeHolder) holder).bindData(nodes.get(position).getData());
        }
        if (holder instanceof ConcreteSessionDayHolder) {
            ((ConcreteSessionDayHolder) holder).bindData(nodes.get(position).getData());
        }
    }

    @Override
    public int getItemViewType(int position) {
        Node node = nodes.get(position);
        if (node instanceof Place) {
            return PLACE;
        } else if (node instanceof Day) {
            return DAY;
        } else if (node instanceof Time) {
            Time time = (Time) node;
            if (((float) time.getCount()) % 2.0f != 0 && (nodes.size() - 1 == position || !(nodes.get(position + 1) instanceof Time))) {
                return FULL_TIME;
            } else {
                return HALF_TIME;
            }
        }
        return -1;
    }

    @Override
    public int getItemCount() {
        return nodes.size();
    }

    public void addItems(List<EventSession> list) {

        String day = "";
        String place = "";
        String hall = "";
        int counter = 0;

        for (EventSession session : list) {
            if (!TextUtils.equals(place, session.getPlace()) || !TextUtils.equals(hall, session.getHall())) {
                place = session.getPlace();
                hall = session.getHall();
                day = "";
                nodes.add(new Place(session.getSessionId(), place + "/" + hall));
            }
            if (!TextUtils.equals(day, session.getDay())) {
                day = session.getDay();

                counter = 0;
                nodes.add(new Day(session.getSessionId(), day));
            }

            counter++;
            nodes.add(new Time(session.getSessionId(), session.getTime(), counter));
        }
    }
}
