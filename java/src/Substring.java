public class Substring {

    /*
    Longest substring with each characters repeated at least k times
    Input = "AABBBCCCCD", k = 3
    Output = "BBBCCCC"
     */
    public static String getSubstring(String string, int k){
        char[] str = string.toCharArray();
        int i=0, j=0;
        int start=0, end=0;
        int tempStart = 0, tempEnd = 0;
        while(j<str.length){
            if(str[i] == str[j]){
                j++;
            }
            else{
                if(j-i < k){
                    tempStart = j;
                    i = j;
                }
                else{
                    tempEnd = j;
                    if((tempEnd - tempStart) >= (end - start)) {
                        start = tempStart;
                        end = tempEnd;
                    }
                    i = j;
                }
                j++;
            }
        }
        if(str[i] == str[j-1] && j-i >=k){
            tempEnd = j;
            if((tempEnd - tempStart) >= (end - start)) {
                start = tempStart;
                end = tempEnd;
            }
        }

        return string.substring(start,end);
    }

    public static void main(String [] args){
        //String input = "AABBBCCCCD";
        String input = "AABBBCCCCDD";
        //String input = "AAABBBCCCCDD";
        //String input = "AAABBBCCDD";
        //String input = "AAABBCCCDDDDD";
        //String input = "AAABBCCCD";
        //String input = "AAABBCCCDEEEEEEEE";
        //String input = "ABCDE";
        int k = 2;
        String result = getSubstring(input, k);
        System.out.println(result);
    }
}
