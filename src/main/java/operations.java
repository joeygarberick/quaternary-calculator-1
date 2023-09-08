public class operations {
    public int subt(int i, int i1) throws inputBoundException {
        conversion Conversion = new conversion();
        int decimal1 = Conversion.convert4To10(i);
        int decimal2 = Conversion.convert4To10(i1);
        int subtracted = decimal1 - decimal2;
        return Conversion.convert10To4(subtracted);
    }



    public int add(int i, int i1) throws inputBoundException {
        conversion Conversion = new conversion();
        int decimal1 = Conversion.convert4To10(i);
        int decimal2 = Conversion.convert4To10(i1);
        int added = decimal1 + decimal2;
        return Conversion.convert10To4(added);
    }

    public int mult(int i, int i1) throws inputBoundException {
        conversion Conversion = new conversion();
        int decimal1 = Conversion.convert4To10(i);
        int decimal2 = Conversion.convert4To10(i1);
        int multiplied = decimal1 * decimal2;
        return Conversion.convert10To4(multiplied);
    }

    public int div(int i, int i1)  throws inputBoundException{
        conversion Conversion = new conversion();
        int decimal1 = Conversion.convert4To10(i);
        int decimal2 = Conversion.convert4To10(i1);
        int division = decimal1 / decimal2;
        
        return Conversion.convert10To4(division);
    }



    public int pow(int i) throws inputBoundException {
        conversion Conversion = new conversion();

        int decimal = Conversion.convert4To10(i);
        int squared = decimal * decimal;
        return Conversion.convert10To4(squared);
    }

    public int rad(int i) throws inputBoundException {
        conversion Conversion = new conversion();
        int decimal = Conversion.convert4To10(i);
        int squareRoot = (int) Math.sqrt(decimal);

        return Conversion.convert10To4(squareRoot);
    }

    public int operate(String operator, int num1, int num2) throws inputBoundException {
        return switch (operator) {
            case "+" -> add(num1,num2);
            case "-" -> subt(num1,num2);
            case "/" -> div(num1,num2);
            case "x" -> mult(num1,num2);
            case "x²" -> pow(num1);
            case "√" -> rad(num1);
            default -> -1;
        };
    }

    public boolean isNumeric(String str) {
        return str.matches("-?\\d+");
    }
}
