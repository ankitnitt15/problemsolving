public class LongestPalindromeSubstring {
    /*
	 * Find if a string is palindrome
	 * Find longest palindrome in a string
	 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000
	 * Input: "babad"

      Output: "bab"

      Note: "aba" is also a valid answer.
      */
    public static String longestPalindrome(String s){
        int len = s.length();

        int max = 0;
        int start = 0;
        boolean [][] dp = new boolean[len][len];

        //1 char palindrome
        for(int i=0; i<len; i++){
            dp[i][i] = true;
        }
        //2 char palindrome
        for (int i=0; i<len-1; i++){
            if(s.charAt(i) == s.charAt(i+1)){
                dp[i][i+1] = true;
                max = 2;
                start = i;
            }
        }
        for(int i=3; i<=len; i++){
            for(int j=0; j<=len-i;j++){
                int k = j+i-1;
                if(dp[j+1][k-1] && s.charAt(j) == s.charAt((k))){
                    dp[j][k] = true;
                    if(max < i) {
                        max = i;
                        start = j;
                    }
                }
            }
        }

        return s.substring(start, start+max);
    }

    public static void main(String[] args){
        String str = "bncabacndddca";
        String res = longestPalindrome(str);
        System.out.println(res);
    }

}
