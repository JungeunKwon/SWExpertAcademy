import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Sol_8983_BJ {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int position[] = new int[M];
		st =new StringTokenizer(br.readLine());
		int max = 0;
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < M; i ++)
		{
			int temp = Integer.parseInt(st.nextToken());
			position[i] = temp;
			if(temp> max)
			{
				max = temp;
			}
			if(temp< min)
			{
				min = temp;
			}
		}
		Arrays.sort(position);
		ArrayList<Info> list = new ArrayList<>();
		for(int i = 0; i < N; i ++)
		{
			st =new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			if(y > L) continue;
			if(x > max + L) continue;
			if(x < min - L) continue;
			list.add(new Info(x, y));
		}
		Collections.sort(list);
		int count = 0;
		int j =0;
		for(int i = 0; i < list.size(); i ++)
		{
			
			while(j < M - 1&& position[j] < list.get(i).x) j++;
			if(j == M) break;
			int dis = Math.abs(position[j] - list.get(i).x ) + list.get(i).y;
			if(dis <= L) {
				count ++;
				continue;
			}
			if(j > 0)
			{
				dis = Math.abs(position[j - 1] - list.get(i).x ) + list.get(i).y;
				if(dis <= L) {
					count ++;
					continue;
				}
			}
		}
		System.out.println(count);
		
	}
	public static class Info implements Comparable<Info>{
		int x;
		int y;
		Info(int x, int y)
		{
			this.x = x;
			this.y = y;
		}
		@Override
		public int compareTo(Info o) {
			return this.x - o.x;
		}
	}
}
