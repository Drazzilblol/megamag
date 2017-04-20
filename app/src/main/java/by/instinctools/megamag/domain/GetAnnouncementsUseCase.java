package by.instinctools.megamag.domain;

import android.support.annotation.NonNull;

import java.util.List;

import by.instinctools.megamag.data.announcements.AnnouncementRepository;
import by.instinctools.megamag.data.announcements.AnnouncementRepositoryImpl;
import by.instinctools.megamag.domain.models.AnnouncementViewModel;
import by.instinctools.megamag.domain.models.AnnouncementViewModelImpl;
import hugo.weaving.DebugLog;
import io.reactivex.Observable;

public class GetAnnouncementsUseCase implements UseCase<List<AnnouncementViewModel>> {

    @NonNull
    private AnnouncementRepository repository = new AnnouncementRepositoryImpl();

    @DebugLog
    @Override
    public Observable<List<AnnouncementViewModel>> execute() {
        return repository.getAnnouncementList()
                .flatMap(Observable::fromIterable)
                .map(announcement -> AnnouncementViewModelImpl.create(
                        announcement.getDetails(),
                        announcement.getDescription()
                        )
                )
                .toList()
                .toObservable();
    }
}
