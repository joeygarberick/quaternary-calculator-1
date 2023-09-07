public class operations {
    public int subt(int i, int i1) {
        return 0;
    }

    public int add(int i, int i1) {
        return 0;
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
