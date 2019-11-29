import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Sol_1436_BJ {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String line = "666";
		if(N > 1)
		{
			System.out.println((N-1) + line);
		}else
		{
			System.out.println(line);
		}
	
	}
}
