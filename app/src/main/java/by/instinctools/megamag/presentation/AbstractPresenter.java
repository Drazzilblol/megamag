package by.instinctools.megamag.presentation;

public abstract class AbstractPresenter<V extends BaseView> implements BasePresenter {
    private V view;

    @Override
    public void attach(Object view) {
        this.view = (V) view;
    }

    @Override
    public void detach() {
        view = null;
    }

    public V getView() {
        return view;
    }
}
