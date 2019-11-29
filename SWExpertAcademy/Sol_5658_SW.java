import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Sol_5658_SW {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int a= 1; a<=T ;a++)
		{
			StringTokenizer st =new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			Set<Integer> set = new TreeSet<>();
			String line = br.readLine();
			
			int nanum = N/4;
			for(int i = 0; i < nanum; i ++)
			{
				for(int j = 0; j < N ; j += nanum)
				{
					set.add(Integer.parseInt(line.substring(j, j+nanum), 16));
				}
				line += line.charAt(0);
				line = line.substring(1, line.length());
			}	
			Integer[] temp = set.toArray(new Integer[0]);
			System.out.print("#" + a + " " + temp[temp.length-M]);
			
		
		}
	}

}
