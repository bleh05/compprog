#include <bits/stdc++.h>
using namespace std;

int main() {
  string str;
  cin >> str;
  int n = str.size();
  int a = str[0] - 'A';
  int b = str[1] - 'A';
  for (int i = 2; i < n; i++) {
    if ((a + b) % 26 != str[i] - 'A') {
      cout << "NO" << endl;
      exit(0);
    }
    a = b;
    b = str[i] - 'A';
  }
  cout << "YES" << endl;
}