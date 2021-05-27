class Solution {
    public String minWindow(String s, String t) {
        
        int size = s.length();
        int len = t.length();
        if(len>size || size==0 || len==0)
            return "";
        
        HashMap<Character, Integer> map = new HashMap<>();
        // storing characters of t in map
        for(int i=0; i<len; i++){
            char ch = t.charAt(i);
            if(map.containsKey(ch))
                map.put(ch, map.get(ch)+1);
            else
                map.put(ch, 1);
        }       
        
        // to keep the track of distict characters of t;
        int count = map.size();
        
        int i=0;
        int j=0;
        int min = Integer.MAX_VALUE;
        
        // start and end will keep track the starting and ending index of the desired window
        int start = -1;
        int end = -1;
        while(j<size){
            // calculations
            char ch = s.charAt(j);
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch)-1);
                
                // if the count of any character of t become zero then we decrease count by 1;
                count = map.get(ch) == 0 ? --count : count;
            }
             
            // count > 0 shows we have not got the desired window yet;
            if(count > 0)
                j++;
            
            // window contains all the characters of t with their respective counts;
            else if(count == 0){
                
                // now we are trying to minizie the length of the window by increasing i
                // we will be keep on doing until count > 0;
                while(count ==0){
                    char c = s.charAt(i);
                    // if c is present in map
                    if(map.containsKey(c)){
                        map.put(c, map.get(c)+1);
                        if(map.get(c) > 0)
                            count++;
                    }
                    
                    if(min > j-i+1){
                        min = j-i+1;
                        start = i;
                        end = j;
                    }
                    i++;
                }
                j++;
            }
            
        }

        return (start == -1 || end == -1) ? "" : s.substring(start, end+1);
    }
}
