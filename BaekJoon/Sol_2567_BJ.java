import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Sol_2567 {
	public static int [] dx = {1,-1,0,0};
	public static int [] dy = {0,0,-1,1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int arr[][] = new int[102][102];
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i = 0; i < N ; i++)
		{
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y =Integer.parseInt(st.nextToken());
			for(int j = y + 10; j > y; j--)
			{
				for(int k = x; k < x + 10; k++)
				{
					arr[j][k] = 1;
					
				}
			}
		}
		int result = find(arr);
		
		System.out.println(result);
		
	}
	private static int find(int[][] arr) {
		int count = 0; 
		for(int i = 1; i < 101; i++)
		{
			for(int j = 1; j < 101; j ++)
			{
				if(arr[i][j] == 1)
				{
					int tx = 0 , ty = 0;
				
					for(int k =0 ;  k <4; k++)
					{
						tx = dx[k] + j;
						ty = dy[k] + i;
						if(arr[ty][tx] == 0)
						{
							count ++;
						}
					}
					
				}
			}
		}
		return count;
		
	}

}
