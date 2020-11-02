import java.util.Scanner;

/*----�������--ͼ�ж�����ͼ�ĸ��������---
 * 1.Floodfill��ˮ��䷨��������䷨����
 * 			     ����������Χ�ĵ㣬������������ĵ������Ϊ������...
 * 2.��ɫ������������ʶ�������ɫ
 * 3.0Ϊ��������ΪС��
 * 
 * 4.����ģ��
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
 * 
 * 
 * */
public class Ah_4_5 {
	static int N, M;
	int[][] a = new int[51][51];				//����ͼ
	int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};	//�������飬��������
	int[][] book = new int[51][51];				//����Ƿ��Ѿ�����
	static int sum = 1;							//���ӵ����
	public int dfs(int i, int j, int color){
		//�Ըõ������ɫ
		a[i][j] = color;
		//ö���ĸ�����������
		for(int k = 0; k <= 3; k++){
			int x = i + dir[k][0];
			int y = j + dir[k][1];
			//�ж��Ƿ�Խ��
			if (x > N || x < 1 || y > M || y < 1)
				continue;
			//����õ�ΪС����δ������
			if (a[x][y] > 0 && book[x][y] == 0) {
				sum++;
				book[x][y] = 1;					//һ�����ȸ�ֵΪ1���������ѭ��
				dfs(x, y, color);				//������һ����
			}
		}
		return sum;								//��������Χ4���㼴������һ����
	}

	public static void main(String[] args) {
		Ah_4_5 ah = new Ah_4_5();
		int color = 0;							//��0�н�����
		System.out.println("�����ͼ������");
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();		//��
		M = scanner.nextInt();		//��
		//����
		for(int i = 1; i <= N; i++)
			for(int j = 1; j <= M; j++){
				ah.a[i][j] = scanner.nextInt();
			}
		
		//��ÿ��С����( >0 )ö�ٳ��Խ���dfs��ɫ
		for(int i = 1; i <= N; i++)
			for(int j = 1; j <= M; j++){
				//��Ϊ��ɫ��ᱻdfs��ֵ  <0  �����ҵ� >0 �ĵ�һ������С��
				if (ah.a[i][j] > 0) {
					sum = 1;
					color--;
					//��Ϊdfs��Ϊ��һ�����ǣ� �ʴ˵��ڴ˱��
					ah.book[i][j] = 1;
					sum = ah.dfs(i, j, color);
					System.out.println("���Ϊ: " + sum);
				}
				
			}
		
		//���
		for(int i = 1; i <= N; i++){
			for(int j = 1; j <= M; j++){
				System.out.print(ah.a[i][j] + "  ");
			}
			System.out.println();
		}

		//��ֵ����
		System.out.println("����С��: " + -color);
	}

}
