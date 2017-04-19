package by.instinctools.megamag.domain;

import android.support.annotation.NonNull;

import java.util.List;

import by.instinctools.megamag.data.announcements.AnnouncementRepository;
import by.instinctools.megamag.data.announcements.AnnouncementRepositoryImpl;
import by.instinctools.megamag.domain.models.AnnouncementViewModel;
import by.instinctools.megamag.domain.models.AnnouncementViewModelImpl;
import io.reactivex.Observable;

public class GetAnnouncementsUseCase implements UseCase<List<AnnouncementViewModel>> {

    @NonNull
    private AnnouncementRepository repository = new AnnouncementRepositoryImpl();

    @Override
    public Observable<List<AnnouncementViewModel>> execute() {
        return repository.getAnnouncementList()
                .flatMap(Observable::fromIterable)
                .map(AnnouncementViewModelImpl::new)
                .map(a -> (AnnouncementViewModel) a)
                .toList()
                .toObservable();
    }
}
