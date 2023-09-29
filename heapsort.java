import java.util.*;

class HeapSort{
	public static void main(String[] args){
		HeapSort hs = new HeapSort();
		int[] array = new int[]{8, 100, 4, 27, 10, 272, 16, 41};
		hs.sort(array);
		hs.printArray(array);

	}

	private void printArray(int[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

	private void sort(int[] array){
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for(int i = 0; i < array.length; i++){
			pq.add(array[i]);
		}

		int i = 0;
		while(!pq.isEmpty()){
			array[i++] = pq.poll();
		}
	}
}