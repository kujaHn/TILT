package Chapter2.item1;

import Chapter2.item1.burger.BigMc;
import Chapter2.item1.burger.Bugger1955;
import Chapter2.item1.burger.SangHaiBurger;

import java.util.EnumSet;

import static Chapter2.item1.EveryTimeDifferentType.Color.*;

public class EveryTimeDifferentType {

    // 각 메서드의 이름은 같으나 들어가는 파라미터에 따라 나오는 버거가 다르다!
    public static void main(String[] args) {
        BigMc bigMc = makeBurger("찰깨빵", "특별할 소스", "순쇠고기", "패티두장");
        Bugger1955 bugger1955 = makeBurger("찰깨빵", "볶은양파", "순쇠고기 패티");
        SangHaiBurger sangHaiBurger = makeBurger("찰깨빵", "치킨 패티", 30);

        EnumSet<Color> colors = EnumSet.allOf(Color.class);
        EnumSet.of(RED, WHITE);
    }

    public static BigMc makeBurger(String bread, String specialSauce, String patty1, String patty2) {
        return new BigMc();
    }

    public static Bugger1955 makeBurger(String bread, String onion, String patty) {
        return new Bugger1955();
    }

    public static SangHaiBurger makeBurger(String bread, String chickenPatty, int spicySauce) {
        return new SangHaiBurger();
    }

    enum Color {
        RED, BLUE, WHITE
    }

}
