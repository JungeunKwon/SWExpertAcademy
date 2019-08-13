import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Sol_2667 {

	static int count;
	static int dx[] = {1,-1,0,0}; //j
	static int dy[] = {0,0,-1,1}; //i
	static int N;
	static int innercount;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//int T = sc.nextInt();
		//for(int a = 1; a <=T; a ++)
		{
			N = sc.nextInt();
			int arr[][] = new int[N][N];
			//int num = sc.nextInt();
			ArrayList<Integer> list = new ArrayList<Integer>();
			count = 0;
			for(int  i = 0;  i < N; i++)
			{
				String temp = sc.next();
				for(int j =0; j < N; j++)
				{
					arr[i][j] = Integer.parseInt(Character.toString(temp.charAt(j)));
				}
			}
			for(int i = 0 ; i < N; i ++)
			{
				for(int j = 0 ; j  < N; j++)
				{
					if(arr[i][j] == 1)
					{
						innercount = 0;
						dfs(arr, i,j);
						list.add(innercount);
						count ++;
					}
				}
			}
			System.out.println(count);
			list.sort(new Comparator<Integer>() {

				@Override
				public int compare(Integer o1,Integer o2) {
					// TODO Auto-generated method stub
					return o1 - o2;
				}
				
			});
			
			for(int i = 0 ;  i < list.size(); i++)
			{
				System.out.println(list.get(i));
			}
		}
	}
	private static void dfs(int[][] arr, int y, int x) {
		int tx = 0 , ty = 0;
		arr[y][x] = 0;
		innercount++;
		for(int i = 0;  i < 4; i++)
		{
			tx = x + dx[i];
			ty = y + dy[i];
			if(tx < 0 || ty < 0 || ty >= N || tx >= N)
				continue;

			 if(arr[ty][tx] == 1) 
				 dfs(arr,ty,tx);
		}
		
		
	}

}
