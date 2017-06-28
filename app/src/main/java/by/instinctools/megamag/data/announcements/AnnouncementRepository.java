package by.instinctools.megamag.data.announcements;

import android.support.annotation.NonNull;

import java.util.List;

import by.instinctools.megamag.data.Repository;
import io.reactivex.Observable;

public interface AnnouncementRepository extends Repository {

    @NonNull
    Observable<List<AnnouncementData>> getAnnouncementList(@NonNull String pageNumber);
}
