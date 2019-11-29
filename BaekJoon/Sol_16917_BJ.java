import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol_16917_BJ {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken()) * 2; // 반반이니까 한마리가 될려면
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		int XA = X * A; // 양념 갯수만큼 가격
		int YB = Y * B; // 후라이드 갯수만큼 가격
		int XC = 0;
		int min = XA + YB; // 일단 각각 샀을 때
		if (X > Y) // 양념갯수가 더 많으면 반반은 양념갯수만큼 사야하니까
		{
			XC = X * C;
			if (XA > XC) // 양념갯수에 맞춰 반반을 산가격이 양념으로 샀을때보다 더 싸면
			{
				if (min > XC)
					min = XC;
			}
		} else {
			XC = Y * C;
			if (YB > XC) {
				if (min > XC)
					min = XC;
			}
		}
		int temp = Math.abs(X - Y); //양념이랑 후라이드 갯수 차이
		int result = 0;
		if (X > Y) { //양념이 더 많으면 후라이드만큼 반반을 사고 양념을 남은갯수만
			result = Y * C + temp * A;
		} else {
			result = X * C + temp * B;
		}
		if (min > result)
			min = result;
		System.out.println(min);
	}

}
