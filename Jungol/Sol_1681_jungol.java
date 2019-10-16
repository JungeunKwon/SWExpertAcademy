import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Sol_1681_jungol {
	public static int N;
	public static int arr[][];
	public static int min;
	public static int pos[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine().trim());
		arr = new int[N][N];
		StringTokenizer st;
		min = Integer.MAX_VALUE;
		pos = new int[N];
		for(int i = 0; i < N ; i ++)
		{
			st = new StringTokenizer(br.readLine());
			pos[i] = i;
			for(int j = 0; j < N ; j ++)
			{
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		perm(1);
	
		System.out.println(min);
	}
	
	private static void perm(int index) {
		
		if(index >= N)
		{
			int  count = 0;
			int result= 0;
			for(int i = 0; i < N - 1; i++)
			{
				result =  arr[pos[i]][pos[i+1]];
				if(result == 0 )return;
				count += result;
				if(count > min)return;
			}
			result = arr[pos[N-1]][0];
			if(result == 0) return;
			count += result;
			if(count < min) min = count;
			return;
		}
		for(int i = index; i < N ; i ++)
		{
			swap(i, index);
			perm(index + 1);
			swap(i, index);
		}
		
	}
	private static void swap(int i, int index) {
		int temp = pos[i];
		pos[i] = pos[index];
		pos[index] = temp;
		
	}

}
