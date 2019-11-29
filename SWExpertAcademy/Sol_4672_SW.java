import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeSet;

public class Sol_4672_SW {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int a = 1; a<=T ; a++)
		{
			String line = br.readLine();
			char[] arr = line.toCharArray();
			Arrays.sort(arr);
			line = String.valueOf(arr);
			int count = 0;
			for(int i = 0; i < line.length(); i ++)
			{
				for(int j = i+1; j <= line.length(); j++)
				{
					if(isPalin(line.substring(i,j)))
					{
						count ++;
					}
				}
			}
			System.out.println("#"  + a + " " + count );
		}

	}

	private static boolean isPalin(String substring) {
		char[] temparr = substring.toCharArray();
		int size = substring.length();
		for(int i = 0; i < size/2; i ++)
		{
			if(temparr[i] != temparr[size - i-1])
				return false;
		}
		return true;
	}


	
}
