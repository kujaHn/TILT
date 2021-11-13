package Chapter2.item1;

import Chapter2.item1.superandsub.SubClass1;
import Chapter2.item1.superandsub.Subclass2;
import Chapter2.item1.superandsub.SuperInterface;

public class SubTypeReturn {
    // 타입은 인터페이스이나, 정작 반환하는 객체들은 하위타입이다!
    // 정보은닉에 용이하다.
    SuperInterface subTypeReturn1() {
        return new SubClass1();
    }

    SuperInterface subTypeReturn2() {
        return new Subclass2();
    }

    private SubTypeReturn() {
    }

    // 이렇게 하위 타입 반환이 가능하다.
    public SubTypeReturn of() {
        return new SubSubClass();
    }

    public class SubSubClass extends SubTypeReturn {
    }

}
