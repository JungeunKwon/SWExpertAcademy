import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Sol_11726_BJ {

	public static void main(String[] args) throws Exception{
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		dp = new long[1001];
		dp[1] = 1;
		dp[2] = 2;
		fibo(n);
		System.out.println(dp[n]);
			
	}
	static long[] dp;
	private static long fibo(int num) {
		if(num == 1) return 1;
		if(num==2) return 2;
		if(dp[num] != 0)
		{
			return dp[num];
		}	
		dp[num] = (fibo(num-1) + fibo(num-2))%10007;
		return dp[num] ;
	}
}
