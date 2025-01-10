package es.datastructur.synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        //ArrayRingBuffer arb = new ArrayRingBuffer(10);
    }

    public static void main(String arg[]){
        ArrayRingBuffer<Integer> test = new ArrayRingBuffer<>(5);
        ArrayRingBuffer<Integer> test2 = new ArrayRingBuffer<>(5);

        test.enqueue(1);
        test.enqueue(4);
        test.enqueue(2);
        test.enqueue(5);
        test.enqueue(3);
        test.dequeue();
        test.dequeue();
        test.enqueue(2);

        test2.enqueue(2);
        test2.enqueue(5);
        test2.enqueue(3);
        test2.enqueue(2);
        for (int i : test)  {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println(test.equals(test2));
        for (int i : test2) {
            System.out.print(i + " ");
        }
    }
}
