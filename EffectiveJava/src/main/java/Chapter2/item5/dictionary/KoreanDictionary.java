package Chapter2.item5.dictionary;

public class KoreanDictionary implements Dictionary{
    @Override
    public void spellCheck() {
        System.out.println("한글 사전을 이용해서 단어 검사.");
    }
}
