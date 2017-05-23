package by.instinctools.megamag.common.factory;

import android.support.annotation.NonNull;

import by.instinctools.megamag.data.type.ItemType;

public final class ItemTypeFactory {

    private static final ItemType REGION = new ItemType(400);
    private static final ItemType ABOUT = new ItemType(401);
    private static final ItemType SHARE = new ItemType(402);
    private static final ItemType SETTINGS = new ItemType(404);

    private static final ItemType ANNOUNCEMENTS = new ItemType(200);
    private static final ItemType TICKET = new ItemType(201);

    private static final ItemType HOW_PAY = new ItemType(100);
    private static final ItemType HOW_BOOK = new ItemType(101);
    private static final ItemType RULES = new ItemType(102);
    private static final ItemType SUPPORT_ID = new ItemType(103);

    private static final ItemType BASKET = new ItemType(500);
    private static final ItemType INFO = new ItemType(501);
    private static final ItemType HISTORY = new ItemType(502);
    private static final ItemType EDIT = new ItemType(503);
    private static final ItemType EXIT = new ItemType(503);

    @NonNull
    public static ItemType getAboutType() {
        return ABOUT;
    }

    @NonNull
    public static ItemType getAnnouncementsType() {
        return ANNOUNCEMENTS;
    }

    @NonNull
    public static ItemType getTicketType() {
        return TICKET;
    }

    @NonNull
    public static ItemType getRegionType() {
        return REGION;
    }

    @NonNull
    public static ItemType getSettingsType() {
        return SETTINGS;
    }

    @NonNull
    public static ItemType getShareType() {
        return SHARE;
    }

    @NonNull
    public static ItemType getSupportType() {
        return SUPPORT_ID;
    }

    @NonNull
    public static ItemType getHowBookType() {
        return HOW_BOOK;
    }

    @NonNull
    public static ItemType getHowPayType() {
        return HOW_PAY;
    }

    @NonNull
    public static ItemType getRulesType() {
        return RULES;
    }

    @NonNull
    public static ItemType getBasketType() {
        return BASKET;
    }

    @NonNull
    public static ItemType getEditType() {
        return EDIT;
    }

    @NonNull
    public static ItemType getExitType() {
        return EXIT;
    }

    @NonNull
    public static ItemType getHistoryType() {
        return HISTORY;
    }

    @NonNull
    public static ItemType getInfoType() {
        return INFO;
    }
}
