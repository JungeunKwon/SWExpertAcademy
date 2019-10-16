

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class Sol_7701_SW {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int a =1 ; a<=T ; a++)
		{
			StringBuilder sb= new StringBuilder();
			int N = Integer.parseInt(br.readLine());
			TreeSet<String> tree = new TreeSet<>(new Comparator<String>() {

				@Override
				public int compare(String o1, String o2) {
					if(o1.length() < o2.length())
					{
						return -1;
					}else if(o1.length() == o2.length())
					{
						return o1.compareTo(o2);
					}else
					{
						return 1;
					}
					//return 0;
				}
			});
			
			for(int i = 0; i < N ; i ++ )
			{
				tree.add(br.readLine());
			}
			
			System.out.println("#" + a + " " );
			Iterator<String> it = tree.iterator();
			while(it.hasNext())
			{
				sb.append(it.next()+"\n");
			}
			System.out.println(sb.toString());
			
		}

	}

}
