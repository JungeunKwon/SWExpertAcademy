import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Sol_9095_BJ {
	public static int memo[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		memo = new int[12];
		memo[0] = 0;
		memo[1] = 1;
		memo[2] = 1;
		memo[3] = 1;
		for(int a = 1; a <= T; a++)
		{
			int input  = Integer.parseInt(br.readLine());
			
		}
	}
	public static int findcal(int n)
	{
		for(int i  = 0; i < n ; i ++)
		{
			if(memo[i] != 0)
			{
				
			}
		}
	}
	private static int[] find(int i) {
		// TODO Auto-generated method stub
		return null;
	}

}
