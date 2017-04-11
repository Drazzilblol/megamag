package by.instinctools.megamag.data;

import android.support.annotation.NonNull;

import java.util.Map;

import io.reactivex.Observable;

public interface DataSource<K, V> {

    Observable<V> getValue(@NonNull K key);

    Observable<V> saveValue(@NonNull K key, @NonNull V value);

    Observable<Map<K, ?>> getAll();

    Observable<Map<K, V>> saveAll(Map<K, V> collection);
}
