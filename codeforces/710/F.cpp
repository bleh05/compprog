#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

const int N = 4 * 300000;
const int k = 26;
const int lg = 20;
string a[N];
struct node {
  char c;
  int parent, link, output;
  int next[k], autom[k];
  int cnt;

  node(char c = -1, int parent = -1, int link = -1, int output = -1,
       int cnt = -1)
      : c(c), parent(parent), link(link), output(output), cnt(cnt) {
    memset(next, -1, sizeof next);
    memset(autom, -1, sizeof autom);
  }
};
node trie[N];

vector<int> ids;
inline int get_ind() {
  int ans = ids.back();
  ids.pop_back();
  trie[ans] = node();
  return ans;
}
inline void return_ind(int ind) { ids.push_back(ind); }

inline int add(const string& s, int root) {
  int v = root;
  for (int i = 0; i < s.size(); i++) {
    if (trie[v].next[s[i] - 'a'] == -1) {
      int ind = get_ind();
      trie[v].next[s[i] - 'a'] = ind;
      trie[ind] = node(s[i], v, -1, -1);
    }
    v = trie[v].next[s[i] - 'a'];
  }
  trie[v].output = v;
  return v;
}

int link(int v, int root) {
  int& ans = trie[v].link;
  if (ans != -1) return ans;
  if (v == root || trie[v].parent == root) return ans = root;
  char c = trie[v].c;
  int vv = link(trie[v].parent, root);
  while (vv != root && trie[vv].next[c - 'a'] == -1) vv = link(vv, root);
  return ans = (trie[vv].next[c - 'a'] == -1 ? root : trie[vv].next[c - 'a']);
}

int output(int v, int root) {
  int& ans = trie[v].output;
  if (ans != -1) return ans;
  return ans = (v == root ? root : output(link(v, root), root));
}

int cnt(int v, int root) {
  int& ans = trie[v].cnt;
  if (ans != -1) return ans;
  v = output(v, root);
  if (v == root) return ans = 0;
  return ans = 1 + cnt(link(v, root), root);
}
int next(int v, char c, int root) {
  int& ans = trie[v].autom[c - 'a'];
  if (ans != -1) return ans;
  if (trie[v].next[c - 'a'] != -1) return ans = trie[v].next[c - 'a'];
  return ans = (v == root ? root : next(link(v, root), c, root));
}
void dfs_clear(int v) {
  for (int i = 0; i < k; i++) {
    if (trie[v].next[i] != -1) {
      dfs_clear(trie[v].next[i]);
    }
  }
  return_ind(v);
}
int build(int root, const vector<int>& ids) {
  dfs_clear(root);
  root = get_ind();
  for (int i = 0; i < ids.size(); i++) {
    add(a[ids[i]], root);
  }
  return root;
}
int calc(int root, int ind) {
  int ans = 0;
  const string& s = a[ind];
  int v = root;
  for (int i = 0; i < s.size(); i++) {
    v = next(v, s[i], root);
    ans += cnt(v, root);
  }
  return ans;
}

struct dyna {
  int root[lg];
  vector<int> block[lg];
  void clear() {
    for (int i = 0; i < lg; i++) {
      block[i].clear();
      root[i] = get_ind();
    }
  }

  void insert(int i) {
    vector<int> cur(1, i);
    for (int i = 0; i < lg; i++) {
      if (block[i].size() == cur.size()) {
        for (int x : block[i]) {
          cur.insert(cur.end(), x);
        }
        block[i].clear();
        root[i] = build(root[i], block[i]);
      } else {
        block[i] = cur;
        root[i] = build(root[i], block[i]);
        break;
      }
    }
  }

  ll calc2(int ind) {
    ll ans = 0;
    for (int i = 0; i < lg; i++) {
      ans += calc(root[i], ind);
    }
    return ans;
  }
};

dyna z1, z2;

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  ids.clear();
  for (int i = 0; i < N; i++) {
    ids.push_back(i);
  }
  z1.clear();
  z2.clear();
  int m;
  cin >> m;
  for (int i = 0; i < m; i++) {
    int type;
    cin >> type >> a[i];
    if (type == 1) {
      z1.insert(i);
    } else if (type == 2) {
      z2.insert(i);
    } else if (type == 3) {
      ll ans = z1.calc2(i) - z2.calc2(i);
      cout << ans << endl;
    }
  }
}