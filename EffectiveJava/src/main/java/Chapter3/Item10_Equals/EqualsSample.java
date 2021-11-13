package Chapter3.Item10_Equals;

import Chapter3.Item10_Equals.point.ColorPoint;
import Chapter3.Item10_Equals.point.Point;

import java.awt.*;

/** === Item10. equals()는 일반 규약을 지켜 재정의 하라 ===
 * - equals()는 정말 주의해서 재정의해야 합니다.
 *
 * == 재정의하지 않는 경우 ==
 *  1. 각 인스턴스가 본질적으로 고유할 때.
 *      - 값을 가지는 인스턴스가 아닌 동작만을 위한 인스턴스들이 여기에 해당하낟.
 *      - 대표적인 예시는 Thread 이다.
 *
 *  2. 인스턴스의 `논리적 동치성`을 검사할 일이 없을 때.
 *      - equals()를 재정의 하는 경우는 논리적 동치성을 검사해야 할 일이 있는 경우다.
 *      - 이 이외의 경우라면 애초에 equals()를 재정의하지 않아도 된다.
 *
 *  3. 상위 클래스에서 재정의한 equals()가 하위 클래스에도 딱 들어 맞는 경우.
 *      - 상위 클래스의 equals()x를 끌어다 쓰면 되기 때문에 재정의 할 필요가 없다.
 *
 *  4. 클래스가 private, package-private 이고 equals()를 호출할 일이 없는 경우.
 *      - 호출할 일이 없으면 애초에 만들 이유도 없다.
 *      - 만약에 이 호출을 막고 싶다면 AssertionError()를 던지도록 오버라이드 해 두자.
 *
 *  그렇다면 어떤 경우에 재정의를 해야 할까?
 *  - 바로 객체 식별성(인스턴스 값 비교)가 아닌 논리적 동치성을 확인해야 할 경우 equals()가 제 동작을 하지 못하는 경우 이다.
 *  - 이 경우에는 다음 규약을 지켜 재정의를 해야 한다. (Object 명세에 적혀있는 규약이다.)
 *
 *    =================================================================================================================================
 *       equals 메서드는 동치관계를 구현하며 다음을 만족한다.
 *           1. 반사성 : null이 아닌 모든 참조 값 x에 대해 x.equals(x)는 참이다.
 *           2. 대칭성 : null이 아닌 모든 참조 값 x, y에 대해 x.equals(y)가 참이면, y.equals(x)도 참이다.                  ==> 교환 법칙
 *           3. 추이성 : null이 아닌 모든 참조 값 x, y, z에 대해 x.equals(y) && y.equals(z)가 참이면 x.equals(z)도 참이다. ==> 삼단 논법
 *           4. 일관성 : null이 아닌 모든 참조 값 x, y에 대해 x.equals(y)를 반복해서 호출해도 결과는 항상 같아야 한다.         ==> 멱등성
 *           5. null-아님 : null이 아닌 모든 참조 값 x에 대해 x.equals(null)은 거짓이다.
 *    =================================================================================================================================
 *
 * - 일반적인 상황에서는 이들을 모두 지키면서 구현하는 것은 크게 어려운 일이 아니다.
 * - 문제는, 상속 등으로 기존 필드에서 하나씩 추가하는 경우이다.
 * - 이는 모든 객체 지향 언어의 동치관계에서 나타나는 근본적인 문제이기 때문에 구체 클래스를 확장해나가면서도, equals 규약을 만족시키는 방법은 존재하지 않는다.
 * - 이 경우에는 상속 대신 컴포지션을 사용하면 equals 규약을 어기지 않고 우회할 수 있다.
 *
 * === 구현 방법 가이드라인 ===  ==> Member.Class 참고.
 *
 * 번외
 *  - 너무 어렵게 생각하지 말고 쉽게 생각해라 -> 어렵게 느껴지면 아예 불가능한 구조인 경우가 대부분이다.
 *  - 외부 라이브러리를 적극적으로 사용해라 -> AutoValue (Google)
 *  - 정말정말정말 꼭 필요한 경우가 아니면 equals()를 재정의하지 말자.
 *
 * */
public class EqualsSample {
    public static void main(String[] args) {
        pointEquals();
        colorPointEquals();
    }

    static void pointEquals() {
        Point point1 = new Point(1, 2);
        Point point2 = new Point(3, 2);
        Point point3 = new Point(1, 2);

        boolean result1 = point1.equals(point2);
        boolean result2 = point1.equals(point3);
        boolean result3 = point2.equals(point3);

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }

    static void colorPointEquals() {
        ColorPoint colorPoint1 = new ColorPoint(1, 2, Color.RED);
        ColorPoint colorPoint2 = new ColorPoint(1, 2, Color.RED);

        Point point1 = new Point(1, 2);

        System.out.println(colorPoint1.equals(colorPoint2));
        System.out.println(point1.equals(colorPoint1)); // Color 정보가 무시된다.
    }

}
