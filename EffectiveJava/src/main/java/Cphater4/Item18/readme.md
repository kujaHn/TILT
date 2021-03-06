# Item18. 상속보다는 컴포지션을 사용하라.
* 상속은 유용하다. 코드를 재사용할 수 있는 강력한 수단 중 하나이다.
* 하지만 리턴만큼 리스크도 굉장히 크다. 상속의 가장 큰 문제점은 바로 **캡슐화를 깨트린다**는 것이다.
  * 상위 클래스를 수정하면 이를 상속받은 하위 클래스들에게 모두 영향이 간다는 소리다.
  * 특히 **패키지의 경계를 넘어 다른 패키지의 구체 클래스를 상속**하는 것은 매우 위험한 방법이다.

## 예시 Set과 InstrumentedSet
* 해당 예시에서 나오는 문제는 내가 상속받은 메서드가 의도대로 동작하지 않는 경우에 발생한다.
* 그래서 개발자는 이를 재정의할지, 다른 방식을 사용할 지 고민을 해야 하는데, 이는 정말로 비효율적이다.
* 그래서 컴포지션 패턴이 등장했다!

## 컴포지션 (데코레이터 패턴)
* 기존 클래스를 상속을 통해 확장하는 대신, **새로운 클래스를 만들어 private 필드로 기존 클래스의 인스턴스를 참조하게 하는 방식**이다.
* 새 클래스의 인스턴스 메서드들은 기존 클래스의 대응하는 메서드를 호출 해 그 결과를 반환한다. 이 방식을 **포워딩(전달)** 이라고 한다.
* 사실 어렵게 생각할 것 없다. 우리가 흔히 `DI(Dependency Injection)`를 할때 생성자 패턴으로 주입을 했던 것과 비슷하다.
* 정 모르겠으면 검색해보자.
```java
public class ForwardingSet<E> implements Set<E> {

  // 그냥 DI랑 똑같다.
  private final Set<E> set;

  // 슈퍼 클래스 => 컴포지션 클래스 DI
  public ForwardingSet(Set<E> set) {
    this.set = set;
  }
  @Override
  public int size() {return 0;}

  @Override
  public boolean isEmpty() {return false;}
  ...
}
```
* 위의 클래스를 포워딩(전달) 클래스라고 한다.
* 데코레이터 패턴이라고도 한다.
```java
public class InstrumentedSet<E> extends ForwardingSet<E> {
  private int addCount = 0;

  // 컴포지션 클래스 => 래퍼 클래스
  public InstrumentedSet(Set<E> s) {
    super(s);
  }
  override method...
}
```
### 주의점
* 래퍼 클래스가 콜백 프레임워크와는 어울리지 않는다는 것을 주의해라
  * 콜백에서는 자기 자신의 참조를 다른 객체에 넘겨 다음 호출때 사용한다.
  * 내부 객체는 자신을 감싸고 있는 래퍼의 존재를 모르기 때문에 자신(this) 참조를 넘기고 콜백 때 래퍼가아닌 내부 객체를 호출하게 된다.
  * 이러한 문제를 SELF 문제라고 한다.

## 결론
* 상속은 강력한 기능을 제공하나, 그만큼 큰 리스크를 짊어지고 있다.
* 그래서 상속은 반드시 하위 클래스가 상위 클래스의 진짜 하위 타입인 상황에서만 쓰여야 한다. (클래스 B가 클래스 A와 `is-a` 관계일때만 사용)
* 상위 클래스가 확장을 고려해 설계되지 않았다면 문제는 해결되지 않는다.
* 이 때문에 컴포지션과 포워딩(전달) 클래스를 이용하는 데코레이터 패턴을 사용하자.