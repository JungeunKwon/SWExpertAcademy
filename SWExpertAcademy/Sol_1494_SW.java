import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Sol_1494_SW {
	public static long min;
	public static boolean flags[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int a= 1; a<=T; a++)
		{
			ArrayList<Info> list = new ArrayList<>();
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st;
			min = Long.MAX_VALUE;
			flags = new boolean[N];
			for(int i = 0; i < N; i ++)
			{
				st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				list.add(new Info(x, y));
			}
			perm(list, 0,0);
			System.out.println("#" + a + " " + min);
		}

	}
	private static void perm(ArrayList<Info> list, int idx, int count) {
		if(count == list.size()/2)
		{
			int startX =0, startY=0,endX =0, endY =0;
			for(int i = 0;  i < list.size(); i ++)
			{
				if(flags[i])
				{
					startX += list.get(i).x;
					startY += list.get(i).y;
				}else
				{
					endX += list.get(i).x;
					endY += list.get(i).y;
				}
			}
			long result = (long) (Math.pow(startX-endX, 2) + Math.pow(startY-endY, 2));
			if(result < min)
			{
				min = result;
			}
			return;
		}
		for(int i = idx; i <list.size(); i ++)
		{
			flags[i] = true;
			perm(list, i + 1, count + 1);
			flags[i] = false;
		}
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
