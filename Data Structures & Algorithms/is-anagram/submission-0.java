class Solution {
    public boolean isAnagram(String s, String t) {

       if (s.length() != t.length()){
        return false;
       }

       Map<Character, Integer> sMap = new HashMap<>();
       Map<Character, Integer> tMap = new HashMap<>();

       char [] sArr = s.toCharArray();
       char [] tArr = t.toCharArray();
       int length = s.length();

       Arrays.sort(sArr);
       Arrays.sort(tArr);

       return Arrays.equals(sArr, tArr);
    }
}
