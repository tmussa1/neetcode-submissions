class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        restoreIp(s, 0, new LinkedList<String>(), result);
        return result;
    }

    private void restoreIp(String ip, int index, LinkedList<String> currList, List<String> result){

        if(currList.size() > 4){
            return;
        }

        if(index == ip.length() && currList.size() == 4){
            result.add(String.join(".", currList));
            return;
        }

        for(int i = index; i < ip.length(); i++){
            String subIp = ip.substring(index, i + 1);
            if(isValidIp(subIp)){
                currList.add(subIp);
                restoreIp(ip, i + 1, currList, result);
                currList.removeLast();
            }
        }
    }

    private boolean isValidIp(String ip){

        if(ip.length() > 1 && ip.charAt(0) == '0'){
            return false;
        }


        if(ip.length() > 3){
            return false;
        }

        int parsedIp = Integer.parseInt(ip);

        return parsedIp >= 0 && parsedIp < 256;
    }
}