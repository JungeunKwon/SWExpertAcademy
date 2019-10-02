

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Sol_1256_SW {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int a =1; a<=T; a++)
		{
			int N = Integer.parseInt(br.readLine());
			String line = br.readLine();
			int length = line.length();
			String[] sub = new String[length];
			for(int i = 0; i < length ; i ++)
			{
				sub[i] = line.substring(i, length);

			}
			Arrays.sort(sub);
	
			System.out.println("#" + a + " " + sub[N - 1]);
		}
	}
}
