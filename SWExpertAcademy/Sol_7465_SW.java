import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Sol_7465 {
	public static ArrayList <Integer> eachlist[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int a= 1 ; a <= T; a++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			eachlist = new ArrayList[N + 1];
			boolean visited[] = new boolean[N + 1];
			for(int i = 0; i <= N; i ++ )
			{
				eachlist[i] = new ArrayList<>();
			}
			for(int i = 0; i < M; i++)
			{
				 st = new StringTokenizer(br.readLine(), " ");
				 int first = Integer.parseInt(st.nextToken());
				 int second = Integer.parseInt(st.nextToken());
				 eachlist[first].add(second);
				 eachlist[second].add(first);
			}
			int count = 0;
			visited[0] = true;
			for(int i = 1; i <= N; i ++)
			{
				if(!visited[i])
				{
					//visited[i] = true;
					find(eachlist[i],visited);
					count ++;
				}
			}
			
			System.out.println("#" + a+ " " +  count);
		}
	}

	private static void find(ArrayList<Integer> arrayList, boolean[] visited) {
	

		for(int i = 0; i < arrayList.size(); i++)
		{
			int temp = arrayList.get(i);
			if(visited[temp]) continue;
			visited[temp] = true;
			find(eachlist[temp], visited);
		}
		
	}
	

}
