package by.instinctools.megamag.data.menu.local;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import by.instinctools.megamag.Application;
import by.instinctools.megamag.common.database.menu.MenuContract;
import by.instinctools.megamag.common.database.menu.MenuDbHelper;
import by.instinctools.megamag.data.menu.MenuData;
import by.instinctools.megamag.data.menu.MenuDataSource;

abstract class LocalMenuDataSource implements MenuDataSource {

    @NonNull
    MenuDbHelper dbHelper = new MenuDbHelper(Application.getAppContext());

    @NonNull
    List<MenuData> getMenusFromDb(int targetId) {
        String selection = MenuContract.COLUMN_NAME_TARGET_ID + " = " + targetId;

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
        if (cursor.getCount() != 0) {
            while (!cursor.isLast()) {
                cursor.moveToNext();
                resultList.add(MenuData.builder()
                        .menuId(cursor.getInt(0))
                        .title(cursor.getString(1))
                        .targetId(cursor.getInt(2))
                        .build());
            }
        }
        db.close();
        return resultList;
    }
}
