import java.util.*;

public class Programmers_72410 {

    public String solution(String new_id) {
        String answer = "";
        String temp = new_id.toLowerCase(); // 1단계

        String temp2="", temp3="", temp4="", temp5="", temp6="", temp7 = "";

        // 2단계
        for(int i = 0; i<temp.length();i++){
            char ch = temp.charAt(i);
            if((ch >= '0' && ch<='9') || (ch >= 'a' && ch<='z') || ch == '-' || ch=='_'|| ch=='.'){
                temp2 += ch;
            }
        }

        // 3단계
        int idx = 0;
        for(int i=0; i<temp2.length();i++){
            if(temp2.charAt(i) == '.') {
                int j = i+1;
                String dot = ".";

                while(j != temp2.length() && temp2.charAt(j) == '.') {
                    dot += ".";
                    j++;
                }

                if(dot.length() > 1)
                    temp2 = temp2.replace(dot, ".");
            }
        }temp3 = temp2;


        // 4단계
        if(temp3.startsWith(".")){
            temp3 = temp3.substring(1,temp3.length());
        }if(temp3.endsWith(".")) {
            temp3 = temp3.substring(0, temp3.length()-1);
        }
        temp4 = temp3;

        // 5단계
        if(temp4.length() == 0)
            temp5 = "a";
        else  temp5 = temp4;


        // 6단계
        if(temp5.length() >= 16){
            temp5 = temp5.substring(0,15);
        }
        if(temp5.endsWith("."))
            temp5 = temp5.substring(0,temp5.length() - 1);
        temp6 = temp5;


        // 7단계
        if(temp6.length() <= 2){
            while(temp6.length()<3){
                temp6 += temp6.charAt(temp6.length()-1);
            }
        }temp7 = temp6;

        return temp7;
    }


    public static void main(String[] args) {
        Programmers_72410 controller = new Programmers_72410();

        String str = controller.solution("...!@BaT#*..y.abcdefghijklm");
        System.out.println(str);
    }
}
