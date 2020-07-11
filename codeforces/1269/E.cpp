#define _CRT_SECURE_NO_WARNINGS 1

#include <stdio.h>
#include <math.h>
#include <string.h>
#include <map>
#include <set>
#include <vector>
#include <algorithm>
#include <utility>
#include <cassert>
#include <limits.h>
#include <unordered_map>
#include <unordered_set>
#include <functional>
#include <numeric>
#include <iostream>
#include <iomanip>
#include <queue>
#include <array>

using namespace std;

using vi = vector<int>;
using pii = pair<int, int>;
using vii = vector<pii>;
using ll = long long;

int solve();

int main(int argc, char* argv[])
{
#ifndef ONLINE_JUDGE
	freopen("input.txt", "r", stdin);
	freopen("output.txt", "w", stdout);
#endif //ONLINE_JUDGE
	::std::ios::sync_with_stdio(false);
	::std::cin.tie(0);
	::std::cout.tie(0);

	int t = 1;
	//cin >> t;

	while (t--) {
		solve();
	}
}

struct Fenwick
{
    vector<int> b;
    int n;
    Fenwick(int n):n( n ) 
    {
        b.resize(n + 1);
    }
    void add(int i) {
        while (i > 0 && i <= n)
        {
            b[i]++;
            i += i & (-i);
        }
    }
    int rank(int i) const
    {
        int res = 0;
        for (; i > 0; i -= i & (-i))res += b[i];
        return res;
    }
    
    int at_rank(int k) const 
    {
        int l = 0, r = n + 1;
        
        while (l < r) 
        {
            int m = (l + r) / 2;
            if (k <= rank(m))
                r = m;
            else
                l = m + 1;
        }
        return l;
    }

};
int solve() 
{
    int n; 
        
    cin >> n; 
        
    vector<int>pos(n); 
        
    Fenwick f(n + 1);
        
    for (int i = 0; i < n; i++) 
    { 
        int p;
        cin >> p; 
        pos[p - 1] = i + 1; 
    }

    long long a = 0; 
        
    for (int i = 0; i < n; i++) 
    {
        int p = pos[i];
        f.add(p);
        int r = f.rank(p);
        int m = i / 2 + 1;
        if (r <= m) {
            m += i & 1; 
            a += f.at_rank(m) - p - m + i - r + 2; 
        }
        else 
        { 
            a += p - f.at_rank(m) + m - r; 
        }
        cout << a << ' ';
    }
     
	return 0;
}
