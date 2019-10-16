import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol_1965_BJ2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int Size = Integer.parseInt(br.readLine());
		int arr[] = new int[Size];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i  = 0; i < Size; i ++)
		{
			arr[i] = Integer.parseInt(st.nextToken());
		}
		doLst3(arr);
		
	}
	static void doLst3(int[] arr) {
		int[] dp = new int[arr.length];
		dp[0] = arr[0]; 
		int idx = 0; 
		for (int i = 1; i < arr.length; i++) { 
			if (dp[idx] < arr[i]) { 
				dp[++idx] = arr[i]; 
			} else { 
				int ii = lower_bound(dp, idx, arr[i]);
				dp[ii] = arr[i];
			}
			
		}
		System.out.println(idx + 1);
	}
	static int lower_bound(int[] dp, int end, int n) {
		int start = 0;

		while (start < end) {
			int mid = (start + end) / 2;
			if (dp[mid] >= n) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		return end;
	}
}
