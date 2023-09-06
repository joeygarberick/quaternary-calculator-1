import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class memoryTests {

    memory mem = new memory(1122, 23, "add");

    @Test
    void testMemory() {
        assertEquals(1122, mem.getFirst());
        assertEquals(23, mem.getSecond());
        assertEquals("add", mem.getOperation());
    }

    @Test
    void testClearMemory() {
        mem.clearMemory();
        assertEquals(0, mem.getFirst());
        assertEquals(0, mem.getSecond());
        assertEquals("", mem.getOperation());
    }

    @Test
    void testSetMemory() {
        mem.setMemory(2, 312, "subtract");
        assertEquals(2, mem.getFirst());
        assertEquals(312, mem.getSecond());
        assertEquals("subtract", mem.getOperation());
    }

}
