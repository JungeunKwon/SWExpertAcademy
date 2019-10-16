import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class Sol_1976_BJ {
	public static int N;
	public static int M;
	public static int parent[];
	public static int arr[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		parent = new int[N+1];
		for(int i = 0; i <= N; i ++)
		{
			parent[i] = i;
		}
		arr = new int[N + 1][N + 1];
		StringTokenizer st;
		for(int i = 1; i <= N; i ++)
		{
			st  = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j ++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 1)
				{
					unionSet(i, j);
				}
			}
		}
		boolean flag = false;
		int travel[] = new int[M];
		st  = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i ++)
		{
			travel[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 0; i < M - 1; i ++)
		{
			if(findSet(travel[i]) != findSet(travel[i+1])) flag = true;
		}
		if(flag)
		{
			System.out.println("NO");
		}else
		{
			System.out.println("YES");			
		}
		
			
	}
	private static void unionSet(int a, int b) {
		a = findSet(a);
		b = findSet(b);
		if(a!=b)
		{
			parent[a] = b;
		}
		
	}
	private static int findSet(int a) {
		if(parent[a] == a)
			return a;
		else
		{
			int p = findSet(parent[a]);
			parent[a] = p;
			return p;
		}
	}

}
