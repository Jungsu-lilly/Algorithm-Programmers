import java.util.*;

public class B_1302 {
    public static void main(String[] args) {
        int N;
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        HashMap<String, Integer> map = new HashMap<>();

        for(int i=0;i<N;i++){
            String str = scan.next();
            map.put(str, map.getOrDefault(str, 0)+1);
        }

        ArrayList<Map.Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if(o2.getValue() != o1.getValue())
                    return o2.getValue() -o1.getValue();
                else{
                    return o1.getKey().compareTo(o2.getKey());
                }
            }
        });

        System.out.println(entries.get(0).getKey());

    }
}
