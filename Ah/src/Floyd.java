/*------ֻ��5�е�Floyd���·���㷨---��Դ���·---
 * 1.i �� j ��ֱ��·�������������� k �ڵ�ʹ�����
 * 	 ��ͨ�� 1 �ڵ㣬a[i][j] > a[i][1]+a[1][j],	
 * 			    ��a[i][j] = a[i][1]+a[1][j]
 * 	 ��ͨ�� 1,2 �ڵ㣬a[i][j] > a[i][2]+a[2][j],	
 * 			         ��a[i][j] = a[i][2]+a[2][j]
 * 	......
 * 	Ҳ���൱������������ڵ�......��1,2�Ѿ����θı�
 * 
 * 2.����ʵ�ַǳ���
 * 3.ʱ�临�Ӷ���O(N^3)
 * 4.Floyd-Warshall�㷨���ܽ�����С���Ȩ��·�������߽С���Ȩ��������ͼ
 * 5.���������������·�������Ϊ����Դ���·��
 * 
 * 6.��Ϊ�ڽӾ���
 * */
public class Floyd {
	public static int[][] method(int[][] a,int n){
		for(int k = 0; k < n; k++)
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					if(a[i][j] > a[i][k] + a[k][j])
						a[i][j] = a[i][k] + a[k][j];
		return a;
	}

	public static void main(String[] args) {
		//100����ͨ·�������
		int[][] a = {{0,2,6,4},{100,0,3,100},{7,100,0,1},{5,100,12,0}};
		a = method(a, 4);
		
		for(int i = 0; i < 4; i++){
			for(int j = 0; j < 4; j++){
				System.out.print(a[i][j] + "  ");
			}
			System.out.println();
		}
	}

}
