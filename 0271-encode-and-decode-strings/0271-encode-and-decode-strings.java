public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        // Hello/World/
        StringBuilder sb = new StringBuilder();
        for(String str: strs){
            sb.append(str).append("π");
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> strs = new ArrayList<>();
        int lastIndex = 0;
        while(true){
            int index = s.indexOf("π", lastIndex);
            if(index<0){
                break;
            }
            String str = s.substring(lastIndex, index);
            strs.add(str);
            lastIndex = index+1;
        }
        return strs;
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));