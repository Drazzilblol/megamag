package by.instinctools.megamag.data.info;

import android.support.annotation.NonNull;

import java.util.List;

import io.reactivex.Observable;

public class InfoRepositoryImpl implements InfoRepository {

    @NonNull
    private InfoDataSource dataSource = new RemoteInfoDataSource();

    @NonNull
    @Override
    public Observable<List<InfoData>> getInfoList(int infoId) {
        return dataSource.getAll(infoId);
    }
}
