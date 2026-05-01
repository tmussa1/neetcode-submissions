class Solution {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        fillImage(image, sr, sc, color, image[sr][sc], new HashSet<String>());

        return image;
    }

    private void fillImage(int[][] image, int row, int col, 
                        int color, int initialColor, Set<String> visited){
        
        String key = row + "," + col;

        if(row < 0 || row == image.length || col < 0 || col == image[0].length
            || image[row][col] != initialColor || visited.contains(key)){
                return;
        }

        image[row][col] = color;

        visited.add(key);

        fillImage(image, row + 1, col, color, initialColor, visited);
        fillImage(image, row - 1, col, color, initialColor, visited);
        fillImage(image, row, col + 1, color, initialColor, visited);
        fillImage(image, row, col - 1, color, initialColor, visited);
    }
}