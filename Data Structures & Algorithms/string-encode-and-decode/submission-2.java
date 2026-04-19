

class Solution {

    public String encode(List<String> strs) {
        
        StringBuilder builder = new StringBuilder();

        for(String str: strs){
           builder.append(str.length());
           builder.append("|");
           builder.append(str);
        }

        return builder.toString();
    }

    public List<String> decode(String str) {

        List<String> result = new ArrayList<>();

        if(str.length() == 0){
            return result;
        }

        int index = 0;


        while(index < str.length()){

            int strIndex = index;

            while(strIndex < str.length() &&
             Character.isDigit(str.charAt(strIndex)) == true){
                strIndex++;
            }

            int digit = Integer.parseInt(str.substring(index, strIndex));

            result.add(str.substring(strIndex + 1, strIndex + digit + 1));

            index = strIndex + digit + 1;
        }


        return result;
    }
}
