class Solution {

    public void reverseWords(char[] s) {

        reverse(s, 0, s.length - 1);

        int index = 0;

        while(index < s.length){
            int start = index;

            while(index < s.length && s[index] != ' '){
                index++;
            }

            reverse(s, start, index - 1);
            index++;
        }
    }

    private void reverse(char [] s, int left, int right){

        while(left < right){
            swap(s, left, right);
            left++;
            right--;
        }
    }

    private void swap(char [] s, int left, int right){
        char temp = s[right];
        s[right] = s[left];
        s[left] = temp;
    }
}
