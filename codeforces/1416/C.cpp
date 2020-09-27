
// Problem : C. XOR Inverse
// Contest : Codeforces - Codeforces Round #673 (Div. 1)
// URL : https://codeforces.com/contest/1416/problem/C
// Memory Limit : 512 MB
// Time Limit : 2000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
int elmch[34];
ll ninv[34];
ll ninvs[34];
void tn(int bit, vector<int>& arr) {
	int k = 0;
	int ks = 0;
	vector<int> no = {};
	vector<int> ye = {};
	for(int i = (int)arr.size() - 1; i >= 0; i--) {
		if(arr[i] & (1<<bit)) {
			ninv[bit] += k;
			ye.push_back(arr[i]);
			ks++;
		}
		else {
			no.push_back(arr[i]);
			ninvs[bit] += ks;
			k += 1;
		}
	}
	reverse(no.begin(), no.end());
	reverse(ye.begin(), ye.end());
	if(bit > 0) {
		if(no.size() > 1)
		tn(bit - 1, no);
		if(ye.size() > 1)
		tn(bit - 1, ye);
	}
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
	int n;
	cin >> n;
	vector<int> arr;
	for(int i = 0; i < n; i++) {
		int c; cin >> c; arr.push_back(c);
	}
	tn(30, arr);
	int ret = 0;
	ll tinv = 0;
	for(int i = 0; i < 30; i++) {
		if(ninv[i] > ninvs[i]) ret |= (1<<i);
		tinv += min(ninv[i], ninvs[i]);
	}
	cout << tinv << " " << ret << endl;
}