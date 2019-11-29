import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Sol_3812_SW {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for(int a = 1; a <=T ; a++)
		{
			List<Info> list = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			long X = Long.parseLong(st.nextToken());
			long Y = Long.parseLong(st.nextToken());
			long Z = Long.parseLong(st.nextToken());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int count[] = new int[N+1];
			long kkresult = X * Y * Z;
			if(N == 1)
			{
				System.out.println(X + " " + Y +  " " + Z);
				System.out.println("#" + a + " " + (long)kkresult);
			}else
			{
				for(int i = 0; i <X; i ++)
				{
					for(int j = 0; j < Y; j ++)
					{
						for(int k = 0; k < Z; k++)
						{
							int tx = Math.abs(i - A);
							int ty = Math.abs(j - B);
							int tz = Math.abs(k - C);
							int result = (tx + ty + tz)% N;
							count[result] ++;
						}
					}
				}
				
				System.out.print("#" + a + " ");
				for(int i = 0; i < N ;i ++)
				{
					System.out.print(count[i] + " ");
				}System.out.println();
			
			}
			
		}

	}
	public static class Info
	{
		int x;
		int y;
		int z;
		Info(int x, int y, int z)
		{
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
}
