package String;
/*
Encoding is performed as follows:
The string "aaaabbсaa" is converted into "a4b2с1a2", that is,
the groups of the same characters of the input string are replaced by the symbol and the number of its repetitions in this string.

Write a program, which reads the string, encodes it by this algorithm and outputs the encoded sequence. The encoding must be case sensitive.
Note, string can contain only a single character.
 */
import java.util.Scanner;

public class LengthEncoding {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        scanner.close();

        String encodedString = encodeString(inputString);
        System.out.println(encodedString);
    }

    public static String encodeString(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }

        StringBuilder encoded = new StringBuilder();
        char currentChar = input.charAt(0);
        int count = 1;

        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == currentChar) {
                count++;
            } else {
                encoded.append(currentChar).append(count);
                currentChar = input.charAt(i);
                count = 1;
            }
        }
        encoded.append(currentChar).append(count);
        return encoded.toString();
    }
}
