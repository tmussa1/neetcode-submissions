class Solution {
    public int countSubstrings(String s) {
        return findPalindromeSubstring(s, 0);
    }

    private int findPalindromeSubstring(String s, int index){

        if(index >= s.length()){
            return 0;
        }

        int result = 0;

        for(int i = index; i < s.length(); i++){

            String substring = s.substring(index, i + 1);

            if(isPalindrome(substring)){
                result += 1;
            }
        }

        result += findPalindromeSubstring(s, index + 1);

        return result;
    }

    private boolean isPalindrome(String word){

        int left = 0, right = word.length() - 1;

        while(left < right){
            if(word.charAt(left) != word.charAt(right)){
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
