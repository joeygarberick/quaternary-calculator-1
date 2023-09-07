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

    public int mult(int i, int i1) {
        return 0;
    }

    public int div(int i, int i1) {
        return 0;
    }

    public int pow(int i) throws inputBoundException {
        conversion Conversion = new conversion();

        int decimal = Conversion.convert4To10(i);
        int squared = decimal * decimal;
        return Conversion.convert10To4(squared);
    }

    public int rad(int i, int i1) {
        return 0;
    }
}
