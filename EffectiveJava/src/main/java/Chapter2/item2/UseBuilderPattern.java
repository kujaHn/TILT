package Chapter2.item2;

import Chapter2.item2.pizza.Calzone;
import Chapter2.item2.pizza.NYPizza;
import Chapter2.item2.pizza.Pizza;
import Chapter2.item2.pizza.Topping;

/** === 파라미터가 너무 많으면 빌더 패턴을 써라! ===
 *  - 객체를 만들 때 파라미터가 너무 많으면 실수의 위험이 있다.
 *  - 같은 타입인데 파라미터를 잘못 입력한 경우에는 컴파일러가 이를 잡아주지도 못해 더 큰 문제가 발생한다.
 *  - 그래서, 이런 경우에는 빌더 패턴을 사용을 고려해야 한다.
 *
 *  - 단점으로는 처음 만들때가 너무 장황하다는 것?
 */
public class UseBuilderPattern {
    public static void main(String[] args) {
        Pizza nyPizza = new NYPizza.Builder(NYPizza.Size.SMALL)
                .addTopping(Topping.MEAT)
                .addTopping(Topping.MUSHROOM)
                .addTopping(Topping.PEPPERONI)
                .build();

        Pizza calzonePizza = new Calzone.Builder().sauceInside()
                .addTopping(Topping.MEAT)
                .addTopping(Topping.PEPPERONI)
                .build();
    }
}
