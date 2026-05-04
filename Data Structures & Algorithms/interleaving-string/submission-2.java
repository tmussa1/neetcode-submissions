class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {

        return interleave(s1, s2, s3, new HashMap<>());
    }

    private boolean interleave(String s1, String s2, String s3, Map<String, Boolean> cache){

        String key = s1 + "," + s2 + "," + s3;

        if(s3.length() == 0){
            return s2.length() == 0 && s1.length() == 0;
        }

        if(cache.containsKey(key)){
            return cache.get(key);
        }

        if(s1.length() > 0 && s1.charAt(0) == s3.charAt(0)){
            if(interleave(s1.substring(1), s2, s3.substring(1), cache)) {
                cache.put(key, true);
                return true;
            }
          
        }

        if(s2.length() > 0 && s2.charAt(0) == s3.charAt(0)){
            if(interleave(s1, s2.substring(1), s3.substring(1), cache)) {
                cache.put(key, true);
                return true;
            }
        }

        cache.put(key, false);

        return false;
    }
}
