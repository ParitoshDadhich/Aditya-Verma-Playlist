
class Solution
{
    //Function to find the smallest positive number missing from the array.
    static int missingNumber(int arr[], int size)
    {
        HashSet<Integer> hs = new HashSet<>();
        
        for(int i: arr)
            hs.add(i);
        
        int ans = -1;
        for(int i=1; i<Integer.MAX_VALUE; i++){
            if(!hs.contains(i)){
                ans = i;
                break;
            }
        }   
        
        return ans;
    }
}
