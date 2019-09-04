import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol_1486_SW {
	public static boolean visited[];
	public static int B;
	public static int min;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int a =1; a <= T; a++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			visited = new boolean[N];
			int arr[] = new int[N];
			min = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < N; i ++)
			{
				arr[i] = Integer.parseInt(st.nextToken());
			}
			top(arr,0,0);
			System.out.println("#" + a + " " + (min - B));
		}

	}
	private static void top(int[] arr, int idx, int sum) {
		if(sum >= B)
		{
			if(sum < min)
			{
				min = sum;
			}
		}
		if(idx == arr.length)
		{
			return;
		}
		
		visited[idx] = true;
		int result = arr[idx] + sum;
		top(arr, idx + 1, result);
		visited[idx] = false;
		top(arr,idx + 1,sum);
	}

}
