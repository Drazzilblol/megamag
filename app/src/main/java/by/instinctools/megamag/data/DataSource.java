package by.instinctools.megamag.data;

import android.support.annotation.NonNull;

import java.util.List;

import io.reactivex.Observable;

public interface DataSource<K, V> {

    @NonNull
    Observable<V> getValue(@NonNull K key);

    @NonNull
    Observable<V> saveValue(@NonNull K key, @NonNull V value);

    @NonNull
    Observable<List<V>> getAll();

    @NonNull
    Observable<List<V>> saveAll(List<V> collection);
}
