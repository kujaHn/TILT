package Chapter2.item1;

/** === 정적 팩토리 메서드를 사용하라 ===
 * - 생성자 대신 정적 팩토리 메서드를 사용할 수 있다.
 * 얻을 수 있는 이점
 *      1. 이름을 가질 수 있다. (CanMakeVarietyName.class)
 *          - 생성자는 클래스 명 'new ClassName()'만 가질 수 있는 반면 메서드이기 때문에 마음대로 설정 가능
 *          - 이 이점으로 더욱 직관적인 객체 생성이 가능하다.
 *
 *      2. 호출할 때마다 인스턴스를 새로 생성하지 않아도 된다.
 *          - 생성자 시 인스턴스를 캐싱해 재활용하는 식이 어렵다.
 *          - 이 방법을 사용하면 캐싱을 통해 재활용이 가능하다.
 *
 *      3. 반환 타입의 하위 타입 객체를 반환할 수 있는 능력이 있다.
 *          - 생성자의 경우 자기 클래스만 반환이 가능하나 다형성의 이점으로 메서드의 경우 다른 하위 타입을 반환할 수 있다.
 *          - 리턴 타입에는 인터페이스, 실제 리턴에는 구현 클래스 -> 코드를 감출 수 있기 때문에 좋다!
 *          - 대표적인 예시가 Collections
 *
 *      4. 입력 매개변수에 따라 매번 다른 클래스의 객체를 반환할 수 있다.
 *          - 오버로딩을 다르게 풀어서 말한 설명이다.
 *          - 메서드 시그니처에서 파라미터만 다르면 메서드가 같아도 다른 행동을 입력할 수 있다.
 *          - EnumSet<>을 참고하자.
 *
 *      5. 정적 팩토리 메서드를 작성하는 시점에는 반환할 객체의 클래스가 존재하지 않아도 된다. (JDBC)
 *          1. Connection.getConnection("DB 주소") 에 따라 반환되는 DB Connection 은 모두 다르다. (MySQL, Oracle, ...)
 *          2. 그런데 들어가는 파라미터 타입은 모두 String 이기 때문에 계속 돌아가면서 Connection을 찾는다.
 *
 *          - 결국 의존성 주입과 비슷한 개념으로 유연성을 부여해주는 방법이다.
 *
 * 단점
 *      1. 상속을 하려면 public, protected 생성자가 필요하니 정적 팩토리 메서드만 제공하면 하위 클래스를 만들 수 없다.
 *          - 불변타입이나 컴포지션을 권장하기 때문에 단점이 장점이 되어 버린다.
 *
 *      2. 정적 팩토리 메서드를 찾는게 어렵다
 *          - 그래서 현재 코드 컨벤션을 제공하고 있다.
 *          - 문서화를 통해 팩토리 메서드를 제공하는 것도 좋은 방법이다!
 */
public class UseStaticFactoryMethod {

}