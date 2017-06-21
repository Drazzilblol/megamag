package by.instinctools.megamag.domain;

import android.support.annotation.NonNull;

import by.instinctools.megamag.data.menu.MenuCommonRepositoryImpl;
import by.instinctools.megamag.data.menu.MenuData;
import hugo.weaving.DebugLog;
import io.reactivex.Observable;

public class GetAnnouncementTitleUseCase implements UseCase<String> {

    @NonNull
    private MenuCommonRepositoryImpl repository = new MenuCommonRepositoryImpl();

    @DebugLog
    public Observable<String> execute(int infoId) {
        return repository.getMenuAnnouncementItem(infoId)
                .map(MenuData::getTitle);
    }

    @Override
    public Observable<String> execute() {
        throw new UnsupportedOperationException();
    }
}
