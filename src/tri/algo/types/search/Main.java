package tri.algo.types.search;

public class Main {
    public static void main(String[] args) {
        Searcher searcher = new Searcher(new FrogNode(new int[]{1, 1, 1, 0, 2, 2, 2}));

        Node node = searcher.search();
        System.out.println(node);
    }
}
