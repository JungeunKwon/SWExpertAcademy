import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Sol_2007 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int a= 1; a <=T; a++)
		{
			String line = br.readLine();
			int N = 10;
			String temp = line.substring(0,N);
			String result = "";
			char c = temp.charAt(0);
			for(int i = 1; i < N; i ++)
			{
				if(temp.charAt(i) == c)
				{
					String subtemp = temp.substring(0,i);
					int count = 1;
					for(int j = 1; j < subtemp.length(); j++)
					{
						if(subtemp.charAt(j) == line.charAt(j+i))
						{
							count ++;
						}else
						{
							break;
						}
					}
					if(count == subtemp.length())
					{
						result = line.substring(0,i);
						break;
					}
				}
				
			}
			
			System.out.println("#"+ a+ " " + result.length());
		}
	}

}
