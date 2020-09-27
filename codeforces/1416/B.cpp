
// Problem : B. Make Them Equal
// Contest : Codeforces - Codeforces Round #673 (Div. 1)
// URL : https://codeforces.com/contest/1416/problem/B
// Memory Limit : 256 MB
// Time Limit : 1000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
	int t; cin >> t;
	while(t-- > 0) {
		int n;
		cin >> n;
		ll arr[n];
		ll sum = 0;
		for(int i = 0; i < n; i++) {
			cin >> arr[i];
			sum += arr[i];
		}
		if(sum % n) {
			cout << -1 << endl;
			continue;
		}
		ll avg = (sum / n);
		vector<int> a = {}; 
		vector<int> b = {}; 
		vector<int> c = {}; 
		int ops = 0;
		for(int i = 1; i < n; i++) {
			ops++;
			a.push_back(1);
			b.push_back(i+1);
			c.push_back(arr[0] - (arr[0] + arr[i]) % (i+1));
			int tt = arr[0] - (arr[0] + arr[i]) % (i+1);
			arr[i] += tt;
			arr[0] -= tt;
			ll x = (arr[i]) / (i + 1);
			arr[i] -= max(x, 0ll) * (i+1);
			arr[0] += max(x, 0ll) * (i+1);
			if(x > 0) {
				ops++;
				a.push_back(i+1);
				b.push_back(1);
				c.push_back(x);
			}
		}
		for(int i = 1; i < n; i++) {
			int diff = avg - arr[i];
			if(diff > 0) {
				ops++;
				a.push_back(1);
				b.push_back(i+1);
				c.push_back(diff);
			}
		}
		cout << ops << endl;
		for(int i = 0; i < ops; i++) {
			cout << a[i] << " " << b[i] << " " << c[i] << endl;
		}
		
	}
}