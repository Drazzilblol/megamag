package by.instinctools.megamag.data.info;

import android.support.annotation.NonNull;

import java.util.List;

import by.instinctools.megamag.data.BaseRemoteDataSource;
import io.reactivex.Observable;

abstract class InfoDataSource extends BaseRemoteDataSource<String, InfoData> {

    @NonNull
    public abstract Observable<List<InfoData>> getAll(int infoId);
}
