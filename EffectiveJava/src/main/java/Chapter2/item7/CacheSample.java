package Chapter2.item7;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class CacheSample {
    public static void main(String[] args) {
        Integer key1 = 1000;
        Integer key2 = 2000;
        String value1 = "value1";
        String value2 = "value2";

        // 언젠가는 넣어뒀던 key:value 들을 비워줘야 한다.
        임의로_캐시를_비워줘야_하는_경우(key1, key2, value1, value2);

        System.out.println("");
        // 그래서... 꺼내면 자동으로 비워주는 WeakHashMap을 사용하자.
        자동으로_비워주는_WeakHashMap(key1, key2, value1, value2);
    }

    private static void 임의로_캐시를_비워줘야_하는_경우(Integer key1, Integer key2, String value1, String value2) {
        Map<Integer, String> cache = new HashMap<>();
        cache.put(key1, value1);
        cache.put(key2, value2);

        System.out.println("=== 사용 이후 ===");
        cache.get(key1);
        cache.get(key2);

        key1 = null;
        key2 = null;

        System.gc();

        // 꺼내서 사용했어도 그대로 남아있다.
        for (Object o : cache.keySet()) {
            System.out.println(o);
        }

        // 이들을 비워줘야 한다.
//        cache.remove(key1); 비워주는 메서드
//        cache.remove(key2);

        System.out.println("=== GC 이후 ===");
        for (Object o : cache.keySet()) {
            System.out.println(o);
        }
    }

    private static void 자동으로_비워주는_WeakHashMap(Integer key1, Integer key2, String value1, String value2) {
        System.out.println("===WeakHashMap 사용===");
        WeakHashMap<Integer, Object> newCache = new WeakHashMap<>(); // Map을 WeakHashMap으로 래핑
        newCache.put(key1, value1);
        newCache.put(key2, value2);

        System.out.println("=== 입력 이후 ===");
        for (Object o : newCache.keySet()) {
            System.out.println(o);
        }

        // 더이상 쓸모 없어짐
        key1 = null;

        System.gc();

        System.out.println("=== 사용 이후 ===");
        System.out.println("key1이나, key2가 GC의 대상이 되면 알아서 비워준다.");
        newCache.entrySet().stream().forEach(System.out::println);
    }

}
