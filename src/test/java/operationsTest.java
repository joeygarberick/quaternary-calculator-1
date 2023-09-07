import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class operationsTest {
    operations op = new operations();

    @Test
    void subtractionTest() throws inputBoundException {
        int result = op.subt(3002,1113);
        assertEquals(1223, result);
    }


    @Test
    void testAddition() throws inputBoundException {
        int result = op.add(22310,10032);
        assertEquals(33002, result);
    }

    @Test
    void testMult(){
        int result = op.mult(22,10);
        assertEquals(220, result);
    }

    @Test
    void testDiv() {
        int result = op.div(220,10);
        assertEquals(22,result);
    }

    @Test
    void testPow() throws inputBoundException {
        int result = op.pow(10);
        assertEquals(100, result);
    }

    @Test
    void testRad() {
        int result = op.rad(100,2);
        assertEquals(10,result);
    }


}
