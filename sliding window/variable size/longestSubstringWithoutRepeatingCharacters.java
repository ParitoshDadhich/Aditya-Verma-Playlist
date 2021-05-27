class Solution {
    public int lengthOfLongestSubstring(String s) {
        int size = s.length();
        int i=0;
        int j=0;
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        
        while(j<size){
            // calculations
            char ch = s.charAt(j);
            if(map.containsKey(ch))
                map.put(ch, map.get(ch)+1);
            else
                map.put(ch, 1);
            
            // hitting the condition
            if(map.size() == j-i+1){
                max = Math.max(max, j-i+1);
                j++;
            }
            
            // when window contains duplicate elements
            else if(map.size() < j-i+1){
                while(map.size() < j-i+1){
                    char c = s.charAt(i);
                    
                    if(map.containsKey(c))
                        map.put(c, map.get(c)-1);
                    if(map.get(c) == 0)
                        map.remove(c);
                    i++;
                }
                j++;
            }
        }
        return max;
    }
}
