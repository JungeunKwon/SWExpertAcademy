import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol_4613_SW {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int a = 1; a <= T; a++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			char[][] arr = new char[N][M];
			String line = "";
			for (int i = 0; i < N; i++) {
				line = br.readLine();
				for (int j = 0; j < M; j++) {
					arr[i][j] = line.charAt(j);
				}
			}
			int maxcount = N * M;
			for (int i = 1; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					int cnt = 0;
					for (int k = 0; k < i; k++) {
						for (int l = 0; l < M; l++) {
							if (arr[k][l] != 'W')
								cnt++;
						}
					}
					for (int k = j; k < N; k++) {
						for (int l = 0; l < M; l++) {
							if (arr[k][l] != 'R')
								cnt++;
						}
					}
					for (int k = i; k < j; k++) {
						for(int l = 0; l < M; l++)
						{
							if (arr[k][l] != 'B')
							cnt++;
						}
						
					}
					if (cnt < maxcount)
					maxcount = cnt;
				}
				
			}

			System.out.println("#" + a + " " + maxcount);
		}
	}

}
