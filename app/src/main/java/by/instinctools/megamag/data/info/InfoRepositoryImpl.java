package by.instinctools.megamag.data.info;

import android.support.annotation.NonNull;

import java.util.List;

import io.reactivex.Observable;

public class InfoRepositoryImpl implements InfoRepository {

    @NonNull
    private RemoteInfoDataSource dataSource = new RemoteInfoDataSource();

    @Override
    public Observable<List<InfoData>> getInfoList(String infoId) {
        return dataSource.getAll(infoId);
    }
}
