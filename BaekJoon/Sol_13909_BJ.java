import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Sol_13909_BJ {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int count = 0;
		for(int  i = 1; i * i <= N ; i ++)
		{
			count ++;
		}
		System.out.println(count);
		//1부터 열려져 있ㄴ느 창문 개수를 시물레이션 해보면 n 이 제곱근일때 수가 증가한다.
	}

}
