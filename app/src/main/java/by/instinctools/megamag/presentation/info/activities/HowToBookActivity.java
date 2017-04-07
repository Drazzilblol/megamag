package by.instinctools.megamag.presentation.info.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import by.instinctools.megamag.R;
import by.instinctools.megamag.presentation.info.InfoPresenter;
import by.instinctools.megamag.presentation.info.InfoPresenterImpl;
import by.instinctools.megamag.presentation.info.InfoView;

public class HowToBookActivity extends AppCompatActivity implements InfoView {
    private InfoPresenterImpl infoPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_to_book);
        infoPresenter = new InfoPresenterImpl();
        infoPresenter.attach(this);
        infoPresenter.onCreate(InfoPresenter.HOW_TO_BOOK);
    }

    @Override
    public void setText() {

    }
}
