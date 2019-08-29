import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class Sol_1232{
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      for (int a = 1; a <= 10; a++) {
         StringTokenizer st = new StringTokenizer(br.readLine());
         ArrayList<Node> list = new ArrayList<>();
         int num = Integer.parseInt(st.nextToken());
         list.add(new Node("0", 0, 0, 0));
         for (int i = 0; i < num; i++) {
            int position = 0;
            String data;
            int left = 0;
            int right = 0;
            st = new StringTokenizer(br.readLine());
            position = Integer.parseInt(st.nextToken());
            data = st.nextToken();
            if (st.hasMoreTokens()) {
               left = Integer.parseInt(st.nextToken());
            }
            if (st.hasMoreTokens()) {
               right = Integer.parseInt(st.nextToken());
            }
            Node node = new Node(data, position, left, right);
            list.add(node);

         }
         System.out.print("#"+ a +" " + (int)inOrder(list, 1) + "\n");
      }
   }
   private static double inOrder(ArrayList<Node> list, int i) {
	   if(i == -1)
	   {
		   return 0;
	   }
	   if(list.get(i) == null)
	   {
		   return 0;
	   }
	  String tmp = list.get(i).data;
	  int leftpos = list.get(i).left;
	  int rightpos = list.get(i).right;
      if(tmp.equals("+"))
      {
    	  return inOrder(list, leftpos) + inOrder(list,rightpos);
      }else if(tmp.equals("-"))
      {
    	  return inOrder(list, leftpos) - inOrder(list,rightpos);
      }else if(tmp.equals("*"))
      {
    	  return inOrder(list, leftpos) * inOrder(list,rightpos);
      }else if(tmp.equals("/"))
      {
    	  return inOrder(list, leftpos) / inOrder(list,rightpos);
      }else
      {
    	  return Integer.parseInt(tmp);
      }
    
   
   }
   public static class Node {
      String data;
      int num;
      int left;
      int right;
      public Node(String data, int num, int left, int right) {
         this.data = data;
         this.num = num;
         this.left = left;
         this.right = right;
      }

   }

}