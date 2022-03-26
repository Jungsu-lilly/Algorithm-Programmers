package sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class Programmers_42746 {

    public String solution(int[] numbers) {
        ArrayList<String> list = new ArrayList<>();
        int numofZero = 0;
        for (int number : numbers) {
            if(number!=0){
                String s = Integer.toString(number);
                list.add(s);
            }
            else numofZero++;
        }

        if(numofZero == numbers.length){
            return "0";
        }

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });

        String answer = "";
        for (String s : list) {
            answer += s;
        }
        for(int i=0;i<numofZero;i++){
            answer += "0";
        }

        return answer;
    }


}
