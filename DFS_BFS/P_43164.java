package DFS_BFS;

import java.util.*;
public class P_43164 {
    boolean[] visited;
    ArrayList<String> allRoute;

    public String[] solution(String[][] tickets) {
        String[] answer = {};
        int count = 0;
        allRoute = new ArrayList<>();
        visited = new boolean[tickets.length];
        for(int i=0;i<tickets.length;i++)
            visited[i] = false;

        dfs("ICN", "ICN", tickets, count);
        Collections.sort(allRoute, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        for (String s : allRoute) {
            System.out.println(s);
        }
        System.out.println("===========================");
        answer = allRoute.get(0).split(" ");
        return answer;
    }

    public void dfs(String start, String route, String[][] tickets, int cnt){
        if(cnt== tickets.length){
            allRoute.add(route);
            return;
        }
        for(int i=0;i<tickets.length;i++){
            if(start.equals(tickets[i][0]) && visited[i]==false){
                visited[i] = true;
                dfs(tickets[i][1],route+" "+tickets[i][1],tickets, cnt+1);
                visited[i] = false;
            }
        }
    }


    public static void main(String[] args) {
        P_43164 p = new P_43164();
        String[] ans = p.solution(new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}});
        for (String an : ans) {
            System.out.print(an+" ");
        }
    }
}
