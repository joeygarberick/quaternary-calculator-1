public class memory {

    private int first;
    private int second;
    private String operation;

    public memory(int first, int second, String operation) {
        this.first = first;
        this.second = second;
        this.operation = operation;
    }

    public int getFirst() {
        return first;
    }

    public int getSecond() {
        return second;
    }

    public String getOperation() {
        return operation;
    }

    public void clearMemory(){
        first = 0;
        second = 0;
        operation = "";
    }

    public void setMemory(int first, int second, String operation) {
        this.first = first;
        this.second = second;
        this.operation = operation;
    }
}
