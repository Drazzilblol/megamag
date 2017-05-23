package by.instinctools.megamag.common.factory;

import android.support.annotation.NonNull;

import by.instinctools.megamag.data.type.ItemType;

public final class ItemTypeFactory {

    private static final int REGION_ID = 400;
    private static final int ABOUT_ID = 401;
    private static final int SHARE_ID = 402;
    private static final int SETTINGS_ID = 404;

    private static final int ANNOUNCEMENTS_ID = 200;
    private static final int TICKET_ID = 201;

    private static final int HOW_PAY = 100;
    private static final int HOW_BOOK = 101;
    private static final int RULES = 102;
    private static final int SUPPORT_ID = 103;

    private static final int BASKET = 500;
    private static final int INFO = 501;
    private static final int HISTORY = 502;
    private static final int EDIT = 503;
    private static final int EXIT = 503;

    @NonNull
    public static ItemType getAboutType() {
        return new ItemType(ABOUT_ID);
    }

    @NonNull
    public static ItemType getAnnouncementsType() {
        return new ItemType(ANNOUNCEMENTS_ID);
    }

    @NonNull
    public static ItemType getTicketType() {
        return new ItemType(TICKET_ID);
    }

    @NonNull
    public static ItemType getRegionType() {
        return new ItemType(REGION_ID);
    }

    @NonNull
    public static ItemType getSettingsType() {
        return new ItemType(SETTINGS_ID);
    }

    @NonNull
    public static ItemType getShareType() {
        return new ItemType(SHARE_ID);
    }

    @NonNull
    public static ItemType getSupportType() {
        return new ItemType(SUPPORT_ID);
    }

    @NonNull
    public static ItemType getHowBookType() {
        return new ItemType(HOW_BOOK);
    }

    @NonNull
    public static ItemType getHowPayType() {
        return new ItemType(HOW_PAY);
    }

    @NonNull
    public static ItemType getRulesType() {
        return new ItemType(RULES);
    }

    @NonNull
    public static ItemType getBasketType() {
        return new ItemType(BASKET);
    }

    @NonNull
    public static ItemType getEditType() {
        return new ItemType(EDIT);
    }

    @NonNull
    public static ItemType getExitType() {
        return new ItemType(EXIT);
    }

    @NonNull
    public static ItemType getHistoryType() {
        return new ItemType(HISTORY);
    }

    @NonNull
    public static ItemType getInfoType() {
        return new ItemType(INFO);
    }
}
