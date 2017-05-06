package by.instinctools.megamag.data.menu;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import by.instinctools.megamag.Application;
import by.instinctools.megamag.common.database.menu.MenuContract;
import by.instinctools.megamag.common.database.menu.MenuDbHelper;
import by.instinctools.megamag.data.info.InfoDataSource;
import io.reactivex.Observable;

public class LocalMenuInfoDataSource implements MenuDataSource {

    @NonNull
    private MenuDbHelper dbHelper = new MenuDbHelper(Application.getAppContext());

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
        return Observable.just(getInfoMenus());
    }

    @NonNull
    @Override
    public Observable<List<MenuData>> saveAll(List<MenuData> collection) {
        throw new UnsupportedOperationException();
    }

    private List<MenuData> getInfoMenus() {
        String selection = MenuContract.COLUMN_NAME_TARGET_ID + " = " + InfoDataSource.INFO_GROUP_ID;

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.query(
                MenuContract.TABLE_NAME,
                null,
                selection,
                null,
                null,
                null,
                null
        );

        List<MenuData> resultList = new ArrayList<>();
        while (!cursor.isLast()) {
            cursor.moveToNext();
            resultList.add(MenuData.builder()
                    .menuId(cursor.getInt(0))
                    .title(cursor.getString(1))
                    .targetId(cursor.getInt(2))
                    .build());
        }
        db.close();
        return resultList;
    }
}
