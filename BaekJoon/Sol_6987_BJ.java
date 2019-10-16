import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol_6987_BJ {
	public static int arr[][];
	public static int temp[][];
	public static boolean flag;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int a = 0; a < 4; a++)
		{
			flag = false;
			arr = new int[6][3];
			temp = new int[6][3];
			StringTokenizer st=  new StringTokenizer(br.readLine());
			int count = 0;
			for(int i = 0; i < 6; i ++)
			{
				for(int j = 0; j < 3; j ++)
				{
					arr[i][j] = Integer.parseInt(st.nextToken());
					count += arr[i][j];
				}
			}
			if(count == 30)
			{
				bfs(0,1, temp);
				if(!flag)System.out.print("0 ");
				else System.out.print("1 ");
			}else {
				System.out.print("0 ");
			}
			
			
 		}
		
		

	}
	private static void bfs(int firstteam, int secondteam, int[][] tempscore) {
		if(firstteam > 5)
		{
			
			flag = true;
			return;
		}
		if(secondteam > 5)
		{
			bfs(firstteam+1, firstteam+2,tempscore);
			return;
			
		}
		tempscore[firstteam][0] ++;
		tempscore[secondteam][2] ++;
		if(tempscore[firstteam][0] <= arr[firstteam][0] && tempscore[secondteam][2] <= arr[secondteam][2])
		{
			bfs(firstteam, secondteam + 1, tempscore);
			
		}
		tempscore[firstteam][0] --;
		tempscore[secondteam][2] --;
		tempscore[firstteam][2] ++;
		tempscore[secondteam][0] ++;
		if(tempscore[firstteam][2] <= arr[firstteam][2] && tempscore[secondteam][0] <= arr[secondteam][0])
		{
			bfs(firstteam, secondteam + 1, tempscore);
		}
		tempscore[firstteam][2] --;
		tempscore[secondteam][0] --;
		tempscore[firstteam][1] ++;
		tempscore[secondteam][1] ++;
		if(tempscore[firstteam][1] <= arr[firstteam][1] && tempscore[secondteam][1] <= arr[secondteam][1])
		{
			bfs(firstteam, secondteam + 1, tempscore);
		}
		tempscore[firstteam][1] --;
		tempscore[secondteam][1] --;
		
	}

}
