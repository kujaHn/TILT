package Chapter2.item3;

public class SingletonClass {
    private static SingletonClass INSTANCE = new SingletonClass();

    // private 생성자를 통한 호출 방지
    // 리플렉션 방지를 위해 예외 처리
    private SingletonClass(){
        if (INSTANCE != null) {
            throw new AssertionError("싱글턴은 두번 생성할 수 없습니다.");
        }
    }

    // 팩토리 메서드로 반환
    public static SingletonClass getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SingletonClass();
        }
        return INSTANCE;
    }

    public void process() {
        System.out.println("Hello Singleton!");
    }
}
