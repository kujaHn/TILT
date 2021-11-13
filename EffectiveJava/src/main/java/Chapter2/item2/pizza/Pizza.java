package Chapter2.item2.pizza;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

public class Pizza {
    final Set<Topping> toppings;

    Pizza(Builder<?> builder) {
        toppings = builder.toppings.clone();
    }

    abstract static class Builder<T extends Builder<T>>{    // 자기자신의 하위 타입을 받는 형태 (재귀적 타입 바운드)
                                                            // 이렇게 되면 T가 자신을 포함하는 수식 Builder에 한정할 수 있다.
        private EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

        // T가 Builder의 하위 타입
        public T addTopping(Topping topping) {
            toppings.add(Objects.requireNonNull(topping));
            return self();
        }

        abstract Pizza build();

        protected abstract T self();
    }

}
