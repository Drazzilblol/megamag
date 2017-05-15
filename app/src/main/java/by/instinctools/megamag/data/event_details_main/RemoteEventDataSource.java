package by.instinctools.megamag.data.event_details_main;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

public class RemoteEventDataSource implements EventDataSource {

    @NonNull
    @Override
    public Observable<EventData> getValue(@NonNull String key) {
        throw new UnsupportedOperationException();
    }

    @NonNull
    @Override
    public Observable<EventData> saveValue(@NonNull String key, @NonNull EventData value) {
        throw new UnsupportedOperationException();
    }

    @NonNull
    @Override
    public Observable<List<EventData>> getAll() {
        return getStubEventData();
    }

    @NonNull
    @Override
    public Observable<List<EventData>> saveAll(List<EventData> collection) {
        throw new UnsupportedOperationException();
    }

    private Observable<List<EventData>> getStubEventData() {
        List<EventData> list = new ArrayList<>();
        list.add(EventData.builder()
                .title("Стражи Галактики. Часть 2")
                .coverUrl("http://kinoteatr.megamag.by/images/newsdesk_img/strazhi_galaktiki_2_b1.jpg")
                .build());
        return Observable.just(list);
    }
}
