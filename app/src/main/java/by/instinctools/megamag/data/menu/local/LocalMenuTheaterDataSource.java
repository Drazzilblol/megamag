package by.instinctools.megamag.data.menu.local;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

import java.util.List;

import by.instinctools.megamag.common.database.menu.MenuContract;
import by.instinctools.megamag.data.menu.MenuData;
import io.reactivex.Observable;

public class LocalMenuTheaterDataSource extends LocalMenuDataSource {

    @NonNull
    @Override
    public Observable<MenuData> getValue(@NonNull String key) {
        throw new UnsupportedOperationException();
    }

    @NonNull
    @Override
    public Observable<MenuData> saveValue(@NonNull String key, @NonNull MenuData value) {
        throw new UnsupportedOperationException();
    }

    @NonNull
    @Override
    public Observable<List<MenuData>> getAll() {
        return Observable.just(getMenusFromDb(1002));
    }

    @NonNull
    @Override
    public Observable<List<MenuData>> saveAll(List<MenuData> collection) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        db.beginTransaction();
        for (MenuData menudata : collection) {
            ContentValues values = new ContentValues();
            values.put(MenuContract.COLUMN_NAME_MENU_ID, menudata.getMenuId());
            values.put(MenuContract.COLUMN_NAME_TITLE, menudata.getTitle());
            values.put(MenuContract.COLUMN_NAME_TARGET_ID, menudata.getTargetId());
            db.insert(MenuContract.TABLE_NAME, null, values);
        }
        db.setTransactionSuccessful();
        db.endTransaction();

        return Observable.just(collection);
    }
}
