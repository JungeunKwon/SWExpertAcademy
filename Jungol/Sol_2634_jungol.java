import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Sol_2634_jungol {
	public static LinkedList<Integer> polist;
	public static LinkedList<Info> animallist;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		polist = new LinkedList<>();
		animallist = new LinkedList<>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M ; i++)
		{
			polist.add(Integer.parseInt(st.nextToken()));
		}
		polist.sort(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1-o2;
			}
		});
		for(int i = 0; i < N; i ++)
		{
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			if(y > L)continue;
			animallist.add(new Info(x, y));
		}
		animallist.sort(new Comparator<Info>() {

			@Override
			public int compare(Info o1, Info o2) {
				// TODO Auto-generated method stub
				return o1.x - o2.x;
			}
		});
		int count = 0;
		
		while(!polist.isEmpty() && !animallist.isEmpty())
		{
			Info temp = animallist.getFirst();
			int x = polist.getFirst();
			int dis = Math.abs(temp.x - x) + temp.y;
		
			if(dis <=L)
			{
				animallist.removeFirst();
				count ++;
				
				continue;
			}else
			{
				if(temp.x > (x+L))
				{
					polist.removeFirst();
					continue;
				}
				if(polist.size()>1)
				{
					int nextx = polist.get(1);
					int nextdis = Math.abs(temp.x - nextx) + temp.y;
					if(nextdis<=L)
					{
						animallist.removeFirst();
						count++;
						
						continue;
					}else
					{
						animallist.removeFirst();
						continue;
					}
				}
							
			}
		
			
		}
		System.out.println(count);
		
	}
	public static class Info{
		int x;
		int y;
		Info(int x, int y)
		{
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return "Info [x=" + x + ", y=" + y + "]";
		}
		
	}
}
