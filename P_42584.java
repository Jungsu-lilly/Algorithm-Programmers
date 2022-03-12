import java.util.Stack;

public class P_42584 {
    public int[] solution(int[] prices) {
        int len = prices.length;
        int[] ans = new int[len];
        Stack<Integer> S = new Stack<>();
        S.push(0);

        for(int i=1;i<len;i++){
            int temp = prices[i];
            while(!S.isEmpty() && prices[S.peek()] > temp){ // 감소되었다는 뜻
                Integer peek = S.peek();
                ans[peek] = i-peek;
                S.pop();
            }
            // S.peek() <= temp
            S.push(i);
        }

        while(!S.isEmpty()){
            int peek = S.peek();
            ans[peek] = len-1-peek;
            S.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        P_42584 p = new P_42584();
        int prices[] = {3,5,5,4,1};
        int[] ans = p.solution(prices);
        for (int an : ans) {
            System.out.print(an+" ");
        }
    }
}
