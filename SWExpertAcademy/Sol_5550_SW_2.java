import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Sol_5550_SW_2 {
	public static char gaguri[] = { 'c', 'r', 'o', 'a', 'k' };
	public static int count;
	public static int max;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int a = 1; a <= T; a++) {
			count = 0;
			String line = br.readLine();
			if (line.length() % 5 != 0)
				System.out.println("#" + a + " " + "-1");
			else {
				max = 0;
				Map<Character, Integer> map = new HashMap<Character, Integer>();
				map.put('c', 0);
				map.put('r', 1);
				map.put('o', 2);
				map.put('a', 3);
				map.put('k', 4);
				boolean flag  = false;
				int[] arraycount = new int[5];
				aa: for (int i = 0; i < line.length(); i++) {
					char c = line.charAt(i);
					switch (c) {
					case 'c':
						arraycount[0]++;
						count++;
						if (max < count)
							max = count;
						break;
					case 'r':
					case 'o':
					case 'a':
					case 'k':
						if (arraycount[map.get(c) - 1] > 0) {
							arraycount[map.get(c) - 1]--;
							if (c == 'k') {
								count--;
							} else {
								arraycount[map.get(c)]++;
							}
						} else {
							System.out.println("#" + a + " " + "-1");
							flag = true;
							break aa;
						}
						break;

					}
				}
				if(!flag)
				{
					int j = 0;
					for(int i = 0; i < arraycount.length; i++)
					{
						if(arraycount[i] != 0)
						{
							j++;
						}
					}
					if(j > 0)
					{
						System.out.println("#" + a + " " + -1);
					}
					else
					{
						System.out.println("#" + a + " " + max);
					}
				}

			}

		}
	}
}
