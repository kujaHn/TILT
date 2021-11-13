package Chapter2.item7;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * 별 문제는 없어보이지만... 메모리 누수 가능성이 있다.
 * pop()을 보면 객체를 꺼냇지만, 꺼낸 객체의 element를 null로 초기화 하지 않은 상태이다.
 *
 */
public class StackMemory {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public StackMemory() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public Object pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        Object result = elements[--size];
        elements[size] = null;  // 참조 해제
        return result;
    }

    // 원소를 위한 공간을 적어도 하나 이상 확보
    // 배열의 크기를 늘려야 할 때마다 2배씩 늘어난다
    public void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }
}
