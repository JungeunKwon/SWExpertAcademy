import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol_4014_SW {
	public static int N;
	public static int width;
	public static int arr[][];
	public static int count;
	public static boolean visited[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int a =1 ; a<=T ;a ++)
		{
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			width = Integer.parseInt(st.nextToken());
			arr = new int[N][N];
			count = 0;
			visited = new boolean[N];
			for(int i = 0; i <N; i ++)
			{
				st = new StringTokenizer(br.readLine());
				for(int j =0; j < N; j++)
				{
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			boolean flag;
			for(int i = 0; i < N; i++)
			{
				flag =false;
				visited = new boolean[N];
				aa : for(int j = 0; j < N - 1; j++)
				{
					if(arr[i][j] < arr[i][j+1])
					{
						if(j == 0) { flag=true; break aa; }
						if(j - width < -1){ flag=true; break aa; }
						if(Math.abs(arr[i][j] - arr[i][j+1]) > 1) { flag=true; break aa; }
						for(int k = j; k > j - width ; k--)
						{
							if(arr[i][j] != arr[i][k]) { flag=true; break aa; }
							if(visited[k]){ flag=true; break aa; }
							visited[k] = true;
						}
					
					}else if(arr[i][j] > arr[i][j+1])
					{
						
						if(j + 1 + width > N){ flag=true; break aa; }
						if(Math.abs(arr[i][j+1] - arr[i][j]) > 1) { flag=true; break aa; }
						for(int k = j + 1; k < j + 1 + width; k++)
						{
							if(arr[i][j+1] != arr[i][k]){ flag=true; break aa; }
							if(visited[k]){ flag=true; break aa; }
							visited[k] = true;
						}
						j = j+width -1;
					}
				}
				if(!flag) { count ++; }
			}
			for(int j = 0; j < N ; j++)
			{
				flag =false;
				visited = new boolean[N];
				aa : for(int i = 0; i < N -1 ; i ++)
				{
					if(arr[i][j] < arr[i+1][j] )
					{
						if(i == 0) { flag=true; break aa; }
						if(i - width < -1){ flag=true; break aa; }
						if(Math.abs(arr[i][j] - arr[i+1][j]) > 1) { flag=true; break aa; }
						for(int k = i; k > i - width ; k--)
						{
							if(arr[i][j] != arr[k][j]) { flag=true; break aa; }
							if(visited[k]){ flag=true; break aa; }
							visited[k] = true;
						}
					}else if(arr[i][j] > arr[i+1][j])
					{
						if(i + 1 + width > N){ flag=true; break aa; }
						if(Math.abs(arr[i+1][j] - arr[i][j]) > 1) { flag=true; break aa; }
						for(int k = i + 1; k < i + 1 + width; k++)
						{
							if(arr[i+1][j] != arr[k][j]){ flag=true; break aa; }
							if(visited[k]){ flag=true; break aa; }
							visited[k] = true;
						}
						i = i+ width -1;
					}
				}
				if(!flag) { count ++; }
			}
			System.out.println("#" + a + " " + count);
		}

	}

}
