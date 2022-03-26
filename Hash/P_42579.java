package Hash;

import java.util.*;

public class P_42579 {
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();
        // K: genre, V: [plays, ID]
        HashMap<String, ArrayList<int[]>> genreMap = new HashMap<>();
        // K: genre, V: totalPlays
        HashMap<String, Integer> totalPlaysMap = new HashMap<>();

        int size = genres.length;

        for(int i=0;i<size;i++){
            ArrayList<int[]> temp = genreMap.getOrDefault(genres[i], new ArrayList<>());
            temp.add(new int[]{plays[i],i});
            genreMap.put(genres[i], temp);

            totalPlaysMap.put(genres[i], totalPlaysMap.getOrDefault(genres[i], 0)+plays[i]);
        }

        // 총 재생 횟수가 많은 순서개로 내림차순 정렬
        ArrayList<Map.Entry<String, Integer>> totalPlays = new ArrayList<>(totalPlaysMap.entrySet());
        Collections.sort(totalPlays, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                // Value 내림차순
                return o2.getValue()- o1.getValue();
            }
        });

        // 한 장르 내에서 재생된 노래가 많은 순서대로 내림차순 정렬
        for (Map.Entry<String, Integer> s : totalPlays) {
            String key = s.getKey();
            ArrayList<int[]> playList = genreMap.get(key);
            Collections.sort(playList, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    // plays 내림차순 정렬
                    return o2[0] - o1[0];
                }
            });

            for(int i=0; i<playList.size();i++){
                if(i==2) break; // 최대 2개까지만 저장
                answer.add(playList.get(i)[1]);
            }
        }
        final int SIZE = answer.size();
        int[] arr = new int[SIZE];
        for(int i=0; i<SIZE; i++){
            arr[i] = answer.get(i);
        }

        return arr;
    }

}
