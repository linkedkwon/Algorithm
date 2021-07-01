import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;

public class P1920{
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		//1. input stream
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[Integer.parseInt(in.readLine())];
		
		String nums = in.readLine();
		StringTokenizer st = new StringTokenizer(nums);
		
		for(int i=0; i<arr.length; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		//2. sorting
		Arrays.sort(arr);
		
		int[] output = new int[Integer.parseInt(in.readLine())];
		st = new StringTokenizer(in.readLine());
		
		for(int i=0; i<output.length; i++)
			output[i] = bs(arr, Integer.parseInt(st.nextToken()));
		
		//4. print output
		for(int i=0; i< output.length; i++)
			System.out.println(output[i]);
	}
	
	//3. output stream using binary search
	public static int bs(int[] arr, int m) {
		int left = 0, right = arr.length-1;
		
		while(true) {
			//* break condition
			int idx = (left+right)/2;
			if(arr[idx] == m) return 1;
			if(left == right) return 0;
			
			//* move condition
			left = (arr[idx] < m) ? idx+1 : left;
			right = (arr[idx] > m) ? idx : right;		
		}
	}
}
