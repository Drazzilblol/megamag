package by.instinctools.megamag.common.factory;

import by.instinctools.megamag.data.type.GroupType;

public final class GroupTypeFactory {

    private static final int INFO_GROUP_ID = 1000;
    private static final int ANNOUNCEMENT_GROUP_ID = 1001;
    private static final int THEATER_GROUP_ID = 1002;
    private static final int SETTINGS_GROUP_ID = 1004;
    private static final int PROFILE_GROUP_ID = 1005;

    public static GroupType getAnnouncementGroupType() {
        return new GroupType(ANNOUNCEMENT_GROUP_ID);
    }

    public static GroupType getInfoGroupType() {
        return new GroupType(INFO_GROUP_ID);
    }

    public static GroupType getProfileGroupType() {
        return new GroupType(PROFILE_GROUP_ID);
    }

    public static GroupType getSettingsGroupType() {
        return new GroupType(SETTINGS_GROUP_ID);
    }

    public static GroupType getTheaterGroupType() {
        return new GroupType(THEATER_GROUP_ID);
    }

}
