package by.instinctools.megamag.common.factory;

import android.support.annotation.NonNull;

import by.instinctools.megamag.data.type.GroupType;

public final class GroupTypeFactory {

    private static final GroupType INFO_GROUP = new GroupType(1000);
    private static final GroupType ANNOUNCEMENT_GROUP = new GroupType(1001);
    private static final GroupType THEATER_GROUP = new GroupType(1002);
    private static final GroupType SETTINGS_GROUP = new GroupType(1004);
    private static final GroupType PROFILE_GROUP = new GroupType(1005);

    @NonNull
    public static GroupType getAnnouncementGroupType() {
        return ANNOUNCEMENT_GROUP;
    }

    @NonNull
    public static GroupType getInfoGroupType() {
        return INFO_GROUP;
    }

    @NonNull
    public static GroupType getProfileGroupType() {
        return PROFILE_GROUP;
    }

    @NonNull
    public static GroupType getSettingsGroupType() {
        return SETTINGS_GROUP;
    }

    @NonNull
    public static GroupType getTheaterGroupType() {
        return THEATER_GROUP;
    }
}
