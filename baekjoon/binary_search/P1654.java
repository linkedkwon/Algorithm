import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class P1654 {

	public static void main(String[] args) throws Exception{
		
		//1. Input stream
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[Integer.parseInt(st.nextToken())];
		int cnt = Integer.parseInt(st.nextToken());
		
		long left = 1, mid = 0, right = 0;
	
		//2. Setting to range
		for(int i=0; i<arr.length; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			right = Math.max(right, arr[i]);
		}
		
		//3. Binary Search
		while(left <= right) {
			mid = (left + right)/2;
			
			long cuts = 0; 
			for(int i=0; i<arr.length; i++) 
				cuts += arr[i]/mid;
			
			if(cuts >= cnt) left = mid+1;
			else right = mid-1;	
		}
		System.out.println(right);
	}
}