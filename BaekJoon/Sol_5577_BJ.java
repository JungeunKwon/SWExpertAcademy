import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백준 RBY팡 (시뮬레이션)
public class Sol_5577_BJ {
	static int[] datas;
	static int num = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		num = Integer.parseInt(reader.readLine());
		datas = new int[num];
		int ans = 0;
		for (int i = 0; i < datas.length; i++) {
			datas[i] = Integer.parseInt(reader.readLine());
		}
		for (int i = 0; i < num; i++) {
			for (int j = 1; j <= 3; j++) {
				ans = Math.max(ans, solve(i, j)); // 가장 많이 없어진 블럭
			}

		}
		int result = num - ans;
// System.out.println(Arrays.toString(datas));
		System.out.println(result);
	}

	private static int solve(int i, int color) {
		int left = i;
		int right = i;
		int cnt = 0;
		int cColor;
		int oriColor = datas[i]; // 기존 색상 보존
		int ret = 0;
		datas[i] = color;
		while (left >= 0 && right < num && datas[left] == datas[right]) {
			cColor = datas[left];
			cnt = 0;
			while (left >= 0 && datas[left] == cColor) {
				left--;
				cnt++;
			}
			while (right < num && datas[right] == cColor) {
				right++;
				cnt++;
			}
			if (cnt >= 4) {
				ret += cnt;
			}
		}

		datas[i] = oriColor; // 데이터 원상복구
		return ret - 1; // 삭제되는 갯수를 셀때 좌, 우 겹쳐저서 셈
	}
}