import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Sol_15686_BJ {
	public static int arr[][];
	public static List<Info> list;
	public static Info numlist[];
	public static int N;
	public static int M;
	public static int min;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList<>();
		arr = new int[N][N];
		numlist = new Info[M];
		min = Integer.MAX_VALUE;
		for(int i = 0; i < N ; i++)
		{
			 st= new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j ++)
			{
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 2)
				{
					list.add(new Info(i, j));
				}
					
			}
		}
		comb(list, numlist, list.size(), M);
		System.out.println(min);
	}
	private static void comb(List<Info> list, Info[] numlist, int chickcount, int m) {
		if(m == 0)
		{
			int sums = 0;
			for(int i = 0; i < N ; i ++)
			{
				for(int j = 0; j < N; j ++)
				{
					if(arr[i][j] == 1)
					{
						int innermin = Integer.MAX_VALUE;
						for(int k = 0; k < numlist.length; k++)
						{
							int tx = Math.abs(numlist[k].i - i);
							int ty = Math.abs(numlist[k].j - j);
							int result = tx + ty;
							if(innermin > result)
								innermin = result;
							
						}
						sums += innermin;
						if(sums > min)
							return;
					}
				}
			}
			if(sums < min)
				min = sums;
			return;
		}
		else if(chickcount < m)
			return;
		numlist[m - 1] = list.get(chickcount - 1);
		comb(list, numlist, chickcount - 1, m - 1);
		comb(list, numlist, chickcount - 1, m);
		
	}
	
	public static class Info{
		int i;
		int j;
		Info(int i , int j)
		{
			this.i = i;
			this.j = j;
		}
	}
}
