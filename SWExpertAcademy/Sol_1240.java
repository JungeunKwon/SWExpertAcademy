import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Sol_1240 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<Integer> list;
		int T = Integer.parseInt(st.nextToken());
		for (int a = 1; a <= T; a++) {
			list = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			String arr = "";
			boolean find = false;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				String line = st.nextToken();
				if (line.contains("1") && !find) {
					aa: for (int j = line.length() - 1; j >=0; j--) {
						if ((line.charAt(j) - '0') == 1) {
							if (!find) {
								int l = j ;
								for (int k = 0; k < 56; k++) {
									arr = line.charAt(l) - '0' + arr;
									l--;
								}
								find = true;
								break aa;
							}
						}
					}
				}
			}
			int k = 0;
			for (int i = 0; i < 8; i++) {
				String line = "";
				for (int j = k; j < k + 7; j++) {
					line += arr.charAt(j);
				}
				k += 7;
				switch (line) {
				case "0001101":
					list.add(0);
					break;
				case "0011001":
					list.add(1);
					break;
				case "0010011":
					list.add(2);
					break;
				case "0111101":
					list.add(3);
					break;
				case "0100011":
					list.add(4);
					break;
				case "0110001":
					list.add(5);
					break;
				case "0101111":
					list.add(6);
					break;
				case "0111011":
					list.add(7);
					break;
				case "0110111":
					list.add(8);
					break;
				case "0001011":
					list.add(9);
					break;

				}
			}
			int code = (list.get(0) + list.get(2) + list.get(4) + list.get(6)) * 3
					+ (list.get(1) + list.get(3) + list.get(5)) + list.get(7);
			int result = 0;
			if (code % 10 == 0) {
				for (int i = 0; i < list.size(); i++) {
					result += list.get(i);
				}
			}
			System.out.println("#" + a + " " + result);
		}
	}

}
