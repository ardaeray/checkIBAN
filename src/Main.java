import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String IBAN;
        String convertedIBAN;
        int counter = 0;

        System.out.print("Enter your IBAN Number here: ");
        IBAN = input.next().toUpperCase();
        convertedIBAN = IBAN.substring(4);

        for (int i = 0; i < 2; i++) {
            if (i == 0) {
                int digit1 = ((int)IBAN.charAt(i)) - 55;
                convertedIBAN = convertedIBAN + digit1;
            }
            if (i == 1) {
                int digit2 = ((int)IBAN.charAt(i)) - 55;
                convertedIBAN = convertedIBAN + digit2;
            }
        }

        convertedIBAN += IBAN.substring(2, 4);

        while (counter > -1) {
            if (convertedIBAN.charAt(counter) > '0') {
                convertedIBAN = convertedIBAN.substring(counter);
                counter = -1;
            }
            else {
                counter++;
            }
        }
        
        if (calculateModulus(convertedIBAN, 97) == 1.0) {
            System.out.println("This IBAN is valid!");
        }
        else {
            System.out.println("This IBAN is invalid!");
        }

        input.close();
    }

    public static int calculateModulus(String largeNumber, int divisor) {
        int remainder = 0;
        
        for (int i = 0; i < largeNumber.length(); i++) {
            int digit = largeNumber.charAt(i) - '0';
            remainder = (remainder * 10 + digit) % divisor;
        }

        return remainder;
    }
}
