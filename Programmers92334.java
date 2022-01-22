import java.util.*;

public class Programmers92334 {

    public static int[] solution(String[] id_list, String[] report, int k) {

        int[] ans = new int[id_list.length];
        // key: 피신고자, value : 신고자
        Map<String, Set<String>> map = new HashMap<>();

        for (String person : report) {
            String[] arr = person.split(" "); // 신고자, 피 신고자
            Set<String> set;
            set = map.getOrDefault(arr[1], new HashSet<String>());
            set.add(arr[0]); // 신고자를 더함.
            map.put(arr[1], set);
        }

        map.forEach((key, value) -> {
            if(value.size() >= k){
                value.forEach(person ->{
                    for(int i=0; i<id_list.length; i++){
                        if(person.equals(id_list[i])){
                            ans[i]++; break;
                        }
                    }
                });
            }
        });

        return ans;
    }

}
