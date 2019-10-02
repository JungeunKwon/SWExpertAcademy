import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Sol_8500_SW {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int  a = 1; a <=T ;a++)
		{
			int N = Integer.parseInt(br.readLine().trim());
			int arr[] = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N ; i ++)
			{
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			int count = 0;
			count  += arr[0] + 1;
			count += arr[0];
			for(int i = 1; i < N ; i++)
			{
				count += arr[i] - arr[i-1];
				count += arr[i] + 1;	
			}
			System.out.println("#" + a + " " + count);
		}

	}

}
