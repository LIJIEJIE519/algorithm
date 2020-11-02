import java.util.LinkedList;
import java.util.Scanner;

/*-----�����������BFS-----���������ʽ--
 * 1. һ��һ�����չ����չʱÿ����һ�����е�ͽ��˵��������У�Ȼ���Ƴ�ͷ��㣬���µ�ͷ����ֿ�ʼ�������...
 * 2. ����Ϊ�Թ���ȣ�ÿ����ֻ���һ��
 * 
 * */
public class Ah_4_3 {
	static int[][]	a = new int[51][51];					//���Թ�
	static int[][] book = new int[51][51];					//����Ƿ��߹�
	static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};		//�������飬��������(˳ʱ��),����֮��(����ݹ�ö��)
	static int p,q,n,m,min = Integer.MAX_VALUE;
	
	//���������
	class Dis{
		int x;
		int y;
		int dis;
	}
	
	public void bfs(int startx, int starty){
		
		LinkedList<Dis> list = new LinkedList<>();	//��������
		Dis d = new Dis();							//���������
		d.x = startx;
		d.y = starty;
		d.dis = 0;
		list.add(d);								//���
		book[startx][starty] = 1;					//��Ǹõ��Ѿ���ӣ����ظ�
		int flag = 0;								//���δ�ҵ�Ŀ��
		
		while(!list.isEmpty()){
			//ö���ĸ�����
			for(int k = 0; k <= 3; k++){
				//�������ƶ�
				int tx = list.getFirst().x + dir[k][0];
				int ty = list.getFirst().y + dir[k][1];
				//�Ƿ�Խ��
				if (tx<1 || ty<1 || tx>n || ty>m) {
					continue;
				}
				//�жϲ�Ϊ�ϰ��ﲢ��û�������
				if (a[tx][ty] == 0 && book[tx][ty] == 0){
					book[tx][ty] = 1;
					d = new Dis();
					d.x = tx;
					d.y = ty;
					//һ��Ϊͷ���dis + 1
					d.dis = list.getFirst().dis + 1;
					list.add(d);
				}
				//�������Ŀ��ڵ�
				if (tx == p && ty == q) {
					flag = 1;
					break;
				}
			}
			if (flag == 1) 
				break;
			//ǧ�������ǣ��Ƴ�ͷ������������չ
			list.removeFirst();
		}
		System.out.println("���·��Ϊ: " + d.dis);
		
	}

	public static void main(String[] args) {
		System.out.println("�����Թ�(nΪ��,mΪ��):");
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		m = scanner.nextInt();
		
		for(int i = 1; i <= n; i++)
			for(int j = 1; j <= m; j++){
				a[i][j] =scanner.nextInt();
			}
		p = 4;
		q = 3;
		Ah_4_3 ah = new Ah_4_3();
		ah.bfs(1, 1);

	}

}
