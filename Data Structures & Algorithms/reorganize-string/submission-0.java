class Solution {
    public String reorganizeString(String s) {
        
        Map<Character, Integer> countMap = new HashMap<>();

        for(char c: s.toCharArray()){
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Character> queue = new PriorityQueue<Character>((a, b) -> countMap.get(b) - countMap.get(a));

        for(Character c: countMap.keySet()){
            queue.add(c);
        }

        char temp = '1';

        StringBuilder builder = new StringBuilder();

        while(!queue.isEmpty()){

            char curr = queue.poll();

            builder.append(curr);

            if(temp != '1'){
                queue.add(temp);
            }

            countMap.put(curr, countMap.getOrDefault(curr, 0) - 1);

            if(countMap.get(curr) == 0){
                countMap.remove(curr);
                temp = '1';
            } else {
                temp = curr;
            }
        }

        if(builder.length() != s.length()){
            return "";
        }

        return builder.toString();
    }
}