package by.instinctools.megamag.data.announcements;

import android.support.annotation.NonNull;

import java.util.List;

import by.instinctools.megamag.Application;
import by.instinctools.megamag.data.BaseRemoteDataSource;
import hugo.weaving.DebugLog;
import io.reactivex.Observable;

class RemoteAnnouncementDataSource extends BaseRemoteDataSource<String, AnnouncementData> {

    @NonNull
    @DebugLog
    public Observable<List<AnnouncementData>> getAll(@NonNull String pageNumber) {
        return getAnnouncements(pageNumber);
    }

    @NonNull
    private Observable<List<AnnouncementData>> getAnnouncements(@NonNull String pageNumber) {

        return Application.getApiGson()
                .getPage("number_of_pages=0&current_page_number=" + pageNumber + "&max_page_links=7&action=default&lang_file=newsdesk_index.php")
                .map(AnnouncementParser::parseAnnouncements);
    }
}
