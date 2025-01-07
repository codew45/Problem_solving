import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] parents;

    static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            parents[rootY] = rootX;
        }
    }

    static int find(int x) {
        if (parents[x] == x) return x;
        return parents[x] = find(parents[x]); // 경로 압축
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int truthCnt = Integer.parseInt(st.nextToken());

        ArrayList<Integer> truth = new ArrayList<>();
        for (int i = 0; i < truthCnt; i++) {
            truth.add(Integer.parseInt(st.nextToken()));
        }

        parents = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }

        ArrayList<ArrayList<Integer>> party = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            party.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            for (int j = 0; j < n; j++) {
                int person = Integer.parseInt(st.nextToken());
                party.get(i).add(person);
            }

            for (int j = 1; j < party.get(i).size(); j++) {
                union(party.get(i).get(0), party.get(i).get(j));
            }
        }

        if (!truth.isEmpty()) {
            int root = find(truth.get(0)); // 첫 번째 진실을 아는 사람의 루트를 기준으로
            for (int person : truth) {
                union(root, person); // 모든 진실을 아는 사람들을 하나의 그룹으로 연결
            }
        }

        int answer = 0;
        for (ArrayList<Integer> p : party) {
            boolean canLie = true;
            for (int person : p) {
                if (truthCnt > 0 && find(person) == find(truth.get(0))) {
                    canLie = false; // 진실을 아는 그룹에 속한 사람이 있으면 거짓말 불가능
                    break;
                }
            }
            if (canLie) answer++;
        }

        System.out.println(answer);
    }
}
