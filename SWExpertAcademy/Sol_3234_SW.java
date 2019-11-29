import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Sol_3234_SW {
	public static int count;
	public static int N;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int a =1 ; a<=T ; a++)
		{
			count = 0;
			N = Integer.parseInt(br.readLine());
			int arr[] = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N ; i ++)
			{
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Perm(arr,0,0, 0);
			System.out.println("#" + a + " " + count);
		}
	}
	private static void Perm(int[] arr, int left, int right, int idx) {
		if(left< right) return;
		if(idx >= N)
		{
			count ++;
			return;
		}
		for(int i = idx ; i < N; i ++)
		{
			swap(arr,i, idx);
			Perm(arr,left+arr[idx],right, idx + 1);
			Perm(arr, left, right+arr[idx] , idx+1);
			swap(arr,i, idx);
			
		}
	}
	private static void swap(int[] arr, int i, int idx) {
		int t = arr[i];
		arr[i] = arr[idx];
		arr[idx] = t;
	}

}
