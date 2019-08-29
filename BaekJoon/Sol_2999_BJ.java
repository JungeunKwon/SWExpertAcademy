import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Sol_2999_BJ {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringBuilder sb = new StringBuilder();
		int N = input.length();
		int R = 0;
		int C = 0;
		for(int i = 1; i <= N; i++)
		{
			for(int j = 1; j <= N; j ++)
			{
				if(i <= j && i * j == N)
				{
					if(i > R)
					{
						R = i;
						C = j;
					}
				}
			}
		}
		char [][] arr = new char[R][C];
		int k =0;
		for(int i = 0; i < C; i ++)
		{
			for(int j = 0; j < R; j ++)
			{
				arr[j][i] = input.charAt(k);
				k++;
			}
		}
		for(int i = 0; i < R; i ++)
		{
			for(int j = 0; j < C; j++)
			{
				sb.append(arr[i][j]);
			}
		}
		System.out.println(sb.toString());
	}
}
