#include <bits/stdc++.h>
using namespace std;

typedef long long ll;
int main() {
	int t; cin >> t;
	while(t--> 0) {
		ll a, b, x, y, n;
		cin >> a >> b >> x >> y >> n;
		ll tn = n;
		ll ta = a;
		ll tb = b;
		int da = min(n, a-x);
		n -= da;
		a -= da;
		int db = min(n, b-y);
		b -= db;
		n -= db;
		db = min(tn, tb-y);
		tb -= db;
		tn -= db;
		da = min(tn, ta-x);
		tn -= da;
		ta -= da;
		cout << min(a*b, ta*tb) << endl;
	}
}