
class Solution
{
    long minCost(long arr[], int n) 
    {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(long i: arr)
            pq.add(i);
        
        long cost = 0;
        while(pq.size() >= 2){
            long firstMin = pq.poll();
            long secondMin = pq.poll();
            
            cost += firstMin + secondMin;
            pq.add(firstMin + secondMin);
       }
       
       return cost;
    }
}
