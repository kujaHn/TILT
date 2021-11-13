package Chapter2.item6;

import java.util.regex.Pattern;

/** === 불필요한 객체 생성을 피하라 ===
 * - 똑같은 기능의 객체를 매번 생성하기 보다 객체 하나를 `재사용`하는 편이 나은 경우가 많습니다. (특히 불변 객체)
 * - 항상 개발자들은 재사용을 염두하고 코드를 짜야 하는데 이번에는 이의 사용법을 알아봅시다.
 *
 * String 타입
 *  - 자바를 배올때 new String()으로 만든적은 한번도 없을 겁니다.
 *      - 만약 이 방식을 채택했다면, 문자열을 생성할 때마다, 새로운 인스턴스들이 만들어져 수백만개의 인스턴스를 감당해야 할지 모릅니다!
 *      - 그래서 String은 `String Constant Pool`을 이용해서 값이 같으면 같은 래퍼런스를 참조하게 만들었습니다.
 *
 *  - 대신 String name = "value"; 방법을 사용합니다.
 *      - 이 방식을 사용하면 같은 가상 머신 안에서 이와 똑같은 문자열 리터럴을 사용하는 모든 코드가 같은 객체를 재사용합니다.
 *
 * 무거운 객체
 *  - 무거운 객체를 사용하는 경우를 생각해봅시다.
 *  - 만약 자주 사용하는 객체인데 무거워 생성 비용이 크다면, 재사용하는 것이 훨씬 유리한 방법입니다.
 *  - 하지만 만약 한번만 사용되는 객체라면 불필요한 초기화가 되어 애플리케이션 초기 실행 속도가 느려지게 된다.
 *  - 사용 빈도를 잘 체크해서 채택하자!
 *
 * 어댑터 (UsingAdapter)
 *  - 어댑터는 HashMap<>()을 통해서 그에 맞는 객체를 리턴하는 방식으로 사용합니다.
 *  - 재밋는점은 Map의 KeySet을 호출할 때 매번 새로운 인스턴스가 만들어진다 생각하겠지만
 *  - 사실 같은 인스턴스를 공유하고 있습니다.
 *
 * 오토박싱
 *  - 불필요한 객체를 생성하는 또 다른 방법으로 오토박싱이 있다.
 *  - 오토박싱 기능이란 기본 타입과 박스 타입을 섞어 쓸 수 있게 해주는 박싱 기능을 자동으로 해주는 방법이다.
 *  - 하지만, 이 자동화 기능이 타입간 경계의 구분을 안보이게 해주는 기능이지, 없애주는 기능은 아니기 때문에 최적화에 좋지 않다.
 *  - 그래서... 불필요한 오토박싱을 피하기 위해서는 박스 타입 보다는 프리미티브 타입을 사용해야 한다.
 *  - 이런 이유 때문에 스트림과 같은 곳에서도 기본형 특화 스트림 (IntStream, LongStream ... )이 존재한다.
 *
 * 주의 사항
 *  - 객체를 만드는게 비싸다고 무조건적으로 재사용을 해서는 안된다.
 *  - 특히 방어적인 복사를 해야 하는 경우에도 객체를 재사용하면 심각한 버그와 보안성 문제가 생긴다.
 *  - http://www.javapractices.com/topic/TopicAction.do?Id=15 해당 문서 참고
 * */
public class AvoidMakingUselessInstance {
    public static void main(String[] args) {
        System.out.println("생성자를 사용할 때 비교");
        String dontDoThat1 = new String("절대 이렇게 만들지 마시오!");
        String dontDoThat2 = new String("절대 이렇게 만들지 마시오!");
        String dontDoThat3 = new String("절대 이렇게 만들지 마시오!");

        System.out.println("계속해서 새로운 인스턴스를 생성하기 때문에 항상 다르다 : " + (dontDoThat1 == dontDoThat2));


        System.out.println("=== 생성자를 사용하지 않을때 비교 ===");

        String useThis1 = "이게 문자열 생성 방식이지!";
        String useThis2 = "이게 문자열 생성 방식이지!";
        String useThis3 = "이게 문자열 생성 방식이지!!";

        System.out.println("문자열이 같기 때문에 같은 레퍼런스 참조 : " + (useThis1 == useThis2));
        System.out.println("문자열이 다르기 때문에 다른 레퍼런스 참조 : " + (useThis2 == useThis3));

        useThis1 += useThis1;
        System.out.println(useThis1);
        useThis1 += useThis1;
        System.out.println(useThis1);
    }

    // 무거운 객체를 계속 만들 바에야....
    static boolean isRomanNumeral(String s) {
        return s.matches("^(?=.)M*(C[MD]|D?C{0,3})");
    }

    // 이렇게 미리 생성해서 캐싱해두고 계속해서 사용하는 것이 훨씬 낫다!
    private static final Pattern Roman = Pattern.compile("^(?=.)M*(C[MD]|D?C{0,3})");

}

