import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class operationsTest {
    operations op = new operations();

    @Test
    void subtractionTest(){
        int result = op.subt(3002,1113);
        assertEquals(1223, result);
    }


    @Test
    void testAddition(){
        int result = op.add(22310,10032);
        assertEquals(33002, result);
    }


}
