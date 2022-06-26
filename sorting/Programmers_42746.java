package sorting;

import java.util.*;

public class Programmers_42746 {

    public String solution(int[] numbers) {
        String answer = "";
        int numOfZero = 0;

        List<String> list = new ArrayList<>();
        for (int n : numbers) {
            if(n!=0) list.add(Integer.toString(n));
            numOfZero++;
        }

        if(numOfZero == numbers.length) return "0";

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });

        for (String s : list)
            answer+=s;

        for(int i=0;i<numOfZero;i++)
            answer+="0";

        return answer;
    }


}
