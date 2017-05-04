package by.instinctools.megamag.data.menu;

import android.support.annotation.NonNull;

import java.util.List;

import io.reactivex.Observable;

public class LocalMenuDataSource implements MenuDataSource {

    @NonNull
    @Override
    public Observable<MenuData> getValue(@NonNull String key) {
        return null;
    }

    @NonNull
    @Override
    public Observable<MenuData> saveValue(@NonNull String key, @NonNull MenuData value) {
        return null;
    }

    @NonNull
    @Override
    public Observable<List<MenuData>> getAll() {
        return null;
    }

    @NonNull
    @Override
    public Observable<List<MenuData>> saveAll(List<MenuData> collection) {
        return null;
    }
}
