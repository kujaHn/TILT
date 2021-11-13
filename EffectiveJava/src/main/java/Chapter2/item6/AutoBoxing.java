package Chapter2.item6;


public class AutoBoxing {
    public static void main(String[] args) {
        badBoxing();
        avoidBoxing();
    }

    private static void badBoxing() {
        long start = System.currentTimeMillis();
        Long sum = 0l;  // 박스 타입
        // 이 반복문을 수행할 때마다, sum을 오토박싱해서 더하게 된다.
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        System.out.println("result = " + sum);
        System.out.println("runningTime = " + (System.currentTimeMillis() - start) + "ms");
    }

    private static void avoidBoxing() {
        long start = System.currentTimeMillis();
        long sum = 0l;  // 기본형 타입
        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        System.out.println("result = " + sum);
        System.out.println("runningTime = " + (System.currentTimeMillis() - start) + "ms");
    }
}