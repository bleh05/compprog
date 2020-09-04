#include <bits/stdc++.h>
using namespace std;

int main() {
	int t; cin >> t;
	while(t--> 0) {
		int n; cin >> n;
		int m; cin >> m;
		cout << (abs(m - n) + 9) / 10 << endl;
	}
}