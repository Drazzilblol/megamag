package by.instinctools.megamag.data.menu;

import android.support.annotation.NonNull;

import java.util.List;

import by.instinctools.megamag.data.Repository;
import io.reactivex.Observable;

public interface MenuRepository extends Repository {

    @NonNull
    Observable<List<MenuData>> getMenuList();
}
