package ie.ucc.bis.is4447.mymoviemasterdetailapp.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    public static class DummyItem {

        public String id;
        public String title;
        public Integer year;

        public DummyItem(String id, String title, Integer year) {
            this.id = id;
            this.title = title;
            this.year = year;
        }

        @Override
        public String toString() {
            return title;
        }
    }

    public static List<DummyItem> ITEMS = new ArrayList<DummyItem>();
    public static Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    static {

        addItem(new DummyItem("1", "The Amazing Spider-Man", 2012));
        addItem(new DummyItem("2", "Captain America: The First Avenger", 2011));
        addItem(new DummyItem("3", "Sherlock Holmes", 2009));
        addItem(new DummyItem("4", "Ferris Bueller's Day Off", 1986));
        addItem(new DummyItem("5", "Home Alone", 1990));
    }

    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }
}
