package codecool;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomQueueTest {

    private CustomQueue customQueue;

    @BeforeEach
    void setUp() {
        customQueue = new CustomQueue();
    }

    @Test
    void testIsEmpty() {
        assertEquals(true, customQueue.isEmpty());
    }

    @Test
    void testQueueSize() {
        assertEquals(0, customQueue.queueSize());
    }

    @Test
    void testQueueSize2() {
        customQueue.enqueue("Test");

        assertEquals(1, customQueue.queueSize());
    }

    @Test
    void testEnqueueAddsElementToCollection() {
        customQueue.enqueue("Test");
        customQueue.enqueue("Codecool");

        assertEquals(2, customQueue.queueSize());
    }

    @Test
    void testPeekIfReturnFirstElementFromQueue() throws QueueEmptyException {
        customQueue.enqueue("Test");
        customQueue.enqueue("Codecool");

        assertEquals("Test", customQueue.peek());
    }

    @Test
    void testPeekThrowExceptionWhenQueueIsEmpty() {
        assertThrows(QueueEmptyException.class, () -> {customQueue.peek(); });
    }

    @Test
    void testDequeueThrowExceptionWhenQueueIsEmpty() {
        assertThrows(QueueEmptyException.class, () -> {customQueue.dequeue();});
    }

    @Test
    void testDequeueRemovesElementFromQueue() throws QueueEmptyException {
        customQueue.enqueue("Test");
        customQueue.enqueue("Codecool");

        customQueue.dequeue();

        assertEquals(1, customQueue.queueSize());
    }
}