import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol_2630_BJ {
	public static int arr[][];
	public static int colorcount[];
	public static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1][N+1];
		colorcount = new int[2];
		for(int i = 0; i < N;  i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j  = 0;  j < N; j ++)
			{
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0,N,0,N);
		System.out.println(colorcount[0]) ;
		System.out.println(colorcount[1]);
	}

	private static void dfs(int istart, int iend, int jstart, int jend) {
	
		int count = 0;
		int innercount = iend - istart;
		for(int i = istart; i < iend ; i ++)
		{
			for(int j  = jstart; j < jend ; j ++)
			{
				if(arr[i][j] == arr[istart][jstart]) count ++;
				
			}
		}
		if(count == innercount*innercount) {
			colorcount[arr[istart][jstart]] ++;
			return;
		}
		else 
		{
			int imid =  (istart+iend)/2, jmid = (jstart+jend)/2;
			dfs(istart, imid, jstart, jmid);
			dfs(imid , iend, jstart, jmid);
			dfs(istart, imid, jmid , jend);
			dfs(imid, iend, jmid,jend);
		}
	}

}
