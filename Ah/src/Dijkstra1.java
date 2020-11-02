/*-------Dijkstra�㷨---��Դ���·��-----
 * --�����·��-----���������ֱ�Ӿ���  > ����������ļ�Ӿ���
 * 
 * 1.һ���㣨Դ�㣩�����������������·����Ҳ��������Դ���·����
 * 2.��֪���·�̵Ķ��㼯��P��δ֪���·���Ķ��㼯��Q
 * 3.ͨ�����ߡ���--�ɳ�--�����㵽������������·��
 * 
 * 4.dis���������е�ֵ���Ѿ��ӡ�����ֵ����Ϊ�ˡ�ȷ��ֵ��, book[]��Ǹõ��Ƿ��Ѿ��ҵ���Сֵ(�缯��P)
 * 
 * 5.0�����һ���ڵ㣬���ܽ������Ȩ��
 * 6.̰��˼�룬�ֲ����Ž�
 * 
 * 7.��Ϊ�ڽӾ���ʵ��
 * */
public class Dijkstra1 {
 	static int Inf = Integer.MAX_VALUE;
	
	public static int[] method(int[][] a){
		int n = a.length, min, u = 0;
		//��¼��֪��̶���P
		int[] book = new int[n];
		
		//��¼��ʼ���㵽������ľ��룬����ֵ->ȷ��ֵ
		int[] dis = new int[n];
		
		//����֪P��ʼ�������book[i]==1���ʾ��������ڼ���P�У�
		//���book[i]==0���ʾ��������ڼ���Q�� ;
		for(int i = 0; i < n; i++)
			book[i] = 0;
		book[0] = 1;			//��ʼ����
		
		//��ʼ���㵽������ľ��� = ԭ�����һ����
		for(int i = 0; i < n; i++)
			dis[i] = a[0][i];
		
		System.out.print("����P���ϵĶ���˳��Ϊ:  0 ");
		
		
		//Dijkstra�㷨����
		//���»���
		for(int t = 1; t < n; t++){
			//ÿ�ν���Сֵ��
			min = Inf;
			//�����ж������ҵ����������̾���;  dis[i] < Inf: ˵���ܵ���
			for (int i = 1; i < n; i++)
				if (book[i] == 0 && dis[i] < min) {
					min = dis[i];
					u = i;
				}
			System.out.print(u + " ");
			//������뵽P������,��Ǹû����Ѿ��ҵ���Сֵ
			book[u] = 1;
			
			//���任Ϊ���㣬����������ľ���
			for (int v = 0; v < n; v++)
				if (a[u][v] < Inf) {
					//���������ֱ�Ӿ��� > ����������ļ�Ӿ���
					if (dis[v] > dis[u] + a[u][v]) {
						dis[v] = dis[u] + a[u][v];
					}
				}
		}
		return dis;
	}
	
	public static void main(String[] args) {
		int[][] a = {{0,1,12,Inf,Inf,Inf},{Inf,0,9,3,Inf,Inf},{Inf,Inf,0,Inf,5,Inf},
				{Inf,Inf,4,0,13,15},{Inf,Inf,Inf,Inf,0,4},{Inf,Inf,Inf,Inf,Inf,0}};
		int[] b = method(a);
		
		System.out.println();
		System.out.print("0���㵽�����������С����:  ");
		for (int i : b) {
			System.out.print(i + " ");
		}
	}

}
