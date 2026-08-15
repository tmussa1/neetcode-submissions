class Solution {
    public List<String> generateParenthesis(int n) {
        
        List<String> result = new ArrayList<>();

        generate(result, new StringBuilder(), 0, 0, n);

        return result;
    }

    private void generate(List<String> result, StringBuilder builder, int openCount, int closeCount, int n){

        if(openCount > n || closeCount > n){
            return;
        }

        if(openCount == n && closeCount == n){
            result.add(new String(builder));
            return;
        }

        builder.append('(');
        generate(result, builder, openCount + 1, closeCount, n);
        builder.deleteCharAt(builder.length() - 1);
        
        if(closeCount < openCount){
            builder.append(')');
            generate(result, builder, openCount, closeCount + 1, n);
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}
