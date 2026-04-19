class Solution {
    public boolean isPalindrome(String s) {

        s = s.replaceAll("[^a-zA-Z0-9]", "");

        int left = 0, right = s.length() - 1;

        while(left < right){
            char leftChar = Character.toLowerCase(s.charAt(left));
            char rightCar = Character.toLowerCase(s.charAt(right));

            if(leftChar != rightCar){
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
