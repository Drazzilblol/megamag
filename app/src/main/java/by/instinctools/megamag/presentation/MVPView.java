package by.instinctools.megamag.presentation;

import by.instinctools.megamag.common.errors.Error;

public interface MVPView {
    void showError(Error error);
    void showProgress(boolean show);
}
