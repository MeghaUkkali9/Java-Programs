package String;

public class BinaryReversal {
    public int binaryReversal(String input) {
        if (input.length() == 0) {
            return -1;
        }

        int parsedNumber = parseInput(input);
        int decimalNumber = 0, num = 1;
        int temp = parsedNumber;

        while (temp > 0) {
            int temp_lastDigit = temp % 10;
            temp = temp / 10;
            decimalNumber += temp_lastDigit * num;
            num = num * 2;
        }

        return decimalNumber;
    }

    private int parseInput(String input) {
        int number = Integer.parseInt(input);
        StringBuilder result = new StringBuilder();

        for (int i = 8 - 1; i >= 0; i--) {
            int mask = 1 << i;
            result.append((number & mask) != 0 ? 1 : 0);
        }
        return Integer.parseInt(String.valueOf(new StringBuilder(result.reverse())));
    }

    public static void main(String[] args) {
        BinaryReversal binaryReversal = new BinaryReversal();
        System.out.println(binaryReversal.binaryReversal("47"));
    }
}
