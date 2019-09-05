import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Sol_3459_SW {
	public static long N;
	public static boolean who;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int a =1 ; a<=T ;a ++)
		{
			N = Long.parseLong(br.readLine());
			String ret = "Alice";
			 
            while (N > 10) {
                N = (N/2) + 1;
                N = (N/2) - 1;
                 
            }
 
            if ((N >= 6 && N <= 9) || N == 1) {
                ret = "Bob";
            }
 
            System.out.println("#" + a + " " + ret);
		}
		
	}
	
}
