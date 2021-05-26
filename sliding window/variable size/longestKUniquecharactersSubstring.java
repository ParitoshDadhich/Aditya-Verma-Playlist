
class Solution {
    public int longestkSubstr(String s, int k) {
        int i=0;
        int j=0;
        int size = s.length();
        int max=-1;
        HashMap<Character, Integer> map = new HashMap<>();
        
        while(j<size){
            // calculation
            char ch = s.charAt(j);
            if(map.containsKey(ch))
                map.put(ch, map.get(ch)+1);
            else
                map.put(ch, 1);
                
            // hitting the condition;
            if(map.size() < k)
                j++;
            
            // when we hit the condition
            else if(map.size() == k){
                max = Math.max(max, j-i+1);
                j++;
            }
            
            // when condition overflows
            else if(map.size() > k){
                // we will be removing untill map size becomes samller of equal to k
                 while(map.size() > k){
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
