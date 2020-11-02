import java.util.LinkedList;

/*----�������--ˮ�ܹ���Ϸ----
 * 1. remove(),removeFirst():���Ƴ��ڻ�ȡԪ��
 * 2. ���ö������
 * 
 * 3.����ģ��
 * 			void dfs(int i, int j)
 * 			{
 * 				�жϱ߽�--return
 * 				����ÿһ�ֿ���  
 * 				for(int i = 1; i <= n; i++)
 * 				{
 * 					�ж�(if)�Ƿ�Խ��;
 * 					�ж�(if,for)����Ҫ��(δ������)
 * 						��Ǳ���
 * 						������һ��  dfs(step+1);
 * 					��һ�����ȡ��
 *  			}
 *  			����(return)
 *  		}
 * */
public class Ah_4_6 {
	static int N = 5, M = 4;			//�յ�
	static int[][] a = {{5,3,5,3},{1,5,3,0},{2,3,5,1},{6,1,1,5},{1,5,5,4}};
	int[][]	book = new int[5][4];
	static int flag = 0;
	class Dis{
		int x = 0;
		int y = 0;
	}
	LinkedList<Dis> list = new LinkedList<>();
	
	//
	public void dfs(int i, int j, int dir){
		//�����յ�
		if (i == N-1 && j == M) {
			flag = 1;
			while(!list.isEmpty()){
				//�����Ȼ�����Ƴ�
				System.out.println("(" + list.getFirst().x + "," +list.getFirst().y + ")");
				list.remove();
			}
			return;
		}
		
		//Խ��
		if (i > N-1 || i < 0 || j > M-1 || j < 0) {
			return;
		}
		if (book[i][j] == 1) 
			return;
		book[i][j] = 1;
		
		Dis d = new Dis();
		d.x = i;
		d.y = j;
		list.add(d);
		
		//��ˮ�������
		if (dir == 1) {
			//ֱ��
			if (a[i][j] == 5 || a[i][j] == 6) {
				dfs(i, j+1, 1);
			}
			//���
			if (a[i][j] >= 1 && a[i][j] <=4) {
				dfs(i-1, j, 4);
				dfs(i+1, j, 2);
			}
		}
		//��ˮ�����ϱ�
		if (dir == 2) {
			//ֱ��
			if (a[i][j] == 5 || a[i][j] == 6) {
				dfs(i+1, j, 2);
			}
			//���
			if (a[i][j] >= 1 && a[i][j] <=4) {
				dfs(i, j-1, 3);
				dfs(i, j+1, 1);
			}
		}
		//��ˮ�����ұ�
		if (dir == 3) {
			//ֱ��
			if (a[i][j] == 5 || a[i][j] == 6) {
				dfs(i, j-1, 3);
			}
			//���
			if (a[i][j] >= 1 && a[i][j] <=4) {
				dfs(i-1, j, 4);
				dfs(i+1, j, 2);
			}
		}
		//��ˮ�����±�
		if (dir == 4) {
			//ֱ��
			if (a[i][j] == 5 || a[i][j] == 6) {
				dfs(i-1, j, 4);
			}
			//���
			if (a[i][j] >= 1 && a[i][j] <=4) {
				dfs(i, j-1, 3);
				dfs(i, j+1, 1);
			}
		}
		book[i][j] = 0;
		
		if (!list.isEmpty()) 	
			list.removeLast();
		return;
	}

	public static void main(String[] args) {
		Ah_4_6 ah = new Ah_4_6();
		ah.dfs(0, 0, 1);
		if (flag == 1) {
			System.out.println("�ҵ�·����");
		}
		else {
			System.out.println("�����ܣ�");
		}
			
	}

}
