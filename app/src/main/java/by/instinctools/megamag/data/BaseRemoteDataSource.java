package by.instinctools.megamag.data;

import android.support.annotation.NonNull;

import java.util.List;

import io.reactivex.Observable;

public abstract class BaseRemoteDataSource<K, V> implements DataSource<K, V> {

    @NonNull
    @Override
    public Observable<V> getValue(@NonNull K key) {
        throw new UnsupportedOperationException();
    }

    @NonNull
    @Override
    public Observable<V> saveValue(@NonNull K key, @NonNull V value) {
        throw new UnsupportedOperationException();
    }

    @NonNull
    @Override
    public Observable<List<V>> saveAll(List<V> collection) {
        throw new UnsupportedOperationException();
    }

    @NonNull
    @Override
    public Observable<List<V>> getAll() {
        throw new UnsupportedOperationException();
    }
}
