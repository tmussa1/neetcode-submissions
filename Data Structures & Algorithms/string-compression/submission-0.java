class Solution {
    public int compress(char[] chars) {
        
        int writeIndex = 0, readIndex = 0;

        while(readIndex < chars.length){

            int start = readIndex;

            while(readIndex < chars.length && chars[start] == chars[readIndex]){
                readIndex++;
            }

            chars[writeIndex++] = chars[start];

            if(readIndex - start > 1){

                String digits = String.valueOf(readIndex - start);

                for(int i = 0; i < digits.length(); i++){
                    chars[writeIndex + i] = digits.charAt(i);
                }

                writeIndex += digits.length();
            } 
        }

        return writeIndex;
    }
}