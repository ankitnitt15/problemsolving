

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
public class AlienNumbers {



        public String converter(String number, String source, String target) {
            Map<Character, Integer> sourceMap = new HashMap<>();
            Map<Integer, Character> targetMap = new HashMap<>();
            int sourceBase = source.length();
            int targetBase = target.length();

            // Populate sourceMap with character to index mapping
            for (int i = 0; i < sourceBase; i++) {
                sourceMap.put(source.charAt(i), i);
            }

            // Populate targetMap with index to character mapping
            for (int i = 0; i < targetBase; i++) {
                targetMap.put(i, target.charAt(i));
            }

            int numberSource = 0;

            // Calculate the decimal representation in the source base
            for (int i = 0; i < number.length(); i++) {
                char digit = number.charAt(i);
                int digitSource = sourceMap.get(digit);
                numberSource += Math.pow(sourceBase, i) * digitSource;
            }

            List<Character> numberTarget = new ArrayList<>();

            // Convert the decimal number to the target base
            while (numberSource > 0) {
                int remainder = numberSource % targetBase;
                numberSource /= targetBase;
                numberTarget.add(targetMap.get(remainder));
            }

            StringBuilder result = new StringBuilder();

            // Build the result string in reverse order
            for (int i = numberTarget.size() - 1; i >= 0; i--) {
                result.append(numberTarget.get(i));
            }

            return result.toString();
        }

        public static void main(String[] args) {
            AlienNumbers solution = new AlienNumbers();
            /*String number = "1011";
            String source = "01";
            String target = "0123456789";*/
            /*String number = "9";
            String source = "0123456789";
            String target = "oF8";*/
            String number = "13";
            String source = "0123456789abcdef";
            String target = "01";
            String result = solution.converter(number, source, target);
            System.out.println(result);
        }


}
