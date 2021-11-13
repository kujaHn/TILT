package Chapter2.item5.dictionary;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

/** === SpellChecker ===
 * - Dictionary의 구현클래스를 받아와서 그에 해당하는 spellCheck()를 사용.
 * - 유틸리티 메서드 용도이기 때문에 인스턴스 생성을 막는다.
 */
public class SpellChecker {

    // 주입이 아닌 인스턴스 초기화
    // private static Dictionary dictionary = new KoreanDictionary();
    private Dictionary dictionary;

    //    private SpellChecker() {}
    public SpellChecker(Dictionary dictionary) {
        this.dictionary = Objects.requireNonNull(dictionary);
    }

    public boolean isValid(String word) {
        dictionary.spellCheck();
        return true;
    }

    public List<String> suggestions(String typo) {
        List<String> strings = new ArrayList<>();
        return strings;
    }
}
