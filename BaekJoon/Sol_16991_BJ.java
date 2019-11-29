import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Sol_16991_BJ {
	public static int N;
	public static double arr[][], dp[][];
	public static final int INF = 987654321;
	public static final int START = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		arr = new double[N][N];
		dp = new double[N][1<<N];
		List<int[]> list = new ArrayList<>();
		for(int i = 0; i < N ; i ++)
		{
			st = new StringTokenizer(br.readLine());
			int temp[] = new int[2];
			temp[0] = Integer.parseInt(st.nextToken());
			temp[1] = Integer.parseInt(st.nextToken());
			list.add(temp);
		}
		for(int i = 0; i < N ; i ++)
		{
			Arrays.fill(dp[i], INF);
			for(int j = 0; j < N ; j ++)
			{
				if( i == j)
				{
					arr[i][j] = 0;
					continue;
				}
				double result = cal(list.get(i), list.get(j));
				arr[i][j] = result;
			}
		}
		
		System.out.println(tsp(START, 1<<START));
	}
	private static double tsp(int cur, int visited) {
		//dp 구해졌을때
		if(dp[cur][visited]!=INF)return dp[cur][visited];
		//종료조건
		if(visited == (1<<N) - 1)
		{
			if(arr[cur][START] == 0) return INF;
			else
				return arr[cur][START];
		}
		//dp구하기
		for(int i = 0; i < N; i ++)
		{
			if(arr[cur][i] == 0 || (visited &(1<<i)) > 0) continue;
			dp[cur][visited] = Math.min(dp[cur][visited], tsp(i, visited | (1<<i))+arr[cur][i]);
		}
		return dp[cur][visited];
	}
	private static double cal(int[] is, int[] is2) {
		int x1 = is[0];
		int y1 = is[1];
		int x2 = is2[0];
		int y2 = is2[1];
		double x = Math.pow((x1-x2), 2);
		double y = Math.pow((y1-y2), 2);
		return Math.sqrt(x+y);
	}

}
