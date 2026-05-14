class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();

        findPalindromeSubstring(result, new LinkedList<String>(), s, 0);

        return result;
    }

    private void findPalindromeSubstring(List<List<String>> result,
        LinkedList<String> currList, String s, int index){

        if(index >= s.length()){
            result.add(new ArrayList<>(currList));
            return;
        }

        for(int i = index; i < s.length(); i++){

            String substring = s.substring(index, i + 1);

            if(isPalindrome(substring)){
                currList.add(substring);
                findPalindromeSubstring(result, currList, s, i + 1);
                currList.removeLast();
            }
        }
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
