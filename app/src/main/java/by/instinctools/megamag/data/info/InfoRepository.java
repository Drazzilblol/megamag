package by.instinctools.megamag.data.info;

import android.support.annotation.NonNull;

import java.util.List;

import by.instinctools.megamag.data.Repository;
import io.reactivex.Observable;

public interface InfoRepository extends Repository {

    @NonNull
    Observable<List<InfoData>> getInfoList(String infoId);
}
