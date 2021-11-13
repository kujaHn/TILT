package Chapter2.item3;

/** === Item3. private 생성자나 열거 타입으로 싱글턴임을 보증하라 ===
 *  - 싱글턴의 경우에는 인스턴스가 단 한번만 실행되어야 한다.
 *  - 그렇기 때문에 생성자를 막아야 하는데 이때 private 접근 제한자를 사용한다.
 *
 *  - 리플렉션을 사용해서 호출하려고 하는 경우
 *      - 이 경우에는 생성자를 수정해 두 번째 객체가 생성되려 할 때 예외를 던지게 하면 된다.
 *
 * === Item4의 내용 역시 3과 일맥상통하기 때문에 넘어가겠다. ===
 */
public class UsePrivateConstWhenUseSingleton {
    public static void main(String[] args) {
//        private 생성자이기 때문에 호출이 안된다.
//        SingletonClass singletonClass = new SingletonClass();
        SingletonClass singletonClass = SingletonClass.getInstance();
        singletonClass.process();
    }
}
