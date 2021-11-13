package Chapter2.item8;

import java.lang.ref.Cleaner;

public class FinalizerAndCleaner {
    // deprecated
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("GC 처리 되었다.");
    }

    void hello() {
        System.out.println("hello");
    }
}
