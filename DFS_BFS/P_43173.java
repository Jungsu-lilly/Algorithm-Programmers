package DFS_BFS;
import java.util.*;

// 단어 변환
public class P_43173 {
    static int ans = Integer.MAX_VALUE;
    static String T = "";
    static String[] W;
    public int solution(String begin, String target, String[] words) {
        T = target;
        W = new String[words.length];
        for(int i=0;i<words.length;i++)
            W[i] = words[i];
        ArrayList<String> list = new ArrayList<>();
        list.add(begin);
        dfs(begin, list, 0);
        if(ans==Integer.MAX_VALUE) return 0;
        return ans;
    }

    public void dfs(String temp, ArrayList<String> list, int count){
        if(temp.equals(T)) {
            System.out.println("일치. count: " + count);
            ans = Math.min(count,ans);
            list.remove(temp);
            return;
        }

        for(int i=0;i<W.length;i++){
            String s = W[i];
            if(list.contains((String)s)) continue;

            for(int j=0;j<s.length();j++){
                int len = s.length();
                if(s.charAt(j) != temp.charAt(j)){
                    if(j==0){
                        if(s.substring(j+1,len).equals(temp.substring(j+1,len))){
                            list.add(s);
                            dfs(s,list, count+1);
                        }
                    }
                    else if((s.substring(0,j)+s.substring(j+1,s.length())).equals(temp.substring(0,j)+temp.substring(j+1,s.length()))){
                        list.add(s);
                        dfs(s,list,count+1);
                    }
                }
            }
        }
        list.remove(temp);
    }

    public static void main(String[] args) {
        P_43173 p = new P_43173();
        int solution = p.solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log"});
        System.out.println(solution);
    }
}
