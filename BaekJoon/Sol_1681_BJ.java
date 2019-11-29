import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Sol_1681_BJ{
    public static final int INF = 1000001;
    public static int arr[][];
    public static int dp[][];
    static final int START = 0;
    public static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        dp = new int[N][1<<N];
 
        StringTokenizer st; 
        for(int i = 0; i < N; i++)
        {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N ; j ++)
            {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j]==0) arr[i][j] = INF;
            }
        }
        for (int temp[] : dp) {
            Arrays.fill(temp, -1);
        }
 
        System.out.println(solve(START,  1<<START));
    }
 
    private static int solve(int cur, int B) {
         
        if (dp[cur][B] != -1) return dp[cur][B];
        if (B == (1 << N) - 1) {
            return dp[cur][B] = (arr[cur][START] != INF ? arr[cur][START] : INF);
        }
 
        // ���� ����
        dp[cur][B] = INF;
        for (int i = 0; i < N; i++) {
 
            // �� �� ���ų�, �湮�ߴ� �����̶��
            if (arr[cur][i] == INF || (B & (1 << i)) > 0) continue;
             
            dp[cur][B] = Math.min(dp[cur][B], solve(i, B | (1 << i)) + arr[cur][i]);
        }
 
        return dp[cur][B];
    }
 
}