class Solution {

    public String longestPalindrome(String s) {
        
        char [] word = s.toCharArray();
        String answer = "";

        int index = 0, length = 0;

        while(index < word.length){

            String result = palindromeLength(s, word, index, index);

            if(result.length() > length){
                answer = result;
                length = result.length();
            }

            result = palindromeLength(s, word, index, index + 1);

            if(result.length() > length){
                answer = result;
                length = result.length();
            }

            index++;
        }

        return answer;
    }

    private String palindromeLength(String s, char [] word, int left, int right){

        int length = 0;
        String result = "";

        while(left >= 0 && right < word.length && word[left] == word[right]){
            if(right - left + 1 > length){
                result = s.substring(left, right + 1);
            }
            length = Math.max(length, right - left + 1);
            left--;
            right++;
        }


        return result;
    }
}
