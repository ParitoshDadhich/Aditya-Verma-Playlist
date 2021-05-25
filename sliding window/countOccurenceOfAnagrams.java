// best question

class Solution {

    int search(String pat, String txt) {
        HashMap<Character, Integer> map = new HashMap<>();
        int l = pat.length();
        
        // map distinct values in pat
        for(int i=0; i<l; i++){
            char ch = pat.charAt(i);
            if(map.containsKey(ch))
                map.put(ch, map.get(ch)+1);
            else
                map.put(ch, 1);
        }
        
        int i=0;
        int j=0;
        int k=pat.length();
        int n=txt.length();
        int count=map.size();
        int ans=0;
        
        while(j<n){
            // calculations
            char ch = txt.charAt(j);
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch)-1);
                
                if(map.get(ch) == 0)
                    count--;
                
                // System.out.println(ch + " " + map.get(ch));
            }
            
            if(j-i+1 < k)
                j++;
            else if(j-i+1 == k){
                // cal -> ans
                if(count == 0)
                    ans++;
                
                // slide
                char firstChar = txt.charAt(i);
                if(map.containsKey(firstChar)){
                    map.put(firstChar, map.get(firstChar)+1);
                    if(map.get(firstChar) == 1)
                        count++;
                    // System.out.println(firstChar + " " + map.get(firstChar) + "dsfd " + count);
                }
                i++;
                j++;
            }
            
        }
        
        return pat.equals(" ") == true ? n : ans;
    }
}
