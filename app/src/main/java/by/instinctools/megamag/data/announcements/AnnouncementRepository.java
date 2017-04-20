package by.instinctools.megamag.data.announcements;

import java.util.List;

import by.instinctools.megamag.data.Repository;
import io.reactivex.Observable;

public interface AnnouncementRepository extends Repository {

    Observable<List<AnnouncementData>> getAnnouncementList();
}
