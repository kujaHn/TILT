package Chapter2.item5.dictionary;

public class EnglishDictionary implements Dictionary{
    @Override
    public void spellCheck() {
        System.out.println("영어 사전을 사용해서 단어 검사.");
    }
}
