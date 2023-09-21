import java.util.HashMap;
import java.util.Map;

public class TestSum {

    public int findCombinations(int [] arr, int n){
        int result = 0;
        //e.g. [ 0, 1 , 1, 2, 2 , 5, 2, -2, 0]
        //       3
        //o/p: 2
        Map<Integer, Integer> map = new HashMap<>();
        if(arr.length == 0){
            return result;
        }
        int temp =0;
        for(int i=0; i<arr.length; i++){
            if(map.containsKey(n-arr[i])){
                result++;
                temp = map.get(n-arr[i]);
                if(temp == 1){
                    map.remove(n-arr[i]);
                }
                else {
                    map.put(n-arr[i], temp - 1);
                }
            }
            else{
                if(map.containsKey(arr[i])){
                    temp = map.get(arr[i]);
                    map.put(arr[i],temp+1);
                }
                else{
                    map.put(arr[i],1);
                }

            }
        }

        return result;
    }
}
