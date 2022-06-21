package 완전탐색;

public class P_42842 {  // 프로그래머스 - [카펫]
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[]{0,0};
        int m=0,n=0; // n:세로, m:가로

//        m+n = (brown+4)/2;
//        m*n = yellow + brown;

        for(int i=3;i<=(brown+4)/4;i++){ // n
            for(int j=3;j<=(brown+4)/2-3;j++){ // m
                if(i+j == (brown+4)/2 && i*j==yellow + brown){
                    n=i; m=j;
                }
            }
        }

        answer[0] = m;
        answer[1] = n;

        return answer;
    }

    public static void main(String[] args) {
        P_42842 p = new P_42842();
        int[] ans1 = p.solution(10,2);
        int[] ans2 = p.solution(8, 1);
        int[] ans3 = p.solution(24, 24);
        System.out.println("["+ans1[0]+", "+ans1[1]+"]");
        System.out.println("["+ans2[0]+", "+ans2[1]+"]");
        System.out.println("["+ans3[0]+", "+ans3[1]+"]");

    }
}
