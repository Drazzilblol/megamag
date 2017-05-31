package by.instinctools.megamag.data.announcements;

import android.support.annotation.NonNull;

import java.util.List;

import by.instinctools.megamag.Application;
import by.instinctools.megamag.data.BaseRemoteDataSource;
import hugo.weaving.DebugLog;
import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;

class RemoteAnnouncementDataSource extends BaseRemoteDataSource<String, AnnouncementData> {

    @NonNull
    @DebugLog
    @Override
    public Observable<List<AnnouncementData>> getAll() {
        return getAnnouncements();
    }

    @NonNull
    private Observable<List<AnnouncementData>> getAnnouncements() {
        Call<ResponseBody> call = Application.getApi().getData();

        return Observable.defer(() -> Observable.just(call.execute()))
                .flatMap(Observable::just)
                .map(r -> AnnouncementParser.parseAnnouncements(r.body().string()));
    }
}
