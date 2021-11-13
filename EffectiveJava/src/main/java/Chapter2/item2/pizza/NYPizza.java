package Chapter2.item2.pizza;

import java.util.EnumSet;
import java.util.Objects;

public class NYPizza extends Pizza {
    public enum Size {SMALL, MEDIUM, LARGE}
    private final Size size;

    private NYPizza(Builder builder) {
        super(builder);
        size = builder.size;
    }

    public static class Builder extends Pizza.Builder<Builder>{
        private final Size size;

        public Builder(Size size) {
            this.size = Objects.requireNonNull(size);
        }

        public Pizza build(){
            return new NYPizza(this);
        }

        protected Builder self() {
            return this;
        }
    }
}
