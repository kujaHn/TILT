package Chapter2.item5;

import Chapter2.item5.dictionary.EnglishDictionary;
import Chapter2.item5.dictionary.KoreanDictionary;
import Chapter2.item5.dictionary.SpellChecker;

/** === 자원을 직접 명시하지 말고 의존 객체 주입을 사용하라 ===
 * - 많은 클래스가 하나 이상의 자원을 사용한다.
 *
 * - 인스턴스를 미리 정하는(구체화하는) 방법은 전혀 유연하지 않은 방법이다.
 * - 그래서 여러 사전을 런타임 시 동적으로 할당하는 방법이 필요하다.
 * - 이 방법이 바로 DI이다.
 *      - 수정자 주입
 *      - 생성자 주입
 *      -  필드 주입
 *
 * 이 패턴의 쓸만한 변형으로 생성자에 자원 팩토리를 넘겨주는 방법이 있는데.
 * 참고로 팩토리는 호출할 때마다 특정 타입의 인스턴스를 반복해서 만들어주는 객체를 말한다. (말 그대로 인스턴스를 찍어내는 공장)
 *
 * 이러한 방식들은 유연성은 제공해주지만, 코드의 복잡성이 증가하는 단점이 있다.
 * 그래서, 이를 내부적으로 지원해주는 스프링 프레임워크, 대거(Dagger)와 같은 프레임워크 사용을 추천한다.
 *
 */
public class UseDI {
    public static void main(String[] args) {
        // 생성자를 통해 런타임 시 주입.
        SpellChecker koreanSpellChecker = new SpellChecker(new KoreanDictionary());
        SpellChecker englishSpellChecker = new SpellChecker(new EnglishDictionary());
        System.out.println(koreanSpellChecker);
        boolean korResult = koreanSpellChecker.isValid("안녕하세요");
        System.out.println(korResult);

        System.out.println("=======================");
        System.out.println(englishSpellChecker);
        boolean engResult = englishSpellChecker.isValid("hello");
        System.out.println(engResult);
    }
}
