import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {
    public static Set<Character> findUnique(String str){
        Set<Character> set1 = new HashSet<>();

        str.chars()
                .mapToObj(c -> (char) c)
                .filter(n -> !(set1.add(n)))
                .collect(Collectors.toSet());

        return (!set1.isEmpty() ? set1 : null);

    }

    public static Character findUniqueChar(String str){
        //final Character result;
        Map<Character, Long> map =  str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c-> c, Collectors.counting()));

        map.forEach((k, v)->{
            if(v == 1){
                final Character result = k;
            }
        });
        return null;

    }

    public static void main(String[] args){
        String str = "I am studying streams today";
        System.out.println(findUnique(str));
    }
}
