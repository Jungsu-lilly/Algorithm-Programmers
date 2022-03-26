package Hash;

import java.util.HashMap;
import java.util.Map;

public class Programmers_42577 {

    public boolean solution(String[] phone_book) {
        Map<String, Integer> map = new HashMap<>();

        for(int i=0;i<phone_book.length;i++)
            map.put(phone_book[i],i);

        for(int i=0;i<phone_book.length;i++){
            for(int j=0;j<phone_book[i].length();j++){
                if(map.containsKey(phone_book[i].substring(0,j))){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Programmers_42577 p =new Programmers_42577();
        String[] s1 = {"119", "97674223", "1195524421"};
        String[] s2 = {"123","456","789"};
        String[] s3 = {"12","123","1235","567","88"};
        boolean solution1 = p.solution(s1);
        boolean solution2 = p.solution(s2);
        boolean solution3 = p.solution(s3);

        System.out.println(solution1);
        System.out.println(solution2);
        System.out.println(solution3);
    }
}
