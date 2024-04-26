package deque;

import edu.princeton.cs.algs4.StdRandom;
        import org.junit.Test;
        import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestCorrection {
    // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove() {
        ArrayDeque<Integer> correct = new ArrayDeque<>();
        LinkedListDeque<Integer> broken = new LinkedListDeque<>();

        correct.addLast(5);
        correct.addLast(10);
        correct.addLast(15);

        broken.addLast(5);
        broken.addLast(10);
        broken.addLast(15);

        assertEquals(correct.size(), broken.size());

        assertEquals(correct.removeLast(), broken.removeLast());
        assertEquals(correct.removeLast(), broken.removeLast());
        assertEquals(correct.removeLast(), broken.removeLast());
    }

    @Test
    public void randomizedTest() {
        ArrayDeque<Integer> correct = new ArrayDeque<>();
        LinkedListDeque<Integer> broken = new LinkedListDeque<>();

        int N = 100;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 2);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                correct.addLast(randVal);
                broken.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int size = correct.size();
                System.out.println("size: " + size);
                assertEquals(correct.size(), broken.size());
            }
        }
    }
}
