import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Sol_4366_SW {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int a =1; a<=T ;a ++)
		{
			char[] binary = br.readLine().toCharArray();
			char[] third = br.readLine().toCharArray();
			int temp = 0;
			aa : for(int i = 0; i < binary.length; i++)
			{
				char c = binary[i];
				if(c == '0')
				{
					binary[i] = '1';
				}
				else
				{
					binary[i] = '0';
				}
				temp = Integer.parseInt(new String(binary),2);
				for(int j = 0; j < third.length; j++)
				{
					char t = third[j];
					int temp2;
					if(t == '2')
					{
						third[j] = '0';
						temp2 = Integer.parseInt(new String(third),3);
						if(temp2 == temp)
							break aa;
						third[j] = '1';
						temp2 = Integer.parseInt(new String(third),3);
						if(temp2 == temp)
							break aa;
					}else if(t == '1')
					{
						third[j] = '0';
						temp2 = Integer.parseInt(new String(third),3);
						if(temp2 == temp)
							break aa;
						third[j] = '2';
						temp2 = Integer.parseInt(new String(third),3);
						if(temp2 == temp)
							break aa;
					}else if(t =='0')
					{
						third[j] = '1';
						temp2 = Integer.parseInt(new String(third),3);
						if(temp2 == temp)
							break aa;
						third[j] = '2';
						temp2 = Integer.parseInt(new String(third),3);
						if(temp2 == temp)
							break aa;
					}
					third[j] = t;
				}
				binary[i] = c;
			}
			System.out.println("#" + a + " " + temp);
			
		}
		int[] a = {1,1,1,0};
		String b  = new String();
	
	}	

}
