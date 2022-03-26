import java.util.*;

public class TestMain2 {
    public static void main(String[] args) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        pq.add(new int[]{0,3});
        pq.add(new int[]{1,9});
        pq.add(new int[]{2,6});
        pq.add(new int[]{3,7});

        for (int[] i : pq) {
            System.out.print("["+i[0]+", "+i[1]+"]"+" ");
        }
        System.out.println();

        while(!pq.isEmpty()){
            int[] peek = pq.peek();
            System.out.println("["+peek[0]+", "+peek[1]+"]");
            pq.poll();
        }
    }
}
