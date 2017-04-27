package by.instinctools.megamag.data.info;

import android.support.annotation.NonNull;

import java.util.List;

import io.reactivex.Observable;

public class RemoteInfoDataSource implements InfoDataSource {

    @Override
    public Observable<InfoData> getValue(@NonNull String key) {
        return null;
    }

    @Override
    public Observable<InfoData> saveValue(@NonNull String key, @NonNull InfoData value) {
        return null;
    }

    @Override
    public Observable<List<InfoData>> getAll() {
        return null;
    }

    @Override
    public Observable<List<InfoData>> saveAll(List<InfoData> collection) {
        return null;
    }
}
