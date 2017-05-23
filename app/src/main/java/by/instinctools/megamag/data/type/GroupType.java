package by.instinctools.megamag.data.type;

public class GroupType implements Type {

    private final int id;

    public GroupType(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupType groupType = (GroupType) o;

        return id == groupType.id;

    }

    @Override
    public int hashCode() {
        return id;
    }
}
