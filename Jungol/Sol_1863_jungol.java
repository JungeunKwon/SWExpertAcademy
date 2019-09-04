import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol_1863_jungol {
	public static int parent[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		parent = new int[N+1];
		for(int i = 1; i <= N ; i ++)
		{
			parent[i] = i;
		}
		for(int i = 0; i <M; i++)
		{
			st =new StringTokenizer(br.readLine());
			int fi = Integer.parseInt(st.nextToken());
			int se = Integer.parseInt(st.nextToken());
			unionSet(fi,se);
		}
		int count = 0;
		for(int i = 1; i <= N ; i ++)
		{
			if(parent[i] == i) count ++;
		}
		System.out.println(count);
	}

	private static void unionSet(int fi, int se) {
		fi = findSet(fi);
		se = findSet(se);
		if(fi!=se)
		{
			parent[se] = fi;
		}
	}

	private static int findSet(int fi) {
		if(fi == parent[fi])
		{
			return fi;
		}else {
			int p = findSet(parent[fi]);
			parent[fi] = p;
			return findSet(p);
		}
	}

}
