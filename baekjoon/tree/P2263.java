package baekjoon.tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2263 {

    static int n, idx;
    static int[] in, post, pre;

    public static void main(String[] args) throws Exception {
        preProcess();
        getPreOrder(0, n - 1, 0, n - 1);
        postProcess();
    }

    static void preProcess() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        in = new int[n];
        post = new int[n];
        pre = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            in[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            post[i] = Integer.parseInt(st.nextToken());

        br.close();
    }

    static void getPreOrder(int is, int ie, int ps, int pe) {

        if (is <= ie && ps <= pe) {
            pre[idx++] = post[pe];

            int pos = is;
            for (int i = is; i <= ie; i++) {
                if (in[i] == post[pe]) {
                    pos = i;
                    break;
                }
            }

            getPreOrder(is, pos - 1, ps, ps + pos - is - 1);
            getPreOrder(pos + 1, ie, ps + pos - is, pe - 1);
        }
    }

    static void postProcess() {
        StringBuilder sb = new StringBuilder();
        for (int e : pre)
            sb.append(e).append(' ');

        System.out.println(sb);
    }

}