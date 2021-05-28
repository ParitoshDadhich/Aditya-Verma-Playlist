class Solution {
    class Pair{
        int key;
        char value;
        
        Pair(int key, char value){
            this.key = key;
            this.value = value;
        }
    }
    
    public String frequencySort(String s) {
        int l = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        HashSet<Character> hs = new HashSet<>();
        
        // custom max heap
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>(){
            public int compare(Pair a, Pair b){
                if(a.key == b.key)
                    return b.value - a.value;
                return b.key - a.key;
            }
        });
        
        // maping values
        for(char ch: s.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0)+1);
            hs.add(ch);
        }
        
        // adding values in the max heap;
        for(Character ch: hs)
            pq.add(new Pair(map.get(ch), ch));
        
        
        String ans = "";
        while(pq.size() != 0){
            char val = pq.peek().value;
            int freq = pq.peek().key;
            
            for(int i=0; i<freq; i++)
                ans += val;
            
            pq.poll();
        }
        
        return ans;
    }
}
