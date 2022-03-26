package Heap;

public class Heap {
    public static void main(String[] args) {
        int heap[] = {7,6,5,8,3,5,9,1,6};
        int NUM = 9;

        // 최대 힙 생성. 부모 노드의 값이 자식 노드보다 크게 - O(N*LogN)
        for(int i=1; i<NUM; i++){
            int c = i;
            do{
                int root = (c-1)/2;
                if(heap[root] < heap[c]){
                    int temp = heap[root];
                    heap[root] = heap[c];
                    heap[c] = temp;
                }
                c = root;
            }while(c!=0);
        }

        for (int r : heap) {
            System.out.print(r + " ");
        }
        System.out.println();


        for(int i=NUM-1; i>=0; i--){
            int temp = heap[0];
            heap[0] = heap[i];
            heap[i] = temp;
            int root = 0;
            int c = 0;
            do {
                c = 2*root + 1;
                if(c<i-1 && heap[c] < heap[c+1])
                    c++;
                if(c < i && heap[root] < heap[c]){
                    int t = heap[root];
                    heap[root] = heap[c];
                    heap[c] = t;
                }
                root = c;
            }while(c < i);
        }

        for (int r : heap) {
            System.out.print(r + " ");
        }

    }
}
