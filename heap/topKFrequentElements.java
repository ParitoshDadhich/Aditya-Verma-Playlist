
class Solution {
    
    class Pair{
        int key;
        int value;
        
        Pair(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    
    
    public int[] topKFrequent(int[] arr, int k) {
        
        // map to store the frequency of elements;
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> hs = new HashSet<>();      // for easy traversal over a map;
        for(int i: arr){
            if(map.containsKey(i))
                map.put(i, map.get(i)+1);
            else
                map.put(i, 1);
            
            hs.add(i);
        }
        
        // forming a min heap;
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            new Comparator<Pair>(){
                public int compare(Pair a, Pair b){
                    return a.key-b.key;
                }
        });
    
        
        // looping over values
        for(Integer i: hs){
            pq.add(new Pair(map.get(i), i));
            if(pq.size() > k)
                pq.poll();
        }
        
        
        int n = pq.size();
        int ans[] = new int[n];
        
        for(int i=0; i<n; i++){
            Pair p = pq.poll();
            ans[i] = p.value;
        }
        
        return ans;
        
    }
}
