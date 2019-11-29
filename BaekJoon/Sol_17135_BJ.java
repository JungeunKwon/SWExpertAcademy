import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol_17135_BJ {
	public static int N;
	public static int M;
	public static int D;
	public static int arr[][];
	public static int max;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		arr = new int[N+1][M];
		max = Integer.MIN_VALUE;
		for(int i = 0; i < N ; i ++)
		{
			st= new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++)
			{
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int arrow[] = new int[M];
		for(int i = 0; i < M; i ++)
		{
			arrow[i] = i;
		}
		int selectarr[] = new int[3];
		combi(arrow, selectarr, M, 3 );
		System.out.println(max);
	}
	private static void combi(int[] arrow, int[] selectarr, int n, int r) {
		if(r==0)
		{
			boolean visited[] ;
			int temparr[] = new int[M];
			int innercount = 0;
			for(int i = N-1; i >= 0 ; i--)
			{
				System.arraycopy(arr[i], 0, temparr, 0, M);
				visited = new boolean[M];
				int zerocount = 0;
				for(int j =0; j < M; j ++)
				{
					if(temparr[j] == 0)zerocount++;
				}
				if(zerocount == M && i >0)
				{
					System.arraycopy(arr[i-1], 0, temparr, 0, M);
				}
				for(int j = 0; j < 3 ; j ++)
				{
					int arrowx = selectarr[j];
					aa : for(int k = 0; k < M; k++)
					{
						if( temparr[k]==1 && !visited[k])
						{
							if(Math.abs(arrowx - k) + 1<= D)
							{
								visited[k] = true;
								innercount ++;
								break aa;
							}
						}
					}
				}
				if(max < innercount) max = innercount;
			}
			return;
		}
		if(n < r)
			return;
		selectarr[r-1] = arrow[n-1];
		combi(arrow, selectarr, n-1, r-1);
		combi(arrow, selectarr, n-1,r);
	}

}
