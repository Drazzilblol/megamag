package by.instinctools.megamag.presentation.event_details.event_sessions.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import by.instinctools.megamag.R;
import by.instinctools.megamag.domain.models.EventSession;
import by.instinctools.megamag.presentation.common.decorator.OffsetItemDecorator;
import by.instinctools.megamag.presentation.event_details.event_sessions.adapter.session_adapter.ConcreteSessionListAdapter;

class SessionsHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.details_concrete_sessions_recycler)
    RecyclerView recyclerView;

    @NonNull
    private ConcreteSessionListAdapter concreteSessionListAdapter = new ConcreteSessionListAdapter();

    private static View inflateView(@NonNull ViewGroup parent) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        return inflater.inflate(R.layout.item_details_sessions, parent, false);
    }

    SessionsHolder(@NonNull ViewGroup parent) {
        super(inflateView(parent));
        ButterKnife.bind(this, itemView);
        initRecyclerView();
    }

    void bindData(@NonNull List<EventSession> sessions) {
        concreteSessionListAdapter.addItems(sessions);
    }

    private void initRecyclerView() {
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        OffsetItemDecorator itemDecorator = new OffsetItemDecorator(
                itemView.getContext(),
                R.dimen.announcement_list_item_offset
        );
        recyclerView.addItemDecoration(itemDecorator);

        recyclerView.setNestedScrollingEnabled(false);

        recyclerView.setAdapter(concreteSessionListAdapter);

    }
}
