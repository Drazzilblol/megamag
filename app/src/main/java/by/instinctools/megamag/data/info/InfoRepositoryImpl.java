package by.instinctools.megamag.data.info;

import android.support.annotation.NonNull;

import java.util.List;

import io.reactivex.Observable;

public class InfoRepositoryImpl implements InfoRepository {

    @NonNull
    InfoDataSource dataSource = new RemoteInfoDataSource();

    @Override
    public Observable<List<InfoData>> getInfoList() {
        return dataSource.getAll();
    }
}
