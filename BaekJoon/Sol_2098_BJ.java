import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Sol_2098_BJ {
	public static final int INF = Integer.MAX_VALUE - 1000000;
	public static final int START = 0;
	public static int arr[][];
	public static int dp[][];
	public static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		dp = new int[N][1<<N];

		StringTokenizer st; 
		for(int i = 0; i < N; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N ; j ++)
			{
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==0) arr[i][j] = INF;
			}
		}
		for (int temp[] : dp) {
			Arrays.fill(temp, -1);
		}
		System.out.println(solve(START,  1<<START));
//		for(int i = 0; i < N ; i++) System.out.println(Arrays.toString(dp[i]));
	}

	private static int solve(int cur, int B) {
		
		if (dp[cur][B] != -1) return dp[cur][B];
		if (B == (1 << N) - 1) {
			dp[cur][B] = arr[cur][START];
			return dp[cur][B];
//			return dp[cur][B] = (arr[cur][START] != INF ? arr[cur][START] : INF);
		}

		// 하위 문제
		dp[cur][B] = INF;
		for (int i = 0; i < N; i++) {

			// 갈 수 없거나, 방문했던 마을이라면
			if (arr[cur][i] == INF || (B & (1 << i)) > 0) continue;
			
			dp[cur][B] = Math.min(dp[cur][B], solve(i, B | (1 << i)) + arr[cur][i]);
		}

		return dp[cur][B];
	}

}
