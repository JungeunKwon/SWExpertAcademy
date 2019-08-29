import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Sol_1231 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int a = 1; a <= 10; a++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			ArrayList<Node> list = new ArrayList<>();
			int num = Integer.parseInt(st.nextToken());
			list.add(new Node('0', 0, 0, 0));
			for (int i = 0; i < num; i++) {
				int position = 0;
				char data;
				int left = 0;
				int right = 0;
				st = new StringTokenizer(br.readLine());
				position = Integer.parseInt(st.nextToken());
				data = st.nextToken().charAt(0);
				if (st.hasMoreTokens()) {
					left = Integer.parseInt(st.nextToken());
				}
				if (st.hasMoreTokens()) {
					right = Integer.parseInt(st.nextToken());
				}
				Node node = new Node(data, position, left, right);
				list.add(node);

			}
			System.out.print("#"+ a +" ");
			preOrder(list, 1);
			System.out.println();
		}
	}

	private static void preOrder(ArrayList<Node> list, int i) {
		int lefpos = list.get(i).left;
		int rightpos = list.get(i).right;
		if (lefpos > 0 && !list.get(lefpos).visited) {
			preOrder(list, lefpos);
		}
		System.out.print(list.get(i).data);
		if (rightpos > 0 && !list.get(rightpos).visited) {
			preOrder(list, rightpos);
		}
		list.get(i).visited = true;
	}

	public static class NodeList {
		Node root;
	}

	public static class Node {
		char data;
		int num;
		int left;
		int right;
		boolean visited;

		public Node(char data, int num, int left, int right) {

			this.data = data;
			this.num = num;
			this.left = left;
			this.right = right;
			visited = false;
		}

	}

}
