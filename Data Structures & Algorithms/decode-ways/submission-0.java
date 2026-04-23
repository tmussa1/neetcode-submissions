class Solution {
    public int numDecodings(String s) {
        int [] cache = new int[s.length()];
        Arrays.fill(cache, -1);
        return decodeWays(s, 0, cache);
    }

    private int decodeWays(String s, int index, int [] cache){

        if(index >= s.length()){
            return 1;
        }

        if(cache[index] != -1){
            return cache[index];
        }

        int result = 0;

        if(index + 1 < s.length() && isValidChars(s.substring(index, index + 2))) {
            result +=  decodeWays(s, index + 2, cache);
        }

        if(index < s.length() && isValidChars(s.substring(index, index + 1))) {
            result +=  decodeWays(s, index + 1, cache);
        } 

        cache[index] = result;

        return cache[index];
    }

    private boolean isValidChars(String word){

        if(word.charAt(0) == '0'){
            return false;
        }

        int digit = Integer.parseInt(word);

        return digit >= 1 && digit <= 26;
    }
}
