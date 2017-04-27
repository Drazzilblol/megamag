package by.instinctools.megamag.data.info;

import java.util.List;

import by.instinctools.megamag.data.Repository;
import io.reactivex.Observable;

public interface InfoRepository extends Repository {

    Observable<List<InfoData>> getInfoList();
}
