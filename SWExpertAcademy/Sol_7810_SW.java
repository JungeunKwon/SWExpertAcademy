import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Sol_7810_SW{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int a = 1; a<=T ;a++)
		{
			int N = Integer.parseInt(br.readLine());
			int count[] = new int[1000001];
			StringTokenizer st = new StringTokenizer(br.readLine());
			int inputmax = 0, resultmax = 0;
			for(int i = 0; i < N; i ++)
			{
				int temp = Integer.parseInt(st.nextToken());
				count[temp] ++;
				if(temp > inputmax)
				{
					inputmax = temp;
				}
			}
			int sum = 0;
			for(int i = inputmax ; i > 0; i--)
			{
				sum += count[i];
				if(sum >= i)
				{
					resultmax = i;
					break;
					
				}
			}
			System.out.println("#" + a + " " + resultmax);
		}
	}
}
