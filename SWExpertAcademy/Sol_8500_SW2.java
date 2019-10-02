import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol_8500_SW2 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int  a = 1; a <=T ;a++)
		{
			int N = Integer.parseInt(br.readLine().trim());
			int arr[] = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			int max = 0;
			int count = 0;
			for(int i = 0; i < N ; i ++)
			{
				arr[i] = Integer.parseInt(st.nextToken());
				if(arr[i] > max) max = arr[i];
				count += arr[i];
			}
			count += N;
			count += max;
			
			
			System.out.println("#" + a + " " + count);
		}

	}

}
