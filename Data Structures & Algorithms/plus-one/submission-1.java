class Solution {
    public int[] plusOne(int[] digits) {
        
        int index = digits.length - 1;

        if(digits[index] < 9){
            digits[index] += 1;
            return digits;
        }

        List<Integer> result = new ArrayList<>();

        int carry = 1;

        while(index >= 0){
            result.add((digits[index] + carry) % 10);
            carry = (digits[index] + carry) / 10;
            index--;
        }

        if(carry > 0){
            result.add(carry);
        }

        Collections.reverse(result);

        return result.stream().mapToInt(i -> i).toArray();
    }
    
}
