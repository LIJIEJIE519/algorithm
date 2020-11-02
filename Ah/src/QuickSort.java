/*-----��������-------
 * 1.��һ������Ϊ��׼������߶�<=x, �ұ߶�>=x
 * 2.���˿�ʼ��̽�⡱,��������������i��j���ֱ�ָ����������ߺ����ұ�,���ڱ�i���͡��ڱ�j��
 * 3.��ʵ���ǽ���һ�ֵĻ�׼����λ��ֱ�����е�������λΪֹ
 * 4.������������ʱ�临�ӶȺ�ð��������һ���Ķ���O(N2)��
 * 5.����ƽ��ʱ�临�Ӷ�ΪO(NlogN)
 * 
 * Arrays.sort()
 * */
public class QuickSort {
	//��������
	public static int[] quick(int[] a,int left,int right){
		//���ڱ������ڱ�
		int i = left,j = right,t,temp;

		//����Ҫ�У������ݹ�
		if (left > right) {
			return null;
		}
		//����
		temp = a[left];
		
		while(i != j){
			
			//˳�����Ҫ��Ҫ�ȴ��ұ߿�ʼ��,����i>j
			while(a[j] >= temp && i < j)
				j--;
			//�ٴ���߿�ʼ
			while(a[i] <= temp && i < j)
				i++;
			
			//��������
			if (i < j) {
				t = a[i];
				a[i] = a[j];
				a[j] = t;
			}
		}
		//���ջ�����λ
		a[left] = a[i];
		a[i] = temp;
		
		quick(a,left,i-1);		//����������ߵģ���Ϊ�ݹ�Ĺ���
		quick(a, i+1, right);	//�����ұߵ�
		
		return a;
	}

	public static void main(String[] args) {
		int[] a = {6,1,2,7,9,3,4,5,10,8};
		System.out.println("ԭ����Ϊ: ");
		for (int i : a) {
			System.out.print(i + " ");
		}

		System.out.println();
		System.out.println("���������Ϊ: ");
		a = quick(a, 0, a.length-1);
		for (int i : a) {
			System.out.print(i + " ");
		}
	}

}
