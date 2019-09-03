import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Sol_2851_BJ {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int arr[] = new int[10];
		for(int i = 0; i < 10; i ++)
		{
			arr[i] = Integer.parseInt(br.readLine());
		}
		int sum = 0;
		for(int i = 0; i < 10 ;i ++)
		{
			sum += arr[i];
			if(sum >= 100)
			{
				int temp = sum - arr[i];
				if(Math.abs(100-temp) >= Math.abs(100 - sum))
				{
					
				}else
				{
					sum = temp;
				}
				break;
			}
		}
		System.out.println(sum);
	}

}
