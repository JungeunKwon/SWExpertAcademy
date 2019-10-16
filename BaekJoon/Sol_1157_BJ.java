import java.io.*;
import java.util.*;

public class Sol_1157_BJ {

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			String input = br.readLine();
			input = input.toUpperCase();
			List<store> array = new ArrayList<store>();
			for (int i = 0; i < input.length(); i++) {
				boolean isequal = false;
				for (int j = 0; j < array.size(); j++) {
					if (array.get(j).word == input.charAt(i)) {
						array.get(j).count++;
						isequal = true;
						break;
					}
				}
				if (isequal == false) {
					store tmp = new store();
					tmp.word = input.charAt(i);
					tmp.count = 1;
					array.add(tmp);
				}
			}
			store max1 = new store();
			max1.count = array.get(0).count;
			max1.word = array.get(0).word;
			store max2 = new store();
			max2.count = 0;
			max2.word = ' ';

			for (int i = 1; i < array.size(); i++) {
				if (array.get(i).count > max1.count) {
					max1.count = array.get(i).count;
					max1.word = array.get(i).word;
				} else if (array.get(i).count > max2.count) {
					max2.count = array.get(i).count;
					max2.word = array.get(i).word;
				}
			}
			if (max1.count == max2.count) {
				bw.write("?");
			} else {
				bw.write(max1.word);
			}
			bw.flush();
		} catch (Exception ex) {

		}

	}

	public static class store {
		public int count;
		public char word;

		public store() {
			count = 0;
			word = ' ';
		}

	}

}