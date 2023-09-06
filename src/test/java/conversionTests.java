import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class conversionTests {

    conversion con = new conversion();

    @Test
    void base4To10Test() throws inputBoundException {
        int result = con.convert4To10(231);
        assertEquals(45,result);
    }

    @Test
    void base10To4Test() throws inputBoundException {
        int result = con.convert10To4(45);
        assertEquals(231,result);
    }

    @Test
    void base10To4UpperBoundsTest(){
        try {
            con.convert10To4(655359);
            fail("No exception thrown");
        } catch (inputBoundException e) {
            System.out.println();
        }
    }

    @Test
    void base10To4LowerBoundsTest(){
        try{
            con.convert10To4(-1);
            fail("No exception Thrown");
        } catch (inputBoundException e) {
            System.out.println();
        }
    }

    @Test
    void base4to10UpperBoundsTest(){
        try {
            con.convert4To10(2133333333);
            fail("No exception thrown");
        } catch (inputBoundException e) {
            System.out.println();
        }
    }

    @Test
    void base4To10LowerBoundsTest(){
        try {
            con.convert4To10(-1);
            fail("No exception thrown");
        } catch (inputBoundException e) {
            System.out.println();
        }
    }

}
