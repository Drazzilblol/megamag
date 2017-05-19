package by.instinctools.megamag.data.event_details_info;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

public class RemoteEventInfoDataSource implements EventInfoDataSource {
    @NonNull
    @Override
    public Observable<EventInfoData> getValue(@NonNull String key) {
        throw new UnsupportedOperationException();
    }

    @NonNull
    @Override
    public Observable<EventInfoData> saveValue(@NonNull String key, @NonNull EventInfoData value) {
        throw new UnsupportedOperationException();
    }

    @NonNull
    @Override
    public Observable<List<EventInfoData>> getAll() {
        return getStubEventData();
    }

    @NonNull
    @Override
    public Observable<List<EventInfoData>> saveAll(List<EventInfoData> collection) {
        throw new UnsupportedOperationException();
    }

    private Observable<List<EventInfoData>> getStubEventData() {
        List<EventInfoData> list = new ArrayList<>();
        list.add(EventInfoData.builder()
                .details("Год: 2017\n" +
                        "Страна: США\n" +
                        "режиссер: Джеймс Ганн\n" +
                        "Сценарий: Джеймс Ганн, Стив Энглхарт, Steve Gan\n" +
                        "Продюсер: Виктория Алонсо, Луис Д’Эспозито, Кевин Файги\n" +
                        "Жанр: фантастика, боевик, приключения\n" +
                        "Время: 137 мин. / 02:17\n" +
                        "В ролях: Крис Пратт, Зои Салдана, Дэйв Батиста, Вин Дизель, Брэдли Купер, Майкл Рукер, Карен Гиллан, Пом Клементьефф, Сильвестр Сталлоне, Курт Рассел" +
                        "Страна: США\n" +
                        "режиссер: Джеймс Ганн\n" +
                        "Сценарий: Джеймс Ганн, Стив Энглхарт, Steve Gan\n" +
                        "Продюсер: Виктория Алонсо, Луис Д’Эспозито, Кевин Файги\n" +
                        "Жанр: фантастика, боевик, приключения\n" +
                        "Время: 137 мин. / 02:17\n" +
                        "В ролях: Крис Пратт, Зои Салдана, Дэйв Батиста, Вин Дизель, Брэдли Купер, Майкл Рукер, Карен Гиллан, Пом Клементьефф, Сильвестр Сталлоне, Курт Рассел")
                .description("Все в сборе: землянин Питер Квилл (Звездный Лорд), молчаливый громила Дракс, зеленокожая наемница Гамора, живое дерево Грут и говорящий енот. Герои не изменяют себе и с завидной регулярностью продолжают попадать в немыслимые ситуации, выпутываясь из них почти без ущерба (а иногда даже с пользой) для окружающих. На этот раз им предстоит раскрыть одну из самых главных тайн во всей Галактике: кто же на самом деле отец Питера Квилла?")
                .build());
        return Observable.just(list);
    }
}
