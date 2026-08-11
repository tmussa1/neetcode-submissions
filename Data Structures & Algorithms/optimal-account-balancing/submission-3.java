class Solution {
    public int minTransfers(int[][] transactions) {
        
        Map<Integer, Integer> balanceMap = new HashMap<>();

        for(int [] txn: transactions){
            int source = txn[0], dest = txn[1], amount = txn[2];
            balanceMap.put(source, balanceMap.getOrDefault(source, 0) - amount);
            balanceMap.put(dest, balanceMap.getOrDefault(dest, 0) + amount);
        }

        int result = findMinOperations(balanceMap);

        return result;
    }

    private int findMinOperations(Map<Integer, Integer> balanceMap){

        int node = -1;

        for (int person : balanceMap.keySet()) {
            if (balanceMap.get(person) != 0) {
                node = person;
                break;
            }
        }

        if (node == -1) {
            return 0;
        }

        int result = Integer.MAX_VALUE;

        int nodeBalance = balanceMap.get(node);

        for(Integer neighbor: balanceMap.keySet()){
            if (neighbor == node) {
                continue;
            }

            int neighborBalance = balanceMap.get(neighbor);

            if((nodeBalance < 0 && neighborBalance > 0) || (nodeBalance > 0 && neighborBalance < 0)){
                balanceMap.put(node, 0);
                balanceMap.put(neighbor, nodeBalance + neighborBalance);

                result = Math.min(result, 1 + findMinOperations(balanceMap));

                balanceMap.put(node, nodeBalance);
                balanceMap.put(neighbor, neighborBalance);
            }
        }

        return result;
    }
}
