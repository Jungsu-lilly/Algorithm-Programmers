import java.util.*;

class Solution{
    public int[] solution(String[] genres, int[] plays) {
        int k =0;
        Map<String, ArrayList<int[]>> genreMap = new HashMap<>();
        Map<String, Integer>total = new HashMap<>();

        int length = genres.length;
        List<Integer> list = new ArrayList<>();

        for(int i=0;i<length;i++){
            ArrayList<int[]> temp = genreMap.getOrDefault(genres[i], new ArrayList<>());
            temp.add(new int[]{i, plays[i]});
            genreMap.put(genres[i],temp);
            total.put(genres[i],total.getOrDefault(genres[i], 0)+plays[i]);
        }

        ArrayList<Map.Entry<String, Integer>> totalPlays = new ArrayList<>(total.entrySet());
        Collections.sort(totalPlays, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        for (Map.Entry<String, Integer> s : totalPlays) {
            String key = s.getKey();
            ArrayList<int[]> playList = genreMap.get(key);

            Collections.sort(playList, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o2[1] - o1[1];
                }
            });

            for(int i=0;i<playList.size();i++){
                if(i==2) break;
                list.add(playList.get(i)[0]);
            }
        }

        int[]ans = new int[list.size()];

        // list -> array
        for(int i=0;i<list.size();i++){
            ans[i]=(int)list.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] ans = s.solution(new String[]{"classic", "pop", "classic", "classic", "pop"},
                new int[]{500, 600, 150, 800, 2500});
        for (int a : ans) {
            System.out.print(a+", ");
        }
    }
}