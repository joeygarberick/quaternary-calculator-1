import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class memoryTests {

    @Test
    void testMemory() {
        memory mem = new memory(1122, 23, "add");
        assertEquals(1122, mem.getFirst());
        assertEquals(23, mem.getSecond());
        assertEquals("add", mem.getOperation());
    }

}
