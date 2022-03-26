import java.io.*;
import java.util.*;
public class B_4195 {

    // 노드의 부모노드 찾기
    public static int getParent(int[] parent, int x){
        if(parent[x] == x)  return x;
        return parent[x] = getParent(parent, parent[x]);
    }

    // 부모노드 합치기 (연결시키기)
    public static void unionParent(int[] parent, int a, int b){
        a = getParent(parent, a);
        b = getParent(parent, b);
        if(a < b)
            parent[b] = a;
        else
            parent[a] = b;
    }

    public static void unionLevel(int[] parent, int[]level, int a, int b){
        if(parent[a] == parent[b]){
            if(a<b) level[parent[a]] += level[b];
            else level[parent[b]] += level[a];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken(br.readLine()));
        int n = Integer.parseInt(st.nextToken(br.readLine()));
        while(T-- > 0){
            int[] parent = new int[2*n];
            int[] level = new int[2*n];

            HashMap<String, Integer> map = new HashMap<>();
            for(int i=0;i<n;i++){

                String f1 = st.nextToken();
                String f2 = st.nextToken();

                if(!map.containsKey(f1)){
                    map.put(f1, map.size());
                    parent[map.get(f1)] = map.get(f1);
                    level[map.get(f1)] = 1;
                }
                if(!map.containsKey(f2)){
                    map.put(f2, map.size());
                    parent[map.get(f2)] = map.get(f2);
                    level[map.get(f2)] = 1;
                }

                unionParent(parent, map.get(f1), map.get(f2));
                unionLevel(parent, level, map.get(f1), map.get(f2));
            }

            for(int i=0;i<map.size();i++) {

            }
        }
    }
}
