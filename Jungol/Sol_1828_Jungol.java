import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class Sol_1828_Jungol {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int Num = Integer.parseInt(br.readLine());
		StringTokenizer st;
		ArrayList<Info> list = new ArrayList<>();
		int count = 0;
		int max = Integer.MAX_VALUE;
		for(int i = 0; i < Num; i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			if(start > end)
			{
				list.add(new Info(end, start));
			}else
			{
				list.add(new Info(start, end));
			}
			
		}
		Collections.sort(list);
		while(!list.isEmpty())
		{
			Info temp = list.get(0);
			max = temp.end;
			list.remove(temp);
			for(int i = 0; i < list.size(); i++)
			{
				Info temp2 = list.get(i);
				if(temp2.start > max) break;
				temp = temp2;
				if(max > temp.end) max = temp.end;
				list.remove(i);
				i--;
			}
			//list.remove(0);
			count++;
		}
		System.out.println(count);
		
	}
	public static class Info implements Comparable<Info>
	{
		int start;
		int end;
		Info(int start, int end)
		{
			this.start = start;
			this.end = end;
		}
		@Override
		public int compareTo(Info o) {
			// TODO Auto-generated method stub
			return this.start - o.start;
		}
	}
}
