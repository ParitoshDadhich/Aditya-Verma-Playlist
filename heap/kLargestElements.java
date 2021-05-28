
class Solution
{
    public static ArrayList<Integer> kLargest(int arr[], int n, int k)
    {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int i: arr){
            pq.add(i);
            if(pq.size() > k)
                pq.poll();
        }
        
        n = pq.size();
        int temp[] = new int[n];
        for(int i=0; i<n; i++)
            temp[i] = pq.poll();
        
        
        for(int i=n-1; i>=0; i--)
            ans.add(temp[i]);
            
        return ans; 
    }
}
