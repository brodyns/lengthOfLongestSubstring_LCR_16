import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        String s = "wpabwcpdw";
        System.out.println((new Solution()).lengthOfLongestSubstring(s));
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLeft = 0;
        int maxLen = 0;
        int curLen = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if(!hashMap.containsKey(s.charAt(i))){
                hashMap.put(s.charAt(i), i);
                curLen++;
            }else{
                while(s.charAt(maxLeft) != s.charAt(i)) {
                    hashMap.remove(s.charAt(maxLeft));
                    maxLeft++;
                    curLen--;
                }
                maxLeft++;
                hashMap.put(s.charAt(maxLeft), i);
            }
            if(curLen > maxLen){
                maxLen = curLen;
            }
        }
        return maxLen;
    }
}
