import java.util.*;

public class Test {
    public static void main(String[] args){
        Map<String, Integer> map = new LinkedHashMap<>();

        map.put("a", 10);
        map.put("b", 12);
        map.put("c", 3);
        map.put("d", 41);

        Map<String, Integer> result = sortMap(map);
        for(Map.Entry<String, Integer> entry : result.entrySet()){
            System.out.println(entry.getKey()+"  "+ entry.getValue());
        }

    }

    public static Map<String, Integer> sortMap(Map<String, Integer> map){
        Map<String, Integer> result = new LinkedHashMap<>();

        int len = map.size();
        int[] arr = new int[len];

        Map<Integer, String> temp = new HashMap<>();
        int i = 0;
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            arr[i++] = entry.getValue();
            temp.put(entry.getValue(), entry.getKey());
        }

        Arrays.sort(arr);

        for(int j=0; j<len; j++){
            result.put(temp.get(arr[j]), arr[j]);
        }

        return result;

    }
}
