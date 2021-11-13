package Chapter2.item1;

// 대표적인 방법이 싱글톤!
public class CanReuseInstance {
    private static CanReuseInstance INSTANCE = new CanReuseInstance();

    // 생성자를 막아 호출 불가능하게 만들기.
    private CanReuseInstance() {}

    // 외부에 제공하는 인스턴스 반환
    public static CanReuseInstance getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CanReuseInstance();
        }
        return INSTANCE;
    }

    public void print(String str) {
        System.out.println(str);
    }
}
