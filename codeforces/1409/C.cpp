#include <bits/stdc++.h>
using namespace std;

typedef long long ll;
int main() {
	int t; cin >> t;
	while(t--> 0) {
		int n, x, y;
		cin >> n >> x >> y;
		if(n == 2) {
			cout << x << " " << y << "\n";
			continue;
		}
		x--;
		y--;
		int mx = 1<<31-1;
		int ind = 0;
		for(int i = 1; i <= 50; i++) {
			if(x % i == y % i && y-x <= n*i-i) {
				if(mx > max(i*n-i+y%i, y)) {
					mx = max(i*n-i+y%i, y);
					ind = i;
				}
			}
		}
		for(int j = mx, k = 0; k < n; k++, j -= ind) {
			cout << j+1 << " ";
		}
		cout << "\n";
	}
}
