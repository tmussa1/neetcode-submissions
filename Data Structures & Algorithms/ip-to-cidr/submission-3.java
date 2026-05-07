class Solution {
    public List<String> ipToCIDR(String ip, int n) {

        List<String> result = new ArrayList<>();

        long ipLong = ipToLong(ip);

        if(ipLong == 0L){
            result.add("0.0.0.0/32");
            return result;
        }

        while(n > 0){


            long maxBlock = ipLong & (-ipLong);

            while(maxBlock > n){
                maxBlock >>= 1;
            }

            long prefix = 32 - Long.numberOfTrailingZeros(maxBlock);

            result.add(longToIp(ipLong) + '/' + prefix);

            ipLong += maxBlock;

            n -= maxBlock;
        }

        return result;
    }

    private long ipToLong(String ip){

        long result = 0;
        String [] ipSplit = ip.split("\\.");

        for(int index = 0; index < ipSplit.length; index++){
            result = result * 256 + Long.parseLong(ipSplit[index]);
        }

        return result;
    }

    private String longToIp(long ip){

        StringBuilder builder = new StringBuilder();

        Stack<String> stack = new Stack<>();

        while(ip > 0){
            stack.push((ip % 256) + "");
            ip >>= 8;
        }

        while(stack.size() < 4){
            stack.push("0");
        }

        while(!stack.isEmpty()){
            if(builder.length() > 0){
                builder.append(".");
            }
            builder.append(stack.pop());
        }

        return builder.toString();
    }
}
