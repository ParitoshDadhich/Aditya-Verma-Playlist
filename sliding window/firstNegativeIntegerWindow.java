import java.util.*;

public class Solution 
{
    public static ArrayList<Integer> firstNegativeInteger(ArrayList<Integer> arr, int k, int n)
    {
        int i = 0;
        int j = 0;
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        while(j<n){
            if(arr.get(j) < 0)
                queue.add(arr.get(j));
            if((j-i+1)<k)
                j++;
            else if((j-i+1)==k){
                if(queue.size() == 0)
                    list.add(0);
                else if(arr.get(i) == queue.element()){
                	int s = queue.poll();
                	list.add(s);
            	}
                else{
                    list.add(queue.element());
            	}
                    i++;
                    j++;
                }
            }
        return list;
    }
}
