package by.instinctools.megamag.data.announcements;

import android.support.annotation.NonNull;

import java.util.List;

import by.instinctools.megamag.Application;
import hugo.weaving.DebugLog;
import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;

class RemoteAnnouncementDataSource implements AnnouncementDataSource {

    @NonNull
    @Override
    public Observable<AnnouncementData> getValue(@NonNull String key) {
        throw new UnsupportedOperationException();
    }

    @NonNull
    @Override
    public Observable<AnnouncementData> saveValue(@NonNull String key, @NonNull AnnouncementData value) {
        throw new UnsupportedOperationException();
    }

    @NonNull
    @DebugLog
    @Override
    public Observable<List<AnnouncementData>> getAll() {
        return getAnnouncements();
    }

    @NonNull
    @Override
    public Observable<List<AnnouncementData>> saveAll(List<AnnouncementData> collection) {
        throw new UnsupportedOperationException();
    }

    private Observable<List<AnnouncementData>> getAnnouncements() {
        Call<ResponseBody> call = Application.getApi().getData();

        return Observable.defer(() -> Observable.just(call.execute()))
                .flatMap(Observable::just)
                .map(r -> AnnouncementParser.parseAnnouncements(r.body().string()));
    }
}
