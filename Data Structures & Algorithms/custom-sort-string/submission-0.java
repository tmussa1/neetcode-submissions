class Solution {
    public String customSortString(String order, String s) {
        
        Map<Character, Integer> orderMap = new HashMap<>();

        for(int index = 0; index < order.length(); index++){
            orderMap.put(order.charAt(index), index);
        }

        int [] indexes = new int[s.length()];

        for(int index = 0; index < s.length(); index++){
            indexes[index] = orderMap.getOrDefault(s.charAt(index), -1);
        }

        Arrays.sort(indexes);

        System.out.println(Arrays.toString(indexes));

        StringBuilder builder = new StringBuilder();

        int index = 0;

        while(index < s.length() && indexes[index] < 0){
            index++;
        }

        while(index < s.length()) {
            builder.append(order.charAt(indexes[index]));
            index++;
        }

        index = 0;
        while(index < s.length()) {
            if(!orderMap.containsKey(s.charAt(index))){
                 builder.append(s.charAt(index));
            }
            index++;
        }

        return builder.toString();
    }
}