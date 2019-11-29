import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Sol_2577_jungol{
 
    public static int max;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        max = 0;
        int countnum =0;
        int count[] = new int[d+1];
        int arr[] = new int[N];
        count[c] ++;
        countnum++;
        for(int i = 0; i < N; i ++)
        {
            arr[i] = Integer.parseInt(br.readLine());
            if(i < k)
            {
                if(count[arr[i]] == 0)
                    countnum++;
                count[arr[i]] ++;
                 
            }
        }
        for(int i = k ; i <N + k; i++)
        {
            int j= 0;
            if(i >= N)
            {
                j = Math.abs(N - i);
                 
            }else
            {
                j = i;
                 
            }
            if(count[arr[j]] == 0)
            {
                countnum ++;
            }
         
            count[arr[j]] ++;
             

            int delete = i - k ;
            
            if(delete < 0) delete = delete + N;
            ///System.out.println("pos : " + j + " " + "Delete : "  +delete);
            if(count[arr[delete]] == 1) 
            {
                countnum--;
            }count[arr[delete]] --;
            if(countnum > max) max = countnum;
            if(max == (k+1)) break;
        }
         
        System.out.println(max);
    }
 
}