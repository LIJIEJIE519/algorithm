import java.util.Scanner;
/*-----Kruskal��С������--����--���鼯---
 * 1. Kruskal:
 * 			  ���Ȱ��ձߵ�Ȩֵ��С��������
 * 			  ÿ�δ�ʣ��ı���ѡ��Ȩֵ��С�ұߵ������㲻��ͬһ����(��������·�ı�)
 * 			  �ӵ��������У�ֱ�������� n-1 ����
 * 2. Ȩֵ���������ÿ���
 * 3. �ж��Ƿ�ͬһ�����ò��鼯(��ȼ�����㷨Ч��̫��)
 * 
 * */

//�������Ϣ
class Edge{
	int start;
	int end;
	int weight;
}

public class Ah_8_1 {
	static int N;							//����
	static int M;							//����
	private Edge[] edge = new Edge[M+1];	//�ߵ���Ϣ����
	private int[] f = new int[N+1];			//���鼯����
	
	//��������
	public void quicksort(int left,int right){
		//���������ڱ���ͷβ�� 	left��Ϊ��������
		int i = left, j = right;
		Edge t;								//�����м����Ϣ
		if (i > j) {						//����Ҫ�У������ݹ�
			return;
		}
		
		//��һ���������ҵ���
		while(i != j){
			//˳�����Ҫ��Ҫ�ȴ��ұ߿�ʼ��,����i>j, ��С�ڻ������
			while(edge[j].weight >= edge[left].weight && i < j)
				j--;
			//�Ҵ��ڻ������
			while(edge[i].weight <= edge[left].weight && i < j)
				i++;
			
			//����������
			if (i < j) {
				t = edge[i];
				edge[i] = edge[j];
				edge[j] = t;
			}
		}
		//���ջ�����λ
		t = edge[left];
		edge[left] = edge[i];
		edge[i] = t;
		
		quicksort(left, i-1);		//����������ߵģ���Ϊ�ݹ�Ĺ���
		quicksort(i+1, right);		//�����ұߵ�Ԫ��
		return;			
	}

	//���鼯Ѱ�Ҹ��ڵ�
	public int getf(int m){
		if (f[m] == m)
			return m;
		//·������
		f[m] = getf(f[m]);
		return f[m];	
	}
	//���鼯�ϲ����Ӽ���
	public int merge(int left, int right){
		int tl = getf(left);
		int tr = getf(right);
		//�ж������Ƿ���ͬһ����
		if (tl != tr) {
			f[tr] = tl;
			//����ͬһ�����˵����ȡ
			return 1;
		}
		return 0;
	}
	
	//Kruskal��С������
	public void kruskal(int n, int m){
		int count = 0;					//����
		int sum = 0;					//�Ա�Ȩֵ�Ӻ�
		//��ÿ����ö��
		for(int i = 1; i <= m; i++){
			//����������߲���ͬһ�����У��������ɻ�·
			if (merge(edge[i].start, edge[i].end) == 1) {
				System.out.print(edge[i].start + "->" + edge[i].end + "  ");
				count++;
				sum += edge[i].weight;
			}
			//���ɨ���ı��Ѿ�Ϊ�ڵ���-1�����Ѿ�Ϊ��С������
			if (count == n-1)
				break;
		}
		System.out.println();
		System.out.println("��С������Ϊ: " + sum);
	}
	
	public static void main(String[] args) {
		System.out.println("����㼰����:");
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();						//����
		M = scanner.nextInt();						//����
		Ah_8_1 ah = new Ah_8_1();
		
		for(int i = 0; i <= M; i++)					//�Ա���Ϣ��ʼ������������
			ah.edge[i] = new Edge();
		
		for(int i = 1; i <= M; i++){
			ah.edge[i].start = scanner.nextInt();
			ah.edge[i].end = scanner.nextInt();
			ah.edge[i].weight = scanner.nextInt();
		}

		//����Ȩֵ��С�Ա߿�������
		ah.quicksort(1, M);
		//���鼯��ʼ��������Ҫ(��Ǹ�������ʼΪ������)
		for(int i = 1; i <= N; i++)
			ah.f[i] = i;
		
		ah.kruskal(N, M);

	}

}
