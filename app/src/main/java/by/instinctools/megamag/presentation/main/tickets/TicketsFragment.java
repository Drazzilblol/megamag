package by.instinctools.megamag.presentation.main.tickets;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import by.instinctools.megamag.R;
import by.instinctools.megamag.common.errors.Error;
import by.instinctools.megamag.domain.models.Ticket;
import by.instinctools.megamag.presentation.common.decorator.OffsetItemDecorator;
import by.instinctools.megamag.presentation.main.tickets.adapter.TicketsListAdapter;
import hugo.weaving.DebugLog;

public class TicketsFragment extends Fragment implements TicketsView {

    @BindView(R.id.tickets_recycler_view)
    RecyclerView recyclerView;

    @BindView(R.id.tickets_error_view)
    TextView errorView;

    @BindView(R.id.tickets_progress_bar)
    View progressBar;

    @NonNull
    private TicketsPresenter presenter = new TicketsPresenterImpl();

    @NonNull
    private TicketsListAdapter adapter = new TicketsListAdapter();

    public static TicketsFragment newInstance() {
        return new TicketsFragment();
    }

    @DebugLog
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_tickets, container, false);
        ButterKnife.bind(this, view);
        initRecyclerView();
        return view;
    }

    private void initRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(
                getContext(),
                LinearLayoutManager.VERTICAL,
                false)
        );
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new OffsetItemDecorator(
                getContext(),
                R.dimen.ticket_list_item_offset)
        );
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.attach(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        presenter.detach();
    }

    @Override
    public void showData(@NonNull List<Ticket> ticketsList) {
        adapter.setTickets(ticketsList);
        recyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideData() {
        recyclerView.setVisibility(View.GONE);
    }

    @Override
    public void showError(@NonNull Error error) {
        errorView.setText(error.getErrorMessage());
        errorView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideError() {
        errorView.setVisibility(View.GONE);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }
}
