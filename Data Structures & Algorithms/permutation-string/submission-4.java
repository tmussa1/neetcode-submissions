class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if(s1.length() > s2.length()) return false;
        
        int [] s1Count = new int[26];
        int [] s2Count = new int[26];

        for(int index = 0; index < s1.length(); index++){
            s1Count[s1.charAt(index) - 'a']++;
            s2Count[s2.charAt(index) - 'a']++;
        }

        int index = s1.length();

        while(index < s2.length()){

            if(Arrays.equals(s1Count, s2Count)){
                return true;
            }

            s2Count[s2.charAt(index - s1.length()) - 'a']--;
            s2Count[s2.charAt(index) - 'a']++;
            index++;
        }

        if(Arrays.equals(s1Count, s2Count)){
            return true;
        }

        return false;
    }
}
