package by.instinctools.megamag.data.type.factory;

import android.support.annotation.NonNull;

import by.instinctools.megamag.data.type.ItemType;

public final class ItemTypeFactory {

    private static final ItemType REGION = ItemType.create(400);
    private static final ItemType ABOUT = ItemType.create(401);
    private static final ItemType SHARE = ItemType.create(402);
    private static final ItemType SETTINGS = ItemType.create(404);

    private static final ItemType ANNOUNCEMENTS = ItemType.create(200);
    private static final ItemType TICKET = ItemType.create(201);

    private static final ItemType HOW_PAY = ItemType.create(100);
    private static final ItemType HOW_BOOK = ItemType.create(101);
    private static final ItemType RULES = ItemType.create(102);
    private static final ItemType SUPPORT_ID = ItemType.create(103);

    private static final ItemType BASKET = ItemType.create(500);
    private static final ItemType INFO = ItemType.create(501);
    private static final ItemType HISTORY = ItemType.create(502);
    private static final ItemType EDIT = ItemType.create(503);
    private static final ItemType EXIT = ItemType.create(503);

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
