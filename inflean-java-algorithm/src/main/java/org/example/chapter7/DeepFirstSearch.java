package org.example.chapter7;

public class DeepFirstSearch {

    public static void main(String[] args) {
        DeepFirstSearch d = new DeepFirstSearch();
        n = 3;
        ch = new int[n+1];
        d.dfs(1);
    }

    static int n;
    static int[] ch;
    public void dfs (int l) {
        if (l == n + 1) {
            String tmp = "";
            for (int i = 1; i <= n; i++) {
                if (ch[i] == 1) {
                    tmp += i + " ";
                }
            }
            if (tmp.length() > 0) {
                System.out.println(tmp);
            }
            return;
        } else {
            ch[l] = 1;
            dfs(l+1);
            ch[l] = 0;
            dfs(l+1);
        }
    }

}
