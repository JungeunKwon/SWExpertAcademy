import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Sol_1158 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 1 ; i <= N; i++)
		{
			list.add(i);
		}
		System.out.print("<");
		while(list.size() > 0)
		{
			int j = 0;
			for(int i = 0; i < M -1; i ++)
			{
				int temp = list.get(j);
				list.remove(j);
				list.add(temp);
			}
			System.out.print(list.get(j));
			list.remove(j);
			if(list.size() > 0)
			{
				System.out.print(", ");
			}
		}
		System.out.print(">");
	}

}
