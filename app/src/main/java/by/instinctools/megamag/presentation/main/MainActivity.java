package by.instinctools.megamag.presentation.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import by.instinctools.megamag.R;
import by.instinctools.megamag.common.errors.Error;

public class MainActivity extends AppCompatActivity implements MainView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public void showError(Error error) {

    }

    @Override
    public void showProgress(boolean show) {

    }
}
