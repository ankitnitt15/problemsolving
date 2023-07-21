import java.util.*;

public class DegreeOfArray {
    /*Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.

    Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.
    Input: nums = [1,2,2,3,1]
    Output: 2
    Explanation:
    The input array has a degree of 2 because both elements 1 and 2 appear twice.
    Of the subarrays that have the same degree:
            [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
    The shortest length is 2. So return 2.

    Input: nums = [1,2,2,3,1,4,2]
    Output: 6
    Explanation:
    The degree is 3 because the element 2 is repeated 3 times.
            So [2,2,3,1,4,2] is the shortest subarray, therefore returning 6.*/

    public static int smallestSubsetWithSameDegree(int[] arr){
        int result = Integer.MAX_VALUE;
        int len = arr.length;
        int deg = 1;
        Map<Integer, Integer> degree = new HashMap<>();
        for(int i=0; i<len;i++){
            if(degree.containsKey(arr[i])){
                degree.put(arr[i], degree.get(arr[i])+1);
                if (deg < degree.get(arr[i]))
                    deg = degree.get(arr[i]);
            }
            else{
                degree.put(arr[i], 1);
            }
        }
        List<Integer> elem = new ArrayList<>();
        for(Map.Entry<Integer, Integer> e : degree.entrySet()){
            if(e.getValue() == deg)
                elem.add(e.getKey());
        }
        for(Integer i : elem){
            int j = 0;
            int start=0,end=0,found=0, temp=0;
            while(j<len){
                if(arr[j] == i){
                    found++;
                    if(found == 1)
                        start = j;
                    if(found == deg){
                         end = j;
                         temp = end  - start + 1;
                         break;
                    }
                }
                j++;
            }
            if(result > temp)
                result = temp;
        }
        return result;
    }

    public static void main(String[] args){
        //int arr[] = new int[]{1,2,2,3,1};
        int arr[] = new int[]{1,2,2,3,1,4,2};
        System.out.println(smallestSubsetWithSameDegree(arr));
    }
}
