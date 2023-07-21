public class LongestCommonSubsequence {
    /*
    Given two strings, find longest common subsequence between them.
    String1 = "abcdaf"
    String2 = "acbcf"
    Output = 4 , abcf
     */

    public static int longestSubsequence(String str1, String str2){
        int len1 = str1.length();
        int len2 = str2.length();
        int [][] data = new int[len1+1][len2+1];

        for(int i=0; i<=len2; i++){
            data[0][i] = 0;
        }
        for (int i=0; i<=len1; i++){
            data[i][0] = 0;
        }

        for(int i=1; i<=len1; i++){
            for(int j=1; j<=len2; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1))
                    data[i][j] = 1 + data[i-1][j-1];
                else
                    data[i][j] = Math.max(data[i-1][j], data[i][j-1]);
            }
        }
        return data[len1][len2];
    }

    public static void main(String [] args){
        String str1 = "adafe";
        String str2 = "acbcfe";
        System.out.println(longestSubsequence(str1, str2));
    }
}
