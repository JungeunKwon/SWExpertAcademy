import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Sol_2798_BJ {

	public static void main(String[] args) throws Exception{
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st = new StringTokenizer(br.readLine());
		 int N = Integer.parseInt(st.nextToken());
		 int M = Integer.parseInt(st.nextToken());
		 int arr[] = new int[N];
		 st = new StringTokenizer(br.readLine());
		 int max = 0;
		 int sum = 0;
		 for(int i = 0; i < N; i++)
		 {
			 arr[i] = Integer.parseInt(st.nextToken());
		 }
		 
		for(int i = 0;  i < N - 2; i ++)
		{
			for(int j = i + 1 ; j < N - 1; j ++)
			{
				for(int k = j + 1; k < N ; k ++)
				{
					sum = arr[i] + arr[j] + arr[k];
					if(sum > M)
						continue;
					if(max < sum)
						max = sum;
				}
			}
		}
		System.out.println(max);
		 
	}

}
