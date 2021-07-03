import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P2805 {

	public static void main(String[] args) throws Exception{
		
		//1. input stream
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[Integer.parseInt(st.nextToken())];
		Long m = Long.parseLong(st.nextToken());
		
		//2. to get the range of size from min to max
		st = new StringTokenizer(br.readLine());
		
		long right = 0;
		for(int i=0; i< arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			right = Math.max(right, arr[i]);
		}
		long left = 0;
		long mid = 0;
		
		//3. output stream using binary search
		while(left <= right) {
			mid = (left+right) / 2;
			
			long rest = 0;
			for(int i=0; i<arr.length; i++)
				rest += arr[i] > mid ? arr[i]-mid : 0;
			
			if(m <= rest) left = mid+1;
			else right = mid-1;
		}
		System.out.println(right);
	}
}