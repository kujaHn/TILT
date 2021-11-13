package Chapter2.Item9;

import java.util.stream.Stream;

public class MyResource implements AutoCloseable {

    public void doSomething() {
        System.out.println("do Something");
        throw new FirstError();
    }
    @Override
    public void close() throws Exception {
        System.out.println("close");
        throw new SecondError();
    }
}
