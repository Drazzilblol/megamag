package by.instinctools.megamag.presentation.main.tickets;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.PresenterType;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import by.instinctools.megamag.R;
import by.instinctools.megamag.common.errors.Error;
import by.instinctools.megamag.common.utils.Navigator;
import by.instinctools.megamag.domain.models.Ticket;
import by.instinctools.megamag.presentation.common.decorator.OffsetItemDecorator;
import by.instinctools.megamag.presentation.main.callbacks.OnItemClickListener;
import by.instinctools.megamag.presentation.main.tickets.adapter.TicketsListAdapter;
import hugo.weaving.DebugLog;

public class TicketsFragment extends MvpAppCompatFragment implements TicketsView, OnItemClickListener {

    @BindView(R.id.tickets_recycler_view)
    RecyclerView recyclerView;

    @BindView(R.id.tickets_error_view)
    TextView errorView;

    @BindView(R.id.tickets_progress_bar)
    ContentLoadingProgressBar progressBar;

    @InjectPresenter(type = PresenterType.GLOBAL)
    TicketsPresenter ticketsPresenter;

    @NonNull
    private TicketsListAdapter adapter = new TicketsListAdapter(this);

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
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        OffsetItemDecorator itemDecorator = new OffsetItemDecorator(
                getContext(),
                R.dimen.ticket_list_item_offset
        );
        recyclerView.addItemDecoration(itemDecorator);

        recyclerView.setAdapter(adapter);
    }

    @Override
    public void showData(@NonNull List<Ticket> ticketsList) {
        adapter.changeItems(ticketsList);
        recyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideData() {
        recyclerView.setVisibility(View.GONE);
    }

    @Override
    public void goToDetailsScreen(String detailsId) {
        Navigator.goToEventDetailsScreen(this.getContext(), detailsId);
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
        progressBar.show();
    }

    @Override
    public void hideProgress() {
        progressBar.hide();
    }

    @Override
    public void onClick(String itemId) {
        ticketsPresenter.onTicketItemClick(itemId);
    }
}
