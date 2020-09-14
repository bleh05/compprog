#include <bits/stdc++.h>
using namespace std;

long long n, m, k;

int main() {
	int t;
	cin >> t;
	while(t-- > 0) {
		cin >> n >> m >> k;
		long long need = k * m + k;
		cout << (need - 1 + n - 2) / (n-1) + k << endl;
	}
}