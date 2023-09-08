import java.util.ArrayList;
import java.util.List;

public class conversion {
    public int convert4To10(int quaternaryNumber) throws inputBoundException{
        String inputToString = Integer.toString(quaternaryNumber);
        String[] inputToArray = inputToString.split("");

        if(inputToArray.length>5){
            throw new inputBoundException("Input too long");
        }
        int sum = 0;
        int count = 0;

        for (int i=inputToArray.length-1; i>=0; i--){
            String digit = inputToArray[i];

            if(!(digit.equals("0")||digit.equals("1")||digit.equals("2")||digit.equals("3"))){
                throw new inputBoundException("Invalid Quaternary Number:" + digit);
            }
            sum += (int) (Integer.parseInt(inputToArray[i]) * Math.pow(4,count));
            count++;
        }

        return sum;
    }


    public int convert10To4(int decimalNumber) throws inputBoundException{
        if((decimalNumber<0 || Integer.toString(decimalNumber).split("").length>5)){
            throw new inputBoundException("Invalid Input");
        }

        StringBuilder sb = new StringBuilder();
        int quotient = decimalNumber;

        while(quotient != 0){
            int remainder = quotient%4;
            quotient = (int) Math.floor(quotient/4);
            sb.append(remainder);
        }

        return Integer.parseInt(String.valueOf(sb.reverse()));
    }


}


