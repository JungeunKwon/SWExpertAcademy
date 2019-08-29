import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

import jdk.nashorn.internal.runtime.ECMAErrors;
import sun.util.locale.StringTokenIterator;

public class Sol_7576 {
	public static int M;
	public static int N;
	public static int dx[] = {0,0,-1,1};
	public  static int dy[] = {1,-1,0,0};
	public static int daycount;
	public static Queue<Info> q;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());//sc.nextInt();
		N = Integer.parseInt(st.nextToken()); //sc.nextInt();
		int arr[][] = new int[N][M];
		q = new LinkedList<Info>();
		for(int i = 0 ; i < N; i ++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j ++)
			{
				arr[i][j] = Integer.parseInt(st.nextToken());// sc.nextInt();
				if(arr[i][j] == 1)
				{
					Info in = new Info(i,j);
					q.offer(in);
				}
			}
		}
		bfs(arr);
		int zerocount = 0;
		for(int i = 0 ; i < N; i ++)
		{
			for(int j = 0; j < M; j ++)
			{
				if(arr[i][j] == 0)
				{
					zerocount ++;
				}
			}
		}	
		if(zerocount > 0 )
		{
			System.out.println(-1);
		}else
			System.out.println(daycount - 1);
		q.clear();
	}
	static class Info{
		int i;
		int j;
		Info(int i, int j){
			this.i = i;
			this.j = j;
	
		}
	}
	private static void bfs(int[][] arr) {
		daycount = 0;
		while(!q.isEmpty())
		{
			int size = q.size();
			for(int i = 0;  i < size ; i++)
			{
				Info temp = q.poll();
				int tx = 0, ty = 0;
				for(int j = 0;  j <4 ; j ++)
				{
					tx = temp.j + dx[j];
					ty = temp.i + dy[j];
					if(tx <0 || ty < 0 || tx >= M || ty>=N)
						continue;
					if(arr[ty][tx] == 0)
					{
						arr[ty][tx] = 1;
						Info newInfo = new Info(ty, tx);
						q.offer(newInfo);
					}
				}
			}
			daycount ++;
		}
		
		
	}

}
