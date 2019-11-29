import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol_1952_SW {
	public static int price[];
	public static int min;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int a = 1; a<=T ;a ++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			price= new int[4];
			for(int i = 0; i < 4; i ++)
			{
				price[i] = Integer.parseInt(st.nextToken());
			}
			int month[] = new int[12];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 12; i ++)
			{
				month[i] = Integer.parseInt(st.nextToken());
				
			}
			min = price[3];
			find(month, 0,0,0,0,0);
			System.out.println("#" + a + " "   + min);
		}
	}
	private static void find(int[] month, int day, int omonth, int tmonth, int year, int idx) {
		int count = day * price[0] + omonth*price[1] + tmonth*price[2];
		if(count > min) return;
		if(idx >= 12)
		{
			if(min > count)
			{
				min = count;
			}
			return;
		}
		find(month, day+month[idx], omonth, tmonth, year, idx + 1);
		find(month, day, omonth+1, tmonth, year, idx + 1);
		find(month, day, omonth, tmonth+1, year, idx + 3);
	}

}
