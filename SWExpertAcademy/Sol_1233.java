import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Sol_1233 {
	public static boolean flag;

	public static void main(String[] args) throws Exception {
		  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		  
		for (int a = 1; a <= 10; a++) {
			flag = true;
			int num = Integer.parseInt(br.readLine());
			for (int i = 0; i < num; i++) {
				String line = br.readLine();
				String[] datas = line.split(" ");
				if (datas.length == 4) {
					if (!datas[1].equals("+") && !datas[1].equals("-") && !datas[1].equals("*") && !datas[1].equals("/")) {
						flag = false;
					}
				} else {
					if (datas[1].equals("+") || datas[1].equals("-") || datas[1].equals("*") || datas[1].equals("/")) {
						flag = false;
					}
				}

			}

			if (flag) {
				System.out.print("#" + a + " " + "1" + "\n");
			} else {
				System.out.print("#" + a + " " + "0" + "\n");
			}

		}
	}
}