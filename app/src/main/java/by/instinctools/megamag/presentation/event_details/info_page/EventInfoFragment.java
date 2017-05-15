package by.instinctools.megamag.presentation.event_details.info_page;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;

import by.instinctools.megamag.common.errors.Error;

public class EventInfoFragment extends MvpAppCompatFragment implements EventInfoView{

    @InjectPresenter
    EventInfoPresenterImpl presenter;

    @Override
    public void showError(@NonNull Error error) {

    }

    @Override
    public void hideError() {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }
}
