package by.instinctools.megamag.data;

import android.support.annotation.NonNull;

import java.util.List;

import io.reactivex.Observable;

public interface DataSource<K, V> {

    Observable<V> getValue(@NonNull K key);

    Observable<V> saveValue(@NonNull K key, @NonNull V value);

    Observable<List<V>> getAll();

    Observable<List<V>> saveAll(List<V> collection);
}
