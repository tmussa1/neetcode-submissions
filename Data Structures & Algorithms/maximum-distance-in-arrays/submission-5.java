class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        PriorityQueue<Pair<Integer, Integer>> maxHeap =
                new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        PriorityQueue<Pair<Integer, Integer>> minHeap =
                new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

        for (int i = 0; i < arrays.size(); i++) {
            minHeap.offer(new Pair<>(i, arrays.get(i).get(0)));

            int last = arrays.get(i).get(arrays.get(i).size() - 1);
            maxHeap.offer(new Pair<>(i, last));
        }

        while (true) {
            Pair<Integer, Integer> min = minHeap.peek();
            Pair<Integer, Integer> max = maxHeap.peek();

            if (min.getKey().intValue() != max.getKey().intValue()) {
                return max.getValue() - min.getValue();
            }

            // Same array: try the next largest or the next smallest array.
            Pair<Integer, Integer> removedMax = maxHeap.poll();
            Pair<Integer, Integer> removedMin = minHeap.poll();

            int ans = 0;

            if (!maxHeap.isEmpty()) {
                ans = Math.max(ans,
                        maxHeap.peek().getValue() - removedMin.getValue());
            }

            if (!minHeap.isEmpty()) {
                ans = Math.max(ans,
                        removedMax.getValue() - minHeap.peek().getValue());
            }

            // Restore heaps.
            maxHeap.offer(removedMax);
            minHeap.offer(removedMin);

            return ans;
        }
    }
}