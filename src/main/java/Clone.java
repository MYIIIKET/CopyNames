import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Clone {
    private static final List<String> names = new ArrayList<>();
    private static final String copyWord = "_clone";
    private static final String copyNumber = "_(%s)";

    public static void main(String[] args) {
        add("test");
        clone("test");
        clone("test");
        clone("test_clone_(1)");
        clone("test_clone_(1)");
        clone("test_clone_(1)");
        clone("test_clone_(1)_clone_(2)");
        clone("test_clone_(1)_clone_(2)");
        clone("test_clone_(1)_clone_(2)");
        clone("test_clone_(1)_clone_(2)");
        clone("test_clone_(1)_clone_(2)");
        clone("test");
        clone("test");
        print();
    }

    private static void add(String name) {
        names.add(name);
    }

    private static void print() {
        names.forEach(System.out::println);
    }

    private static void clone(String item) {
        if (names.contains(item)) {
            item += copyWord;
            if (names.contains(item)) {
                item += copyNumber;
                item = getMaxCopy(item);
                names.add(item);
            } else {
                names.add(item);
            }
        }
    }

    private static String getMaxCopy(String item) {
        int count = 1;
        String result;
        do {
            result = String.format(item, count);
            count++;
        } while (names.contains(result));
        return result;
    }

}
