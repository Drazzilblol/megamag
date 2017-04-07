package by.instinctools.megamag.presentation.info;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import by.instinctools.megamag.presentation.MVPPresenter;

interface InfoPresenter extends MVPPresenter {
    static final int HOW_TO_BOOK = 0;
    static final int HOW_TO_PAY = 1;
    static final int CONTACT_US = 2;
    static final int RULES = 3;

    @IntDef({HOW_TO_BOOK, HOW_TO_PAY, CONTACT_US, RULES})
    @Retention(RetentionPolicy.SOURCE)
    @interface ViewTypes {
    }

    void onCreate(@ViewTypes int activityType);
}
