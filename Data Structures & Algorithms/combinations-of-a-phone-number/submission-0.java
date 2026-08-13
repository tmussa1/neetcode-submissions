class Solution {
    public List<String> letterCombinations(String digits) {
        
        Map<Integer, List<Character>> phoneMap = Map.of(2, 
        List.of('a', 'b', 'c'), 3, 
        List.of('d', 'e', 'f'), 4, 
        List.of('g', 'h', 'i'), 5, 
        List.of('j', 'k', 'l'), 6, 
        List.of('m', 'n', 'o'), 7, 
        List.of('p', 'q', 'r', 's'), 8, 
        List.of('t', 'u', 'v'), 9, 
        List.of('w', 'x', 'y', 'z'));

        StringBuilder builder = new StringBuilder();
        List<String> result = new ArrayList<>();

        if(digits.length() == 0){
            return result;
        }

        backtrack(phoneMap, builder, result, digits, 0);

        return result;
    }

    private void backtrack(Map<Integer, List<Character>> phoneMap, StringBuilder builder, List<String> result, String digits, int index){


        if(index == digits.length()){
            result.add(new String(builder));
            return;
        }

        int curr = Integer.parseInt(digits.charAt(index) + "");

        for(Character neighbor: phoneMap.get(curr)){
            builder.append(neighbor);
            backtrack(phoneMap, builder, result, digits, index + 1);
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}
