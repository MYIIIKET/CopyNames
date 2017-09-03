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
        clone("test2");
        clone("test");
        clone("test");
        clone("test");
        print();
    }

    private static void add(String name) {
        names.add(name);
    }

    private static void delete(String name) {
        names.remove(name);
    }

    private static void print() {
        names.forEach(System.out::println);
    }

    private static void clone(String item) {
        if (names.contains(item)) {
            item += copyWord;
            if (names.contains(item)) {
                names.add(getMaxCopy(item+copyNumber));
            } else {
                names.add(item);
            }
        }else {
            names.add(item);
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
