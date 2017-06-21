package by.instinctools.megamag.presentation.event_details.event_sessions.adapter.session_adapter;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import by.instinctools.megamag.domain.models.EventSession;

public class ConcreteSessionListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int PLACE = 0;
    private static final int DATE = 1;

    private final List<List<EventSession>> sessionList = new ArrayList<>();

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == PLACE) {
            return new ConcreteSessionPlaceHolder(parent);
        } else if (viewType == DATE) {
            return new ConcreteSessionDateHolder(parent);
        }

        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ConcreteSessionPlaceHolder) {
            ((ConcreteSessionPlaceHolder) holder).bindData(sessionList.get(0).get(0).getPlace() + "/" + sessionList.get(0).get(0).getHall());
        }
        if (holder instanceof ConcreteSessionDateHolder) {
            ((ConcreteSessionDateHolder) holder).bindData(sessionList.get(position - 1));
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return PLACE;
        } else {
            return DATE;
        }
    }

    @Override
    public int getItemCount() {
        return sessionList.size() + 1;
    }

    public void addItems(List<EventSession> list) {
        List<List<EventSession>> lists = new ArrayList<>();
        String day = "";
        for (EventSession session : list) {
            if (!TextUtils.equals(session.getDay(), day)) {
                day = session.getDay();
                List<EventSession> events = new ArrayList<>();
                for (EventSession session1 : list) {
                    if (TextUtils.equals(session1.getDay(), day)) {
                        events.add(session1);
                    }
                }
                lists.add(events);
            }
        }
        sessionList.addAll(lists);
    }
}
