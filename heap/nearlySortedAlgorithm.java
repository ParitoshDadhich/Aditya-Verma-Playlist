
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int q=0; q<t; q++){
		    int n = sc.nextInt();
		    int k = sc.nextInt();
		    int arr[] = new int[n];
		    
		    for(int i=0; i<n; i++)
		        arr[i] = sc.nextInt();
		    
		    sort(arr, k);
		    
		    for(int i=0; i<n; i++)
		        System.out.print(arr[i] + " ");
		    
		    System.out.println();
		}
	}
	
	private static void sort(int arr[], int key){
	    PriorityQueue<Integer> pq = new PriorityQueue<>();
	    int k=0;
	    for(int i: arr){
	        pq.add(i);
	        if(pq.size() > key)
	            arr[k++] = pq.poll();   
	    }
	    
	    int n = arr.length;
	    for(; k<n; k++)
	        arr[k] = pq.poll();
	    
	}
}
