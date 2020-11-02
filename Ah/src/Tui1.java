public class Tui1 {
	//������
	public void creat(int[] a, int n){
		for(int i = n/2; i >=0 ;i--){
			siftdown(a,i,n);
		}
	}

	//���µ�������
	private void siftdown(int[] a, int i, int n) {
		//flag��������Ƿ���Ҫ�������µ���
		int t,flag = 0,k;
		
		while(i*2 <= n && flag ==0){
			//�����ж�����������ӵĹ�ϵ������t��¼ֵ��С�Ľ����
			if (a[i] > a[i*2]) 
				t = i*2;
			else
				t = i;
			
			//��������Ҷ��ӵ�����£��ٶ��Ҷ��ӽ�������
			if (i*2+1 <= n) {
				 //����Ҷ��ӵ�ֵ��С�����½�С�Ľ����  
				if (a[t] > a[i*2+1]) {
					t = i*2+1;
				}
			}
			//���������С�Ľ���Ų����Լ���˵���ӽ�����бȸ�����С��
			if (t != i) {
				k = a[t];
				a[t] = a[i];
				a[i] = k;
				//����iΪ�ղ����������Ķ��ӽ��ı�ţ����ڽ������������µ���//����iΪ�ղ����������Ķ��ӽ��ı�ţ����ڽ������������µ���
				i = t;
			}
			//���˵����ǰ�ĸ�����Ѿ��������ӽ�㶼ҪС�ˣ�����Ҫ�ڽ��е�����
			else 		
				flag = 1;
		}
		
	}
	public int print(int[] a,int n){
		int t = a[1];
		a[1] = a[n];
		n--;
		siftdown(a, 1, n);
		return t;
		
	}

	public static void main(String[] args) {
		Tui1 tui = new Tui1();
		int[] a = new int[]{0,5,43,22,2,1,2,23};
		tui.creat(a, a.length-1);
		for (int i : a) {
			System.out.print(i + " ");
		}
		
		System.out.println();
		int n = a.length;
		for(int i = 1; i < n; i++){
			System.out.print(tui.print(a, a.length-1) + " ");
		}
	}

}
