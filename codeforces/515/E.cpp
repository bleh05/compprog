#include <stdio.h>
#include <math.h>
#include <algorithm>
using namespace std;
#define RMQN 200010
struct RMQ{
    long long c[RMQN];
    int a[RMQN][20][2];
    int f(int x, int y){ return c[x]>c[y]?x:y; }
    void build(int n){
        for (int i = 0; i < n; i++){ a[i][0][0] = i; a[i][0][1] = n; }
        for (int j = 1; (1<<j) <= n; j++)
            for (int i = 0; i + (1<<j) - 1 < n; i++) {
                int x = a[i][j - 1][0], y = a[i + (1<<(j - 1))][j - 1][0];
                if (f(x, y) == x) {
                    a[i][j][0] = x;
                    x = a[i][j - 1][1];
                } else {
                    a[i][j][0] = y;
                    y = a[i + (1<<(j - 1))][j - 1][1];
                }
                a[i][j][1] = f(x, y);
            }
    }
    int query(int x, int y){
        int k = log2(y - x + 1.0);
        return f(a[x][k][0], a[y - (1<<k) + 1][k][0]);
    }
    int query2(int x, int y) {
        int k = log2(y - x + 1.0);
        int p = a[x][k][0], q = a[y - (1<<k) + 1][k][0];
        if (p == q) {
            return f(a[x][k][1], a[y - (1<<k) + 1][k][1]);
        }
        if (f(p, q) == p) {
            p = a[x][k][1];
        } else {
            q = a[y - (1<<k) + 1][k][1];
        }
        return f(p, q);
    }
}p, q;
long long d[200010];
int h[200010];
int main(){
    int n, m, i, x, y, l, r;
    scanf("%d%d", &n, &m);
    for (i = 1; i <= n; i++) {
        scanf("%d", &x);
        d[i] = d[n + i] = x;
    }
    for (i = 1; i < n + n; i++) d[i] += d[i - 1];
    for (i = 0; i < n; i++) {
        scanf("%d", &h[i]); h[n + i] += h[i];
    }
    for (i = 0; i < n + n; i++) {
        p.c[i] = h[i] + h[i] + d[i];
        q.c[i] = h[i] + h[i] - d[i];
    }
    p.c[n + n] = q.c[n + n] = -(1ll<<60);
    p.build(n + n); q.build(n + n);
    while (m--) {
        scanf("%d%d", &x, &y);
        if (x <= y) {
            l = y; r = x + n - 2;
        } else {
            l = y + n; r = x + n - 2;
        }
        x = p.query(l, r); y = q.query(l, r);
        if (x != y) printf("%I64d\n", p.c[x] + q.c[y]);
        else {
            long long ans = p.c[x] + q.c[q.query2(l, r)];
            ans = max(ans, p.c[p.query2(l, r)] + q.c[y]);
            printf("%I64d\n", ans);
        }
    }
    return 0;
}
