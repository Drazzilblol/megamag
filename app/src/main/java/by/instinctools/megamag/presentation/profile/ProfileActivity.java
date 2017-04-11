package by.instinctools.megamag.presentation.profile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import by.instinctools.megamag.R;
import by.instinctools.megamag.presentation.info.InfoActivity;

public class ProfileActivity extends AppCompatActivity {

    public static Intent createIntent(Context context) {
        return new Intent(context, ProfileActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }
}
