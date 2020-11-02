import java.util.Scanner;

/*-----��--���鼯--�����������ͷĿ---
 * 1. ���鼯��ͨ��һά������ʵ�֣��䱾����ά��һ��ɭ�֡�
 * 			�տ�ʼ��ɭ�ֵ�ÿ���ڵ㶼�ǹ����ģ�֮��һЩ����...�𽥽���Щ����һ����
 * 			�ϲ�:�����Ҹ��ڵ�Ĺ���,	���� ������ �� �������������� ��ԭ��
 * 			����ע�⣬����������ڵ㣬�м�ڵ㲻��˵������
 * 
 * 2.����������: 1 2(1Ϊ2��BOSS), 5 2(5Ϊ2��BOSS) ʱ�� "5Ϊ1��BOSS"
 * 3.���a[i] = i���䣬��������Ǹ��ڵ㣬���ڵ��м������м�����
 * 4.�ж������Ƿ��й�ϵ����ͬһ����
 * */
public class Ah_7_4 {
	static private int N = 0;
	static private int M = 0;
	int[] a = new int[N+1];					//ǿ������
	
	//�ݹ��Ҹ��ڵ�ĺ�����Ҳ�����ҷ����Ż������쵼��
	public int getf(int m){
		if (a[m] == m) 
			return m;
		else {
			//ѹ��·����ÿ�κ������ص�ʱ���������쵼�˵ı��
			a[m] = getf(a[m]);
			return a[m];
		}
	}
	
	//�ϲ����Ӽ��ĺ���
	public void merge(int left, int right){
		int tl = getf(left);
		int tr = getf(right);
		
		//�ж����Ӽ��Ƿ���ͬһ�����У���ͬ���ڵ㣬ͬ�Ż�
		if (tl != tr)
			//������ԭ�򡱣���߱���ұߵ�BOSS,
			a[tr] = tl;
	}

	public static void main(String[] args) {
		System.out.println("����ǿ��������n������������Ϣm:");
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();				//ǿ����
		M = scanner.nextInt();				//��Ϣ��
		Ah_7_4 ah = new Ah_7_4();
		int sum = 0;
		
		//��ʼ�����Լ����Լ����±�
		for(int i = 1; i <= N; i++)
			ah.a[i] = i;
		
		for(int i = 1; i <= M; i++){
			int b = scanner.nextInt();
			int c = scanner.nextInt();
			ah.merge(b, c);
		}
		
		System.out.println("����ͷĿΪ: ");
		for(int i = 1; i <= N; i++){
			//���a[i]���䣬��������Ǹ��ڵ�
			if (ah.a[i] == i) {
				System.out.print(ah.a[i] + " ");
				sum++;
			}
		}
		System.out.println();
		System.out.println("�ж��������Ż� : " + sum);
	}

}
