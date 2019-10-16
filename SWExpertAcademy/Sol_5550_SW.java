import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Sol_5550_SW {
	public static char gaguri[] = {'c','r','o','a','k'};
	public static int count;
	public static int max;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int a =1 ; a<=T ;a ++)
		{
			count  = 0; 
			String line = br.readLine();
			if(line.length() % 5 != 0) System.out.println("#" + a + " "+ "-1");
			else
			{
				max = line.length()/5;
				LinkedList<Character> list = new LinkedList<>();
				for(int i = 0; i <  line.length(); i ++)
				{
					list.add(line.charAt(i));
				}
				int pos = 0;
				int i = 0;
				boolean flag = false;
				if(list.getFirst() != 'c')
				{	System.out.println("#" + a + " "+ "-1");
				
				}else
				{
					list.addFirst('c');
					
					while(!list.isEmpty())
					{
						
						if(pos == gaguri.length)
						{	
							if(!flag)
							{
								count ++;
								
							}else
							{
								flag = false;
							}
							pos = 0;
							if(list.peekFirst() == 'c') flag = true;
						}
						char c = list.peekFirst();
						
						if(c == gaguri[pos])
						{
							list.removeFirst();
							pos ++;
							
						}else
						{
							list.addLast(c);
							list.removeFirst();
					
						}
						
						
					}

					System.out.println("#" + a + " " + count  );
				}
				
				
			
			}		
			
		}
	}

}
