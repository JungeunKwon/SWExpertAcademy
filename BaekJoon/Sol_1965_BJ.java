import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Sol_1965_BJ {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int Size = Integer.parseInt(br.readLine());
		int arr[] = new int[Size];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i  = 0; i < Size; i ++)
		{
			arr[i] = Integer.parseInt(st.nextToken());
		}
		doLst2(arr);
		
	}
	static void doLst2(int[] arr){
		int[] dp = new int[arr.length];
		for(int i = 0; i < dp.length; i++) {
			dp[i] = 1;
			for(int j = 0; j < i; j++) {
				if(arr[i] > arr[j] && dp[i] < dp[j]+1) {
					dp[i] = dp[j] + 1;
				}
			}
		}
		int max = Arrays.stream(dp).max().getAsInt();
		System.out.println(max);
	}

}
