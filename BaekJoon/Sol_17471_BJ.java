import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


public class Sol_17471_BJ {
	public static int people[];
	public static int N;
	public static int arr[][];
	public static int area[];
	public static boolean[] flag, visited;
	public static int min;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		people = new int[N+1];
		area = new int[N+1];
		flag = new boolean[N+1];
		StringTokenizer st= new StringTokenizer(br.readLine());
		for(int i = 1; i <= N ; i ++)
		{
			people[i] = Integer.parseInt(st.nextToken());
			area[i] = i;
		}
		arr = new int[N+1][N+1];
		min = Integer.MAX_VALUE;
		for(int i = 1; i <= N; i ++)
		{
			st = new StringTokenizer(br.readLine());
			int connection = Integer.parseInt(st.nextToken());
			for(int j = 0; j < connection ; j ++)
			{
				int conn = Integer.parseInt(st.nextToken());
				arr[i][conn] = 1;
				arr[conn][i] = 1;
			}
		}
		
		PowerSet(area, 1, N);
		if(min == Integer.MAX_VALUE)
		{
			System.out.println(-1);
		}else
		{
			System.out.println(min);
		}
	
	}
	private static void PowerSet(int[] area, int idx, int length) {
		if(idx > length)
		{
			
			int cnt=0;
			visited = new boolean[N+1];
			for(int i=1; i<=length; i++) {
				if(!visited[i]) {
					isConnection(i);
					cnt++;
				}
			}
			if(cnt!=2) return;
			int firstcount=0;
			int secondcount =0;
			for(int i = 1; i<=length; i++)
			{
				if(flag[i])
					firstcount += people[i];
				else
					secondcount += people[i];
			}
			int result = Math.abs(firstcount - secondcount );
			if(min > result)
				min = result;
			return;
		}
		flag[idx] = true;
		PowerSet(area, idx + 1, length);
		flag[idx] = false;
		PowerSet(area, idx + 1, length);
		
	}
	private static void isConnection(int i) {
		Queue<Integer> q = new LinkedList<>();
		
		q.offer(i);
		visited[i] = true;
		while(!q.isEmpty()) {
			Integer hi = q.poll();
			for(int j=1; j<=N; j++) {
				if(visited[j]) continue;
				if(arr[hi][j]==1&&flag[hi]==flag[j]) {
					q.offer(j);
					visited[j]=true;
				}
			}
		}
	}

}
