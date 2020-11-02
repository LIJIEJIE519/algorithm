import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
//����1����ɾ���������Ž���2�����ŵ��⴮����ĩβ��
//�ٽ���3����ɾ��������4�����ٷŵ��⴮����ĩβ��ֱ��ʣ�����һ������
//�����һ����Ҳɾ����

public class QueueNum {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>(Arrays.asList(6,3,1,7,5,8,9,2,4));
		//Integer[] integers = {6,3,1,7,5,8,9,2,4};
		//list.addAll(Arrays.asList(integers));
		
		Queue<Integer> num = new LinkedList<>();
		int i = 0;
		do{
			num.add(list.get(i));
			list.remove(list.get(i));
			list.add(list.get(i));
			list.remove(list.get(i));
		}while(list.size() != 1);
		num.add(list.get(i));
		
		for (Integer integer : num) {
			System.out.print(integer + " ");
		}
	}

}
