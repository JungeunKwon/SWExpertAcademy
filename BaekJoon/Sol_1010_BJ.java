import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Sol_1010_BJ {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T  = Integer.parseInt(br.readLine());
		for(int a =1; a<=T; a++)
		{
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			BigInteger dp[][] = new BigInteger[101][101];
			dp[0][0] = new BigInteger("1");
			dp[1][0] = new BigInteger("1");
			dp[1][1] = new BigInteger("1");
			
			for(int  i =2; i <=100; i ++)
			{
				dp[i][0] = new BigInteger("1");
				dp[i][1] = new BigInteger(String.valueOf(i));
				dp[i][i] = new BigInteger("1");
				for(int j  = 1; j <i; j ++)
				{
					dp[i][j]  = (dp[i-1][j-1]).add(dp[i-1][j]);
				
				}
			}
			System.out.println(dp[n][m]);
		}
	}
}
