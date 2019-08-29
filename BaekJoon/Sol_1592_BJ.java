import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol_1592_BJ {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int arr[] = new int[N + 1];
		int count = 0;
		int nowpos = 1 + L;
		arr[1 + L] ++;
		while(true)
		{
			if(arr[nowpos] >= M)
				break;
			if(arr[nowpos] % 2 == 0)
			{
				nowpos = nowpos - L;
				if(nowpos < 1)
				{
					nowpos = nowpos + N;
				}
				arr[nowpos] ++;
				count ++;
			}else
			{
				nowpos = nowpos + L;
				if(nowpos > N)
				{
					nowpos = nowpos - N;
				}
				arr[nowpos] ++;
				count ++;
			}
		}
		System.out.println(count);
	}

}
