import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol_10971_BJ {
	public static int N;
	public static int arr[][];
	public static int min;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		int permarr[];
		permarr = new int[N];
		for(int i = 0; i < N ; i ++)
		{
			permarr[i] = i;
		}
		StringTokenizer st;
		min = Integer.MAX_VALUE;
		for(int i =0; i <N; i ++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N ; j ++)
			{
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		Perm(permarr, 0, N);
		System.out.println(min);
	}

	private static void Perm(int[] permarr, int idx, int length) {
		if(idx >= length)
		{
			int result = 0;
			for(int i = 0; i < N - 1; i ++) {
				int t = arr[permarr[i]][permarr[i+1]];
				if(t==0)return;
				result += t;
				if(result > min) return;
			}
			int t = arr[permarr[N-1]][permarr[0]];
			if(t==0)return;
			result += t;
			if(min > result) min = result;
			return;
		}
		for(int i = idx; i < length; i ++)
		{
			swap(permarr, i, idx);
			Perm(permarr, idx + 1, length);
			swap(permarr, i, idx);
		}
	}

	private static void swap(int[] permarr, int i, int idx) {
		int t = permarr[i];
		permarr[i] = permarr[idx];
		permarr[idx] = t;
	}

}
