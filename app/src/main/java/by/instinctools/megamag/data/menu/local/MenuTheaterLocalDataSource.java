package by.instinctools.megamag.data.menu.local;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import by.instinctools.megamag.Application;
import by.instinctools.megamag.common.database.menu.MenuContract;
import by.instinctools.megamag.common.database.menu.MenuDbHelper;
import by.instinctools.megamag.common.factory.GroupTypeFactory;
import by.instinctools.megamag.data.BaseLocalDataSource;
import by.instinctools.megamag.data.menu.MenuData;
import by.instinctools.megamag.data.type.GroupType;
import by.instinctools.megamag.data.type.ItemType;
import io.reactivex.Observable;
import timber.log.Timber;

public class MenuTheaterLocalDataSource extends BaseLocalDataSource<String, MenuData> {

    @NonNull
    private MenuDbHelper dbHelper = new MenuDbHelper(Application.getAppContext());

    @NonNull
    @Override
    public Observable<List<MenuData>> getAll() {
        try {
            List<MenuData> list = getMenusFromDb(GroupTypeFactory.getTheaterGroupType().getId());
            return Observable.just(list);
        } catch (Exception e) {
            Timber.e(e);
            return Observable.error(e);
        }
    }

    @NonNull
    @Override
    public Observable<List<MenuData>> saveAll(List<MenuData> collection) {
        try {
            saveMenusToDb(collection);
            return Observable.just(collection);
        } catch (Exception e) {
            Timber.e(e);
            return Observable.error(e);
        }
    }

    private void saveMenusToDb(List<MenuData> collection) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        db.beginTransaction();
        for (MenuData menudata : collection) {
            ContentValues values = new ContentValues();
            values.put(MenuContract.COLUMN_NAME_MENU_ID, menudata.getType().getId());
            values.put(MenuContract.COLUMN_NAME_TITLE, menudata.getTitle());
            values.put(MenuContract.COLUMN_NAME_TARGET_ID, menudata.getGroupType().getId());
            values.put(MenuContract.COLUMN_NAME_ICON_RES_ID, menudata.getIcon());
            db.insert(MenuContract.TABLE_NAME, null, values);
        }
        db.setTransactionSuccessful();
        db.endTransaction();
    }

    @NonNull
    private List<MenuData> getMenusFromDb(int targetId) {
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
                        .type(new ItemType(cursor.getInt(0)))
                        .title(cursor.getString(1))
                        .groupType(new GroupType(cursor.getInt(2)))
                        .icon(cursor.getInt(3))
                        .build());
            }
        }
        cursor.close();
        return resultList;
    }
}
