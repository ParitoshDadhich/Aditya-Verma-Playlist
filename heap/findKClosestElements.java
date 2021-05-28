class Solution {
    
    class Pair{
        int key;
        int value;
        
        Pair(int key, int value){
            this.key = key;
            this.value = value;
        }
        
    }
    
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        List<Integer> list = new ArrayList<>();
        
        // make max priority queue
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            new Comparator<Pair>(){
                public int compare(Pair a, Pair b){
                    // if both the keys are same then compare on the bases of their values
                    if((b.key - a.key) == 0)
                        return b.value - a.value;
                    return b.key - a.key;
                }
        });
        
        for(int i: arr){
            pq.add(new Pair(Math.abs(i-x), i));
            
            if(pq.size() > k)
                pq.poll();
        }
        
        while(pq.size() != 0){
            Pair p = pq.poll();
            list.add(p.value);
        }
        
        Collections.sort(list);
        return list;
    }
}



 



// class Solution {
//     public List<Integer> findClosestElements(int[] arr, int k, int x)
//     {
//         MergeSort ms = new MergeSort(x);
//         ms.sort(arr,0,arr.length-1);
//         int i =0;
//         ArrayList<Integer>sol = new ArrayList<>();
//         while(i!=k)
//         {
//             sol.add(arr[i]);
//             i++;
//         }
//         Collections.sort(sol);
//         return sol;
        
//     }
//     class MergeSort
//     {
//         int param;
    
//      public MergeSort(int a)
//      {
//          param = a;
//      }
//     int absVal(int ele)
//     {
//             return Math.abs(ele-param);
//     }
//     void merge(int arr[], int l, int m, int r)
//     {
        
//         int n1 = m - l + 1;
//         int n2 = r - m;
 
        
//         int L[] = new int[n1];
//         int R[] = new int[n2];
 
        
//         for (int i = 0; i < n1; ++i)
//             L[i] = arr[l + i];
//         for (int j = 0; j < n2; ++j)
//             R[j] = arr[m + 1 + j];
 
        
//         int i = 0, j = 0;
 
//         int k = l;
//         while (i < n1 && j < n2) {
//             if (absVal(L[i]) <= absVal(R[j])) {
//                 arr[k] = L[i];
//                 i++;
//             }
//             else {
//                 arr[k] = R[j];
//                 j++;
//             }
//             k++;
//         }
 
//         while (i < n1) {
//             arr[k] = L[i];
//             i++;
//             k++;
//         }
 
//         while (j < n2) {
//             arr[k] = R[j];
//             j++;
//             k++;
//         }
//     }
//         void sort(int arr[], int l, int r)
//     {
//         if (l < r) {
//             int m =l+ (r-l)/2;
 
//             sort(arr, l, m);
//             sort(arr, m + 1, r);
//              merge(arr, l, m, r);
//         }}
 
// }
// }
