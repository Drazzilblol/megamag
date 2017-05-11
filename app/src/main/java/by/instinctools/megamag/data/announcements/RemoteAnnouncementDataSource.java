package by.instinctools.megamag.data.announcements;

import android.support.annotation.NonNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import by.instinctools.megamag.Application;
import hugo.weaving.DebugLog;
import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

class RemoteAnnouncementDataSource implements AnnouncementDataSource {

    @NonNull
    @Override
    public Observable<AnnouncementData> getValue(@NonNull String key) {
        return null;
    }

    @NonNull
    @Override
    public Observable<AnnouncementData> saveValue(@NonNull String key, @NonNull AnnouncementData value) {
        return null;
    }

    @NonNull
    @DebugLog
    @Override
    public Observable<List<AnnouncementData>> getAll() {
        return Observable.just(getStubAnnouncements());
    }

    @NonNull
    @Override
    public Observable<List<AnnouncementData>> saveAll(List<AnnouncementData> collection) {
        return null;
    }

    private List<AnnouncementData> getStubAnnouncements() {
        List<AnnouncementData> announcements = new ArrayList<>();
        announcements.add(AnnouncementData.builder()
                .title("Затерянный город Z")
                .place("Анонсы")
                .details("США (2016) боевик, драма, приключения, биография, история")
                .description("Эльдорадо, таинственная столица инков, загадочный Город Z… Вымысел или реальность? В 1925 году экспедиция полковника Фоссета, члена Королевского Географического общества, бесследно исчезла в джунглях Амазонии в поисках Города Z…")
                .coverUrl("http://kinoteatr.megamag.by/images/newsdesk_img/zateryanniy_gorod_b1.jpg")
                .build()
        );

        announcements.add(AnnouncementData.builder()
                .title("Пираты Карибского моря: Мертвецы не рассказывают сказки")
                .place("Анонсы")
                .details("Режиссер: Хоаким Роннинг, Эспен Сандберг")
                .description("Исчерпавший свою удачу капитан Джек Воробей обнаруживает, что за ним охотится его старый неприятель, ужасный капитан Салазар и его призрачные пираты. Они только что сбежали из Дьявольского треугольника и намерены уничтожить всех пиратов, включая Джека. Поможет спастись лишь могущественный артефакт — трезубец Посейдона, который дарует своему обладателю полный контроль над морями.")
                .coverUrl("http://kinoteatr.megamag.by/images/newsdesk_img/piraty_mertvecy_b1.jpg")
                .build()
        );

        return announcements;
    }


    private List<AnnouncementData> getAnnouncements() {
        Call<ResponseBody> response = Application.getApi().getData();
        response.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    Timber.d(response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
        return new ArrayList<>();
    }
}
