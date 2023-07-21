/*Design a class to calculate the median of a number stream. The class should have the following two methods:

        insertNum(int num): stores the number in the class
findMedian(): returns the median of all numbers inserted in the class
If the count of numbers inserted in the class is even, the median will be the average of the middle two numbers.

        Example 1:

        1. insertNum(3)
        2. insertNum(1)
        3. findMedian() -> output: 2
        4. insertNum(5)
        5. findMedian() -> output: 3
        6. insertNum(4)
        7. findMedian() -> output: 3.5

        import java.util.*;*/

import java.util.*;
import java.util.stream.Collectors;
import java.lang.*;

class MedianOfAStream {
    //Storage : Array :[1,2,4,3,5] [5,1,2,4,1] 1,2,4,1,5
    //Sort : Arrays.sort() = [-5, 1,2,3,4,5]
    //Size = 5 , odd : arr[2]
    // [1,2,3,4,5]
    int size;
   // int arr[];
    List<Integer> arr;
    public MedianOfAStream(){
        //this.size = size;
        arr = new ArrayList<>();
    }
    public void insertNum(int num) {

        arr.add(num);
        Collections.sort(arr);

    }

    public double findMedian() {
        int len = arr.size();
        double median = 0.0;System.out.println(arr.get((len/2)));
        if(len %2 == 0){
            median = (arr.get((len/2)-1) + arr.get(len/2))/2.0;
        }
        else{
            median = arr.get(len/2);
        }
        return median;
    }

    public static void main(String[] args) {
        MedianOfAStream medianOfAStream = new MedianOfAStream();
        medianOfAStream.insertNum(3);
        medianOfAStream.insertNum(1);
        System.out.println("The median is: " + medianOfAStream.findMedian());
        medianOfAStream.insertNum(5);
        System.out.println("The median is: " + medianOfAStream.findMedian());
        medianOfAStream.insertNum(4);
        System.out.println("The median is: " + medianOfAStream.findMedian());
        List<String> arr = new ArrayList<>();
        arr.add("big inner case");
        Map<String, String> caseLotNames = arr.stream().map(e->{
            String s = e.substring(0,1).toUpperCase()+e.substring(1);
            return new String[]{e, s};        })
                .collect(Collectors.toMap(data -> data[0], data -> data[1]));
        System.out.println(caseLotNames);
    }
}
