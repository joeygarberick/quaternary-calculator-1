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
    void testMult() throws inputBoundException {
        int result = op.mult(22,10);
        assertEquals(220, result);
    }

    @Test
    void testDiv() throws inputBoundException {
        int result = op.div(220,10);
        assertEquals(22,result);
    }

    @Test
    void testPow() throws inputBoundException {
        int result = op.pow(10);
        assertEquals(100, result);
    }

    @Test
    void testRad() throws inputBoundException{
        int result = op.rad(100);
        assertEquals(10,result);
    }

    @Test
    void testOperateAdd() throws inputBoundException{
        int result = op.operate("+",1,1);
        assertEquals(2,result);
    }
    @Test
    void testOperateSub() throws inputBoundException{
        int result = op.operate("-",20,1);
        assertEquals(13,result);
    }

    @Test
    void testOperateMult() throws inputBoundException{
        int result = op.operate("-",20,1);
        assertEquals(13,result);
    }
    @Test
    void testOperateDiv() throws inputBoundException{
        int result = op.operate("/",222,13);
        assertEquals(12,result);
    }
    @Test
    void testOperatePow() throws inputBoundException{
        int result = op.operate("x²",10,0);
        assertEquals(100,result);
    }
    @Test
    void testOperateRad() throws inputBoundException{
        int result = op.operate("√",12,0);
        assertEquals(2,result);
    }

    @Test
    void testIsNumeric() throws inputBoundException{
        boolean result = op.isNumeric("24");
        assertEquals(true,result);
    }

    @Test
    void testIsNotNumeric() throws inputBoundException{
        boolean result = op.isNumeric("24sd");
        assertEquals(false,result);
    }


}
