class Solution {

    public String applySubstitutions(List<List<String>> replacements, String text)   {
        
        Map<String, List<String>> dependentMap = new HashMap<>();
        Map<String, Integer> indegreeMap = new HashMap<>();
        Map<String, String> keyMap = new HashMap<>();

        for(List<String> replacement: replacements){
            String key = replacement.get(0);
            String value = replacement.get(1);
            keyMap.put(key, value);
        }

        mapDependency(replacements, dependentMap, indegreeMap);

        StringBuilder builder = new StringBuilder();

        Queue<String> queue = new LinkedList<>();
        
        for(Map.Entry<String, Integer> entry: indegreeMap.entrySet()){
            if(entry.getValue() == 0){
                queue.add(entry.getKey());
            }
        }

        while(!queue.isEmpty()){

            int size = queue.size();

            for(int i = 0; i < size; i++){

                String curr = queue.poll();
                String value = keyMap.get(curr);

                int index = 0;
                StringBuilder val = new StringBuilder();

                while(index < value.length()){
                    char c = value.charAt(index);

                    if(c == '%'){
                        val.append(keyMap.get(value.charAt(index + 1) + ""));
                        index += 3;
                    } else {
                        val.append(c);
                        index++;
                    }
                }

                for(String neighbor: dependentMap.get(curr)){
                    indegreeMap.put(neighbor, indegreeMap.getOrDefault(neighbor, 0) - 1);

                    if(indegreeMap.get(neighbor) == 0){
                        queue.add(neighbor);
                    }
                }

                  keyMap.put(curr, val.toString());
            }
        }

        int index = 0;

        while(index < text.length()){
            char c = text.charAt(index);

            if(c == '%'){
                builder.append(keyMap.get(text.charAt(index + 1) + ""));
                index += 3;
            } else {
                builder.append(c);
                index++;
            }
        }

        return builder.toString();
    }

    private void mapDependency(List<List<String>> replacements, Map<String, List<String>> dependentMap, Map<String, Integer> indegreeMap){


        for(List<String> replacement: replacements){
            String key = replacement.get(0);
            String value = replacement.get(1);

            indegreeMap.putIfAbsent(key, 0);
            dependentMap.putIfAbsent(key, new ArrayList<>());

            if(value.indexOf("%") != -1){

                int index = 0;

                while(index < value.length()){

                    if(value.charAt(index) == '%'){
                        String dep = value.charAt(index + 1) + "";
                        dependentMap.putIfAbsent(dep, new ArrayList<>());
                        dependentMap.get(dep).add(key);
                        indegreeMap.put(key, indegreeMap.getOrDefault(key, 0) + 1);
                        index += 3;
                    } else {
                        index++;
                    }
                }
            } 
        }

    }
}
