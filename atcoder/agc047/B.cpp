#include <bits/stdc++.h>
using namespace std;
const int mx = 2e5+3;
int n;
string arr[mx];

int cnt[26];
bool compare(string &s1,string &s2) 
{ 
    return s1.size() > s2.size(); 
}
int main() {
	cin >> n;
	for(int i = 0; i < n; i++) {
		cin >> arr[i];
		reverse(begin(arr[i]), end(arr[i]));
	}
	map<long long, vector<int>> hashv = {};
	long long sum = 0;
	for(int i = 0; i < n; i++) {
		cin >> arr[i];
	}
	sort(arr, arr+n, compare);
	for(int i = 0; i < n; i++) {
		int freq[26];
		for(int j = 0; j < 26; j++) {
			freq[j] = 0;
		}
		int k = arr[i].size();
		for(int j = 0; j < k; j++) {
			freq[arr[i][j] - 'a']++;
		}
		for(int j = 0; j < 26; j++) {
			if(freq[j] > 0) {
				cnt[j]++;
			}
		}
		long long hash = 0;
		long long hash2 = 0;
		for(int j = 0; j < k; j++) {
			freq[arr[i][j] - 'a']--;
			if(j == k - 1) {
				if(j == 0) {
					sum += cnt[arr[i][j]-'a'] - 1;
				}
				else if(hashv.count(hash * 1000000020 + hash2)) {
					sum += hashv[hash * 1000000020 + hash2][arr[i][j]-'a'] - 1;
				}
			}
			hash *= 61;
			hash += arr[i][j] - 'a' + 1;
			hash %= 1000000009;
			hash2 *= 31;
			hash2 += arr[i][j] - 'a' + 1;
			hash2 %= 1000000009;
			long long chash = hash * 1000000020 + hash2;
			if(!hashv.count(chash)) {
				vector<int> ksd(26, 0);
				hashv[chash] = ksd;
			}
			for(int z = 0; z < 26; z++) {
				hashv[chash][z] += min(1, freq[z]);
			}
		}
		
	}
	cout << sum << endl;
}
