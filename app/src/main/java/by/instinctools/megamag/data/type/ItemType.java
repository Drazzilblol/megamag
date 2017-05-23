package by.instinctools.megamag.data.type;

public class ItemType implements Type {

    private final int id;

    public ItemType(int id) {
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

        ItemType itemType = (ItemType) o;

        return id == itemType.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
