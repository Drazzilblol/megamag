package by.instinctools.megamag.common.database.menu;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import by.instinctools.megamag.Application;
import by.instinctools.megamag.R;
import by.instinctools.megamag.common.database.CommonContract;
import by.instinctools.megamag.data.announcements.AnnouncementDataSource;
import by.instinctools.megamag.data.info.InfoDataSource;

public class MenuDbHelper extends SQLiteOpenHelper {

    private static final String SQL_CREATE_MENUS =
            "CREATE TABLE " + MenuContract.TABLE_NAME + " (" +
                    MenuContract.COLUMN_NAME_MENU_ID + " INTEGER PRIMARY KEY," +
                    MenuContract.COLUMN_NAME_TITLE + " TEXT, " +
                    MenuContract.COLUMN_NAME_TARGET_ID + " INTEGER" + " )";

    private static final String SQL_DELETE_MENUS =
            "DROP TABLE IF EXISTS " + MenuContract.TABLE_NAME;

    public MenuDbHelper(Context context) {
        super(context, CommonContract.DATABASE_NAME, null, CommonContract.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_MENUS);
        createData(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_MENUS);
        onCreate(db);
    }

    private void createData(SQLiteDatabase db) {
        Context context = Application.getAppContext();
        ContentValues values1 = new ContentValues();
        values1.put(MenuContract.COLUMN_NAME_MENU_ID, InfoDataSource.HOW_PAY);
        values1.put(MenuContract.COLUMN_NAME_TITLE, context.getString(R.string.drawer_menu_how_to_pay));
        values1.put(MenuContract.COLUMN_NAME_TARGET_ID, InfoDataSource.INFO_GROUP_ID);

        db.insert(MenuContract.TABLE_NAME, null, values1);

        ContentValues values2 = new ContentValues();
        values2.put(MenuContract.COLUMN_NAME_MENU_ID, InfoDataSource.HOW_BOOK);
        values2.put(MenuContract.COLUMN_NAME_TITLE, context.getString(R.string.drawer_menu_how_to_book));
        values2.put(MenuContract.COLUMN_NAME_TARGET_ID, InfoDataSource.INFO_GROUP_ID);

        db.insert(MenuContract.TABLE_NAME, null, values2);

        ContentValues values3 = new ContentValues();
        values3.put(MenuContract.COLUMN_NAME_MENU_ID, InfoDataSource.RULES);
        values3.put(MenuContract.COLUMN_NAME_TITLE, context.getString(R.string.drawer_menu_rules));
        values3.put(MenuContract.COLUMN_NAME_TARGET_ID, InfoDataSource.INFO_GROUP_ID);

        db.insert(MenuContract.TABLE_NAME, null, values3);

        ContentValues values4 = new ContentValues();
        values4.put(MenuContract.COLUMN_NAME_MENU_ID, AnnouncementDataSource.ANNOUNCEMENT_ID);
        values4.put(MenuContract.COLUMN_NAME_TITLE, context.getString(R.string.drawer_menu_announcements));
        values4.put(MenuContract.COLUMN_NAME_TARGET_ID, AnnouncementDataSource.ANNOUNCEMENT_GROUP_ID);

        db.insert(MenuContract.TABLE_NAME, null, values4);

        ContentValues values5 = new ContentValues();
        values5.put(MenuContract.COLUMN_NAME_MENU_ID, AnnouncementDataSource.TICKET_ID);
        values5.put(MenuContract.COLUMN_NAME_TITLE, context.getString(R.string.drawer_menu_tickets));
        values5.put(MenuContract.COLUMN_NAME_TARGET_ID, AnnouncementDataSource.ANNOUNCEMENT_GROUP_ID);

        db.insert(MenuContract.TABLE_NAME, null, values5);

        ContentValues values6 = new ContentValues();
        values6.put(MenuContract.COLUMN_NAME_MENU_ID, 300);
        values6.put(MenuContract.COLUMN_NAME_TITLE, "Космос");
        values6.put(MenuContract.COLUMN_NAME_TARGET_ID, 1002);

        db.insert(MenuContract.TABLE_NAME, null, values6);

        ContentValues values7 = new ContentValues();
        values7.put(MenuContract.COLUMN_NAME_MENU_ID, 301);
        values7.put(MenuContract.COLUMN_NAME_TITLE, "Красная Звезда");
        values7.put(MenuContract.COLUMN_NAME_TARGET_ID, 1002);

        db.insert(MenuContract.TABLE_NAME, null, values7);

        ContentValues values8 = new ContentValues();
        values8.put(MenuContract.COLUMN_NAME_MENU_ID, 302);
        values8.put(MenuContract.COLUMN_NAME_TITLE, "Октябрь");
        values8.put(MenuContract.COLUMN_NAME_TARGET_ID, 1002);

        db.insert(MenuContract.TABLE_NAME, null, values8);

        ContentValues values9 = new ContentValues();
        values9.put(MenuContract.COLUMN_NAME_MENU_ID, 303);
        values9.put(MenuContract.COLUMN_NAME_TITLE, "Драмматический Театр");
        values9.put(MenuContract.COLUMN_NAME_TARGET_ID, 1002);

        db.insert(MenuContract.TABLE_NAME, null, values9);

        ContentValues values10 = new ContentValues();
        values10.put(MenuContract.COLUMN_NAME_MENU_ID, 304);
        values10.put(MenuContract.COLUMN_NAME_TITLE, "Театр Кукол");
        values10.put(MenuContract.COLUMN_NAME_TARGET_ID, 1002);

        db.insert(MenuContract.TABLE_NAME, null, values10);
    }
}
