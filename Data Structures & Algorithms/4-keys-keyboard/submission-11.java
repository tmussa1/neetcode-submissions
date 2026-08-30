class Solution {
    public int maxA(int n) {
        Map<Integer, Integer> cache = new HashMap<>();
        return printA(0, n, cache);
    }

    private int printA(int index, int n, Map<Integer, Integer> cache) {

        if (index >= n) {
            return 0;
        }

        if (cache.containsKey(index)) {
            return cache.get(index);
        }

        int result = 1 + printA(index + 1, n, cache);

        if (index + 2 < n) {

            for (int pastes = 1; pastes <= n - (index + 2); pastes++) {

                int res = printA(
                        index + 2 + pastes,
                        n,
                        cache
                );

                result = Math.max(
                    result,
                    (pastes + 1) * res
                );
            }
        }

        cache.put(index, result);

        return result;
    }
}