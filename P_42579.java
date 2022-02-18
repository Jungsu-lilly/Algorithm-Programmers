import java.util.*;

public class P_42579 {
    public int[] solution(String[] genres, int[] plays) {
        int idx= 0, N = 0;
        int[] ans = new int[201];
        // <genre, <재생횟수, 고유번호>>
        HashMap<String, ArrayList<int[]>> map = new HashMap<>();
        // <genre, 총 재생 횟수>
        HashMap<String, Integer> countMap= new HashMap<>();

        for(int i=0;i<genres.length;i++){
            String genre = genres[i];
            ArrayList<int[]> array = map.getOrDefault(genre, new ArrayList<>());
            array.add(new int[]{plays[i], i});
            map.put(genre, array);
        }

        Set<String> keys = map.keySet();

        for (String key : keys) {
            ArrayList<int[]> list = map.get(key);
          //  System.out.println(key);
            for (int[] arr : list) {
           //     System.out.println("재생횟수: "+arr[0]+", 고유번호: "+arr[1]);
                countMap.put(key, countMap.getOrDefault(key, 0)+arr[0]);
            }
          //  System.out.println();
        }

        Set<Map.Entry<String, Integer>> entries1 = countMap.entrySet();
        for (Map.Entry<String, Integer> str : entries1) {
            System.out.println(str.getKey()+"  /  "+str.getValue());
        }
        Iterator<String> it = countMap.keySet().iterator();
        while(it.hasNext()){
            String str = it.next();
            System.out.println(str);
        }


        ArrayList<Map.Entry<String, Integer>> entries =
                new ArrayList<Map.Entry<String, Integer>>(countMap.entrySet());

        Collections.sort(entries, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                // 값 내림차순으로 정렬
                return o2.getValue() - o1.getValue();
            }
        });
//
//        for (Map.Entry<String, Integer> entry : entries) {
//            System.out.println(entry.getKey()+" 총 재생횟수: "+entry.getValue());
//        }

        for (Map.Entry<String, Integer> entry : entries) {
            String key = entry.getKey();
            // 재생횟수, 고유번호 들어있는 배열
            ArrayList<int[]> values = map.get(key);

            // 재생 횟수 내림차순 정렬
            Collections.sort(values, new Comparator<int[]>() {
                @Override
                public int compare(int[] arr1, int[] arr2) {
                    if(arr2[0] - arr1[0] > 0) return 1;
                    else if(arr2[0] - arr1[0] < 0) return -1;
                    else{ // 두 값이 같은 경우 고유번호 값 오름차순
                        return arr1[1] - arr2[1];
                    }
                }
            });

//            System.out.println(key);
//            for (int[] value : values) {
//                System.out.println("재생횟수: "+value[0]+", 고유번호: "+value[1]);
//            }

            for(int i=0;i<values.size();i++){
                if(i==2) break;
                ans[idx++] = values.get(i)[1];
            }

        }

        int[] ans2 = new int[idx];
        for(int i=0;i<=idx-1;i++){
            ans2[i] = ans[i];
        }

        return ans2;
    }

    public static void main(String[] args) {
        P_42579 p = new P_42579();
        String [] genres= {"classic", "pop", "jazz", "pop", "classic", "classic", "pop"};
        int[] plays= {500, 300, 600, 200, 150, 1800, 300};
        int[] answer = p.solution(genres, plays);
        System.out.print("[ ");
        for (int n : answer) {
            System.out.print(n);
        }
        System.out.print(" ]");
    }
}
