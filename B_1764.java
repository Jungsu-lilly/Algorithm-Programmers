import java.util.*;

public class B_1764 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        int N,M;
        N = scan.nextInt();
        M = scan.nextInt();
        HashMap<String,Integer> map1 = new HashMap<>();
        HashMap<String,Integer> map2 = new HashMap<>();

        for(int i=0;i<N;i++){
            String s = scan.next();
            map1.put(s,i);
        }
        for(int i=0;i<M;i++){
            String s = scan.next();
            map2.put(s,i);
        }

        Set<String> keys = map1.keySet();
        for (String key : keys) {
            if (map2.containsKey(key)) {
                list.add(key);
            }
        }

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        System.out.println(list.size());
        for (String s : list) {
            System.out.println(s);
        }
    }
}
