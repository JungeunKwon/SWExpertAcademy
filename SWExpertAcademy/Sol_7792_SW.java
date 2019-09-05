import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Sol_7792_SW {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int a =1; a<=T; a++)
		{
			int N = Integer.parseInt(br.readLine());
			String[] lines = new String[N];
			int [] counts = new int[N];
			for(int i = 0; i < N ; i ++)
			{
				lines[i] = br.readLine();
			}
			for(int i = 0; i < N; i ++)
			{
				String temp = "";
				String line = lines[i];
				line = line.replaceAll(" ", "");
				for(int j = 0; j < line.length(); j++)
				{
					if(!temp.contains(line.charAt(j) + ""))
					{
						temp = temp + line.charAt(j);
					}
				}
				counts[i] = temp.length();
			}
			int max = 0;
			int po = 0;
			for(int i = 0; i < N ; i++)
			{
				if(counts[i] > max)
				{
					max = counts[i];
					po = i;
				}else if(counts[i] == max)
				{
					if(lines[po].compareTo(lines[i]) > 0)
					{
						po = i;
					}
				}
			}
			System.out.println("#" + a + " " + lines[po]);
		}
	}

	
}
