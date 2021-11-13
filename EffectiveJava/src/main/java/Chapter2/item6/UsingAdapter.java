package Chapter2.item6;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class UsingAdapter {

    public static void main(String[] args) {
        Map<String, Integer> menu = new HashMap<>();
        menu.put("burger", 8);
        menu.put("pizza", 9);

        Set<String> names1 = menu.keySet();
        Set<String> names2 = menu.keySet();

        names1.remove("burger");          // 왜 name1을 지웠는데...
        System.out.println(names2.size());  // 얘들도 1이 되냐?
        System.out.println(menu.size());    // 얘들도 1이 되냐?
        System.out.println("그래서 같은 인스턴스인가? " + (names1 == names2));
    }
}
