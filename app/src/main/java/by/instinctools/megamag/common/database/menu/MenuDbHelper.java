package by.instinctools.megamag.common.database.menu;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import by.instinctools.megamag.common.database.CommonContract;

public class MenuDbHelper extends SQLiteOpenHelper {

    private static final String SQL_CREATE_MENUS =
            "CREATE TABLE " + MenuContract.TABLE_NAME + " (" +
                    MenuContract.COLUMN_NAME_MENU_ID + " INTEGER PRIMARY KEY," +
                    MenuContract.COLUMN_NAME_TITLE + " TEXT, " +
                    MenuContract.COLUMN_NAME_TARGET_ID + " INTEGER" +
                    MenuContract.COLUMN_NAME_ICON_RES_ID + " INTEGER" + " )";

    private static final String SQL_DELETE_MENUS =
            "DROP TABLE IF EXISTS " + MenuContract.TABLE_NAME;

    public MenuDbHelper(Context context) {
        super(context, CommonContract.DATABASE_NAME, null, CommonContract.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_MENUS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_MENUS);
        onCreate(db);
    }
}
