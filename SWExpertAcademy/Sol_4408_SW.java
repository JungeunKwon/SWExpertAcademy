import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Sol_4408_SW {

	public static void main(String[] args) throws Exception{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int T = Integer.parseInt(br.readLine().trim());
			for (int a = 1; a <= T; a++) {
				int N = Integer.parseInt(br.readLine().trim());
				LinkedList<Info> list = new LinkedList<>();
				StringTokenizer st;
				for (int i = 0; i < N; i++) {
					st = new StringTokenizer(br.readLine());
					int fi = Integer.parseInt(st.nextToken());
					int se = Integer.parseInt(st.nextToken());
					if(fi%2 == 0) fi -= 1;
					if(se%2 == 0) se -= 1;
					if(fi > se)
					{
						list.add(new Info(se, fi));
					}else
					{
						list.add(new Info(fi, se));
					}
					
				}
				Collections.sort(list);

				int count = 0;
				while (!list.isEmpty()) {
					Info temp = list.get(0);
					list.remove(temp);
					for (int i = 0; i < list.size(); i++) {
						Info temp2 = list.get(i);
						if(temp2.first <= temp.last)
						{
							continue;
						}	
						temp = temp2;
						list.remove(temp2);
						i--;
						
					}
					count ++;
				}
				System.out.println("#" + a + " " + count);
				list.clear();
			}
	}

	public static class Info implements Comparable<Info> {
		int first;
		int last;

		Info(int first, int last) {
			this.first = first;
			this.last = last;
		}

		@Override
		public String toString() {
			return "Info [first=" + first + ", last=" + last + "]";
		}

		@Override
		public int compareTo(Info o) {
			return this.first - o.first;
		}
	}
}
