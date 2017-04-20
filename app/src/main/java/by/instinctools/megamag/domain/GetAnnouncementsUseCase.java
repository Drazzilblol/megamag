package by.instinctools.megamag.domain;

import android.support.annotation.NonNull;

import java.util.List;

import by.instinctools.megamag.data.announcements.AnnouncementRepository;
import by.instinctools.megamag.data.announcements.AnnouncementRepositoryImpl;
import by.instinctools.megamag.domain.common.converters.AnnouncementsListConverter;
import by.instinctools.megamag.domain.models.Announcement;
import hugo.weaving.DebugLog;
import io.reactivex.Observable;

public class GetAnnouncementsUseCase implements UseCase<List<Announcement>> {

    @NonNull
    private AnnouncementRepository repository = new AnnouncementRepositoryImpl();

    @DebugLog
    @Override
    public Observable<List<Announcement>> execute() {
        return repository.getAnnouncementList()
                .map(announcements -> new AnnouncementsListConverter().convert(announcements));
    }
}
