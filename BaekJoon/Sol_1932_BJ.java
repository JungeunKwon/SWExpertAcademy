import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Sol_1932_BJ {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[][] =new int[N][N];
		int memo[][] = new int[N][N];
		String line[];
		for(int i = 0; i < N; i ++)
		{
			line = br.readLine().split(" ");
			for(int j = 0; j < N ; j ++)
			{
				if(j < line.length)
				{
					arr[i][j] = Integer.parseInt(line[j]);
				}else
				{
					arr[i][j] = -1;
				}
			}
		}
		memo[0][0] = arr[0][0];
		for(int i = 0 ; i < N -1 ; i++)
		{
			for(int j = 0; j < N -1 ; j ++)
			{
				if(arr[i][j] == -1)continue;
				for(int k = 0; k < 2; k ++)
				{
					if(memo[i + 1][j+k] == 0)
						memo[i+1][j+k] = memo[i][j] + arr[i + 1][j+k];
					else
					{
						int result= memo[i][j] +  arr[i + 1][j+k];
						if(memo[i+1][j+k] < result)
							memo[i+1][j+k] = result;
					}
				}
			}
		}
		Arrays.sort(memo[N-1]);
		System.out.println(memo[N-1][N-1]);
		
	}

}
