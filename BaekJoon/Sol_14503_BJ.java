import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol_14503_BJ {
	public static int dx[] = {0,1,0,-1};
	public static int dy[] = {-1,0,1,0}; //북,동,남,서
	public static int N;
	public static int M;
	public static int arr[][];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		st = new StringTokenizer(br.readLine());
		Info firstinfo = new Info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		for(int i  = 0;  i < N ; i ++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M ; j ++)
			{
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
	
	public static class Info
	{
		int i ;
		int j;
		int dir;
		Info(int i, int j, int dir)
		{
			this.i = i;
			this.j = j;
			this.dir = dir;
		}
	
	}
	
}
