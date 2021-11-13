package Chapter3.Item10_Equals;

/** === 올바른 equals() 구현 방법 ===
 * - Point, ColorPoint같이 골치아픈 경우가 아니라면 다음을 따르자.
 * 1. `==` 연산자를 통해 입력이 자기 자신의 참조인지 확인.
 *
 * 2. instanceof 연산자를 통해 입력이 올바른 타입인지 확인.
 *
 * 3. 입력을 올바른 타입으로 형변환
 *
 * 4. 핵심 필드들이 모두 일치하는지 하나씩 확인
 *      - 이때 float, double을 제외한 기본 타입 필드는 `==`을 이용
 *      - 이 두 타입은 각자의 정적 메서드인 compare() 사용 => Float.NaN, -0.0f, 부동소수 값 등을 다뤄야 하기 때문
 *
 * 5. 최적화를 고민하라.
 *      - 가장 다를 가능성이 있는 핵심 필드를 먼저 비교를 해서 필터링을 하자.
 *      - 동기화용 락 필드 같이 논리적 상태와 관련없는 필드는 비교하면 안된다!
 *
 * 6. 다시 한번 코드를 봐라 => 대칭적인가, 추이성이 있는가, 일관적인가
 *
 * 7. equals() 재정의를 완료했다면 hashCode()도 재정의 하라.
 *
 * 번외
 *
 */
public class Member {
    private String name;
    private int age;

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Member)) {
            return false;
        }
        Member m = (Member) obj;
        return m.name == name && m.age == age;
    }
}
