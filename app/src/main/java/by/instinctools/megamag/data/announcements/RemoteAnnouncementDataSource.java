package by.instinctools.megamag.data.announcements;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import hugo.weaving.DebugLog;
import io.reactivex.Observable;

class RemoteAnnouncementDataSource implements AnnouncementDataSource {

    @Override
    public Observable<AnnouncementData> getValue(@NonNull String key) {
        return null;
    }

    @Override
    public Observable<AnnouncementData> saveValue(@NonNull String key, @NonNull AnnouncementData value) {
        return null;
    }

    @DebugLog
    @Override
    public Observable<List<AnnouncementData>> getAll() {
        return Observable.just(getStubAnnouncements());
    }

    @Override
    public Observable<List<AnnouncementData>> saveAll(List<AnnouncementData> collection) {
        return null;
    }

    private List<AnnouncementData> getStubAnnouncements() {
        List<AnnouncementData> announcements = new ArrayList<>();
        announcements.add(AnnouncementData.create("Затерянный город Z",
                "Анонсы ",
                "Год: 2016\n" +
                        "Страна: США",
                "Эльдорадо, таинственная столица инков, загадочный Город Z… Вымысел или реальность? В 1925 году экспедиция полковника Фоссета, члена Королевского Географического общества, бесследно исчезла в джунглях Амазонии в поисках Города Z…",
                "http://kinoteatr.megamag.by/images/newsdesk_img/zateryanniy_gorod_b1.jpg"));
        announcements.add(AnnouncementData.create("Затерянный город Z",
                "Анонсы ",
                "Год: 2016\n" +
                        "Страна: США",
                "Эльдорадо, таинственная столица инков, загадочный Город Z… Вымысел или реальность? В 1925 году экспедиция полковника Фоссета, члена Королевского Географического общества, бесследно исчезла в джунглях Амазонии в поисках Города Z…",
                "http://kinoteatr.megamag.by/images/newsdesk_img/zateryanniy_gorod_b1.jpg"));
        announcements.add(AnnouncementData.create("Затерянный город Z",
                "Анонсы ",
                "Год: 2016\n" +
                        "Страна: США",
                "Эльдорадо, таинственная столица инков, загадочный Город Z… Вымысел или реальность? В 1925 году экспедиция полковника Фоссета, члена Королевского Географического общества, бесследно исчезла в джунглях Амазонии в поисках Города Z…",
                "http://kinoteatr.megamag.by/images/newsdesk_img/zateryanniy_gorod_b1.jpg"));
        return announcements;
    }
}
