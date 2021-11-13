package Chapter2.Item9;

/** === Item9 : try-finally 보다는 try-with-resources 를 사용하라 ===
 * `try-finally`를 통해 자원관리를 했지만... 문제가 몇가지 있었다.
 *  1. 코드가 너무 장황하다
 *  2. 예외가 발생할 때 디버깅이 어렵다.
 *      - 가장 마지막에 발생한 예외가 그 전의 예외를 덮어 써 정확하게 어디에 예외가 발생했는지 알 수 없다.
 *
 * - Item8 에서도 설명했다시피 'try-with-resources'를 통해 간편하게 자원을 닫을 수 있는 방법이 생겼다. (JAVA7)
 * - 이로 얻을 수 있는 이점은 다음과 같다.
 *
 * 1. 코드의 간결함
 * 2. 예외 처리
 *      - tryWithResource()를 실행하게 되면 가장 먼저 발생한 예외가 나오고
 *      - 뒤에 Suppressed 에 나머지 예외들이 stack 된다. => 디버깅이 정말로 좋아진다.
 *
 */
public class TryFinallyThanTryWithResources {
    public static void main(String[] args) throws Exception {
//        tryfinally();
//        tryWithResource();
        tryWithResource2();
    }


    // 코드가 너무 장황하다.
    public static void tryfinally() throws Exception {
        MyResource myResource = null;
        try {
            myResource = new MyResource();
            myResource.doSomething();
            MyResource myResource1 = null;
            try {
                myResource1 = new MyResource();
                myResource1.doSomething();
            } finally {
                if (myResource1 != null) {
                    myResource1.close();        // 이 secondError가 firstError를 덮어 쓰게 된다.
                }
            }
        } finally {
            if (myResource != null) {
                myResource.close();
            }
        }
    }

    // 자동으로 close를 처리!
    public static void tryWithResource() throws Exception {
        try (MyResource myResource = new MyResource()) {
            myResource.doSomething();
        }
    }

    // 여러개도 가능!
    public static void tryWithResource2() throws Exception {
        try (MyResource myResource = new MyResource();
             MyResource myResource1 = new MyResource()) {
            myResource.doSomething();
            myResource1.doSomething();
        }
    }

}
