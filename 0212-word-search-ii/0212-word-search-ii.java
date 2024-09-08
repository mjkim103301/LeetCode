class Trie {
    HashMap<Character, Trie> child;
    String word;

    public Trie() {
        child = new HashMap<>();
        word = null;
    }
}

class Solution {
    public char[][] map;
    public boolean[][] visited;
    public List<String> found;
    public Trie root;
    public int[][] move = {
            { 0, 1 },
            { 0, -1 },
            { 1, 0 },
            { -1, 0 }
    };

    public List<String> findWords(char[][] board, String[] words) {
        map = new char[board.length][board[0].length];
        visited = new boolean[board.length][board[0].length];
        found = new ArrayList<>();
        root = new Trie();
        for (int i = 0; i < board.length; i++) {
            map[i] = Arrays.copyOf(board[i], board[0].length);
        }

        makeTrie(words);
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[0].length; x++) {
                char ch = board[y][x];
                if (root.child.containsKey(ch)) {
                    dfs(y, x, root.child.get(ch));
                }
            }
        }
        return found;

    }

    public void makeTrie(String[] words) {
        for (String word : words) {
            Trie node = root;
            for (Character ch : word.toCharArray()) {
                if (!node.child.containsKey(ch)) {
                    node.child.put(ch, new Trie());
                }
                node = node.child.get(ch);
            }
            node.word = word;
        }
    }

    public void dfs(int y, int x, Trie parent) {
        // System.out.println("y: " + y + ", x: " + x);
        // System.out.println("Trie word: " + parent.word);
        // System.out.println("Trie child: " + parent.child.keySet());
        visited[y][x] = true;
        if (parent.word != null) {
            found.add(parent.word);
            parent.word = null;
        }

        for (int i = 0; i < 4; i++) {
            int ny = y + move[i][0];
            int nx = x + move[i][1];
            if (ny < 0 || nx < 0 || ny >= map.length || nx >= map[0].length || visited[ny][nx]) {
                continue;
            }
            char ch = map[ny][nx];
            if (!parent.child.containsKey(ch)) {
                continue;
            }

            dfs(ny, nx, parent.child.get(ch));
        }
        visited[y][x] = false;
    }
}