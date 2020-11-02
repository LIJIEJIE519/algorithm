import java.util.Scanner;

/*---�����������---
 * 1.�Թ���� 
 * 
 * */

public class Ah_4_2 {
	static int[][]	a = new int[51][51];					//���Թ�
	static int[][] book = new int[51][51];					//����Ƿ��߹�
	static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};		//�������飬��������(˳ʱ��),����֮��(����ݹ�ö��)
	static int p,q,n,m,min = Integer.MAX_VALUE;
	
	public void dfs(int x, int y, int step){
		if (x == p && y == q) {					//��������������������
			if (step < min) {					//�������·��
				min = step;
			}
			return;								//���ص���һ��
		}
		//ö�ٷ���4�ֿ���
		for(int k = 0; k <= 3; k++){
			int tx = x + dir[k][0];
			int ty = y + dir[k][1];
			//�ж��Ƿ�Խ��
			if (tx<1 || ty<1 || tx>n || ty>m) {
				continue;
			}
			//�жϲ�Ϊ�ϰ��ﲢ�Ҳ���·����
			if (a[tx][ty] == 0 && book[tx][ty] == 0) {
				book[tx][ty] = 1;				//�õ��Ѿ���·����
				dfs(tx, ty, step+1);			//��ʼ������һ��
				book[tx][ty] = 0;				//���Խ�����ȡ���õ�ı��
			}
		}
		
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
		Ah_4_2 ah = new Ah_4_2();
		ah.dfs(1, 1, 0);
		System.out.println("���·��Ϊ: " + min);

	}

}
