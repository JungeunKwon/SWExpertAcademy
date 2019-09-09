import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Sol_16234_BJ {
	public static int dx[] = { 1, -1, 0, 0 };
	public static int dy[] = { 0, 0, -1, 1 };// 오 왼 위 아
	public static int N;
	public static int L;
	public static int R;
	public static boolean visited[][];
	public static Queue<Integer> q;
	public static ArrayList<Info> list;
	public static int sum;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		int arr[][] = new int[N][N];
		q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int count = 0;
		list = new ArrayList<>();
		list.add(new Info(0,0,0,0));
		while (list.size() > 0) {
			list.clear();
			visited = new boolean[N][N];		
			sum = 0;
			int innercount =0;
			for(int i = 0; i < N ; i ++)
			{
				for(int j = 0; j < N ; j ++)
				{
					if(!visited[i][j])
					{
						q.offer(i);
						q.offer(j);
						bfs(arr, innercount);
						innercount++;
					}
				}
			}
			if(list.size() < 1)
			{
				break;
			}
			int union[] = new int[innercount];
			for(int i = 0; i < innercount ; i ++)
			{
				int countcountry = 0;
				for(int j = 0; j <list.size(); j++)
				{
					if(list.get(j).unionnum == i)
					{
						countcountry ++;
						union[i] += list.get(j).people;
					}
				}
				if(countcountry > 0)
				{
					union[i] = union[i]/countcountry;
				}
			}
			for (int i = 0; i < list.size(); i++) {
				Info temp = list.get(i);
				arr[temp.i][temp.j] = union[temp.unionnum];
			}
			count ++;
		}
		System.out.println(count);
	}

	private static void bfs(int[][] arr,int num) {
		int tx = 0, ty = 0;
		while (!q.isEmpty()) {
			int tempi = q.poll();
			int tempj = q.poll();
			for (int i = 0; i < 4; i++) {
				tx = tempj + dx[i];
				ty = tempi + dy[i];
				if (tx < 0 || ty < 0 || tx >= N || ty >= N)
					continue;
				
					int first = arr[tempi][tempj];
					int second = arr[ty][tx];
					int result = Math.abs(first - second);
					if (result >= L && result <= R) {
						Info insert = new Info(ty, tx, arr[ty][tx],num);
						if (!list.contains(insert)&&(!visited[ty][tx])) {
							sum += insert.people;
							list.add(insert);
						}
					if (!visited[ty][tx]) {
						q.offer(ty);
						q.offer(tx);
						visited[ty][tx] = true;
					}

				}

			}
		}
	}

	public static class Info {
		int i;
		int j;
		int people;
		int unionnum;


		@Override
		public String toString() {
			return "Info [i=" + i + ", j=" + j + ", people=" + people + ", unionnum=" + unionnum + "]";
		}


		Info(int i, int j, int people,int unionnum) {
			this.i = i;
			this.j = j;
			this.people = people;
			this.unionnum = unionnum;
		}
	}
}
