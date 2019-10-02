import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Sol_3282_SW {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int a =1; a<=T ; a++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int arr[][] = new int[N+1][2];
			int knapsack[][] = new int[N + 1][K + 1];
			for(int i =  1; i <= N; i ++)
			{
				st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
				
			}
			for(int i = 1 ; i <= N; i ++)
			{
				for(int j = 0; j <= K ; j++)
				{
					if(arr[i][0] > j) knapsack[i][j] = knapsack[i-1][j];
					else
					{
		
						int temp = knapsack[i-1][j-arr[i][0]] + arr[i][1] ;
						int temp2 = knapsack[i-1][j];
						if(temp>temp2) knapsack[i][j] = temp;
						else knapsack[i][j] = temp2;
					}
				}
			}
			System.out.println("#" + a + " " + knapsack[N][K]);
		}
		
	}

}
