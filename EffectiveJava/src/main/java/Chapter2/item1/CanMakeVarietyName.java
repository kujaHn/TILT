package Chapter2.item1;

public class CanMakeVarietyName {
    private String name;
    private int age;

    private CanMakeVarietyName(String name, int age) {
        this.name = name;
    }

    // 지루한 생성자 대신 직관적인 이름을 가질 수 있다.
    public static CanMakeVarietyName makeJohn(String name, int age) {
        return new CanMakeVarietyName(name, age);
    }

    public static CanMakeVarietyName makeMarry(String name, int age) {
        return new CanMakeVarietyName(name, age);
    }
    public static CanMakeVarietyName makeSam(String name, int age) {
        return new CanMakeVarietyName(name, age);
    }

}
