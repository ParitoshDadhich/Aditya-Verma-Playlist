class Solve {
    int[] findTwoElement(int arr[], int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i: arr)
            if(map.containsKey(i))
                map.put(i, map.get(i)+1);
            else
                map.put(i, 1);
 
 
            
        int missing = -1;
        int repeat = -1;
        
        for(int i=1; i<=n; i++){
            // System.out.println(map.containsKey(i) + " " + map.get(i));
            if(map.containsKey(i)){
                if(map.get(i) == 2)
                    repeat = i;
                    // break;
            }
            else if(!map.containsKey(i))
                missing = i;
                
            // System.out.println(repeat + " " + missing);
        }
        
        int ans[] = {repeat, missing};
        
        return ans;
    }
}
