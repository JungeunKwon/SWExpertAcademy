import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Sol_17472_BJ {
	public static Queue<Info> q;
	public static List<SumInfo> list;
	public static int dx[] = {1,0,-1,0};
	public static int dy[] = {0,1,0,-1};
	public static int N;
	public static int M;
	public static boolean visited[][];
	public static int arr[][];
	public static int sumnum;
	public static TreeSet<Edge> set;
	public static int nodecount;
	public static int parent[];
	public static int result;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		q = new LinkedList<>();
		list = new ArrayList<>();
		sumnum = 0;
		set = new TreeSet<>();
		nodecount = 0;
		for(int i = 0; i < N ; i ++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j ++)
			{
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		result = 0;
		visited = new boolean[N][M];
		for(int i = 0; i < N; i ++)
		{
			for(int j = 0; j < M; j++)
			{
				if(arr[i][j] == 1 && !visited[i][j])
				{
					visited[i][j] = true;
					sumnum++;
					arr[i][j] = sumnum;
					q.offer(new Info(i, j));
					makesum();
					
				}
			}
		}
		parent = new int[sumnum + 1];
		for(int i = 1; i <= sumnum; i++)
		{
			parent[i] = i;
		}
		for(int i = 0; i <list.size(); i ++)
		{
			makeEdge(list.get(i));
		}
		for(Edge e : set)
		{
			unionSet(e);
			System.out.println(e);
			if(nodecount == sumnum - 1)
			{
				break;
			}
		}
		for(int i = 0; i < N; i++)
		{
			System.out.println(Arrays.toString(arr[i]));
		}
		if(nodecount != sumnum - 1)
		{
			System.out.println(-1);
		}else
		{
			System.out.println(result);
		}
		
	}

	private static void unionSet(Edge e) {
		int x = findSet(e.start);
		int y = findSet(e.end);
		if(x!=y)
		{
			parent[y] = x;
			result += e.weight;
			nodecount++;
			System.out.println("START : " + e.start);
		}
	}

	private static int findSet(int start) {
		if(parent[start] == start)
			return start;
		else
		{
			int p = findSet(parent[start]);
			parent[start] = p;
			return p;
		}
	}

	private static void makeEdge(SumInfo sumInfo) {
		int x = sumInfo.j, y = sumInfo.i;
		int num = sumInfo.sumnumber;
		int tx = 0, ty = 0;
		for(int i = 0; i < 4;  i++)
		{
			tx = x + dx[i];
			ty = y + dy[i];
			int count = 1;
			while(tx >= 0 && ty >= 0 && tx<M && ty < N) 
			{
				if(arr[ty][tx] != num && arr[ty][tx] != 0) 
				{
					if(count >= 3)
					{
						set.add(new Edge(num, arr[ty][tx], count));
						break;
					}
					else {
						break;
					}
				}
			
				tx = tx + dx[i];
				ty = ty + dy[i];
				count ++;
			}
		}
	}

	private static void makesum() {
		int tx  = 0 , ty = 0;
		while(!q.isEmpty())
		{
			Info temp = q.poll();
			for(int i = 0; i < 4; i ++)
			{
				tx = temp.j + dx[i];
				ty = temp.i + dy[i];
				if(tx < 0 || ty < 0 || tx>=M || ty >=N)continue;
				if(visited[ty][tx]) continue;
				if(arr[ty][tx] == 1)
				{
					arr[ty][tx] = sumnum;
					visited[ty][tx] = true;
					q.offer(new Info(ty, tx));
					list.add(new SumInfo(ty, tx, sumnum));
				}
			}
		}
	
	}
	public static class Edge implements Comparable<Edge>{
		int start;
		int end;
		int weight;
		
		public Edge(int start, int end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight > o.weight ? 1 : -1;
		}

		@Override
		public String toString() {
			return "Edge [start=" + start + ", end=" + end + ", weight=" + weight + "]";
		}
		
		
	}
	public static class SumInfo {
		int i;
		int j;
		int sumnumber;
		SumInfo(int i, int j,int sumnumber)
		{
			this.i = i;
			this.j = j;
			this.sumnumber = sumnumber;
		}
		
		
	}
	public static class Info{
		int i;
		int j;
		Info(int i, int j)
		{
			this.i = i;
			this.j = j;
		}
	}
}
