class Solution {
    public Trie trie = new Trie();
    public List<String> found;
    public int[][] move = {
            { 0, 1 },
            { 0, -1 },
            { 1, 0 },
            { -1, 0 }
    };
    public char[][] map;
    public boolean[][] visited;

    public List<String> findWords(char[][] board, String[] words) {
        found = new ArrayList<>();
        makeTrie(words);
        map = board;

        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[0].length; x++) {
                String prefix = board[y][x] + "";
                if (trie.startsWith(prefix)) {
                    visited = new boolean[board.length][board[0].length];
                    findWord(y, x, prefix, trie.node[board[y][x] - 'a']);
                }
            }
        }
        return found;
    }

    public void findWord(int y, int x, String prefix, Trie now) {
        // System.out.println("y: " + y + ", x: " + x);
        // System.out.println("prefix: " + prefix);
        // System.out.println("flag: " + now.flag);
        // System.out.println("trie now: " + Arrays.toString(now.node));
        if (now.flag > 0) {
            found.add(prefix);
            now.flag--;
            //return;
        }
        visited[y][x] = true;
        for (int i = 0; i < 4; i++) {
            int ny = y + move[i][0];
            int nx = x + move[i][1];
            if (ny < 0 || nx < 0 || ny >= map.length || nx >= map[0].length || visited[ny][nx]) {
                continue;
            }
            char ch = map[ny][nx];
            String word = prefix + ch;
            if (!now.startsWith(ch + "")) {
                continue;
            }

            findWord(ny, nx, word, now.node[ch - 'a']);
        }
        visited[y][x]=false;
    }

    public void makeTrie(String[] words) {
        for (String word : words) {
            trie.insert(word);
        }
    }

    public class Trie {
        public Trie[] node;
        public int flag;

        public Trie() {
            node = new Trie[26];
            flag = 0;
        }

        public void insert(String word) {
            Trie trie = this;
            for (char ch : word.toCharArray()) {
                int index = ch - 'a';
                if (trie.node[index] == null) {
                    trie.node[index] = new Trie();
                }
                trie = trie.node[index];
            }
            trie.flag++;
        }

        public boolean search(String word) {
            Trie trie = this;
            for (char ch : word.toCharArray()) {
                int index = ch - 'a';
                if (trie.node[index] == null) {
                    return false;
                }
            }
            return trie.flag > 0;
        }

        public boolean startsWith(String prefix) {
            Trie trie = this;
            for (char ch : prefix.toCharArray()) {
                int index = ch - 'a';
                if (trie.node[index] == null) {
                    return false;
                }
            }
            return true;
        }
    }
}