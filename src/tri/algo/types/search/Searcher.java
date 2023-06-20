package tri.algo.types.search;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Searcher {

    private Node init;

    Searcher(Node init) {
        this.init = init;
    }

    Node search() {
        List<Node> waiting = new ArrayList<>();
        waiting.add(init);
        Set<Node> over = new HashSet<>();

        while (!waiting.isEmpty()) {
            Node working = waiting.remove(waiting.size() - 1);

            if (working.isFullFill()) {
                return working;
            }

            List<Node> workingChildren = working.getChildren();
            workingChildren.removeIf(over::contains);
            waiting.addAll(workingChildren);
            over.add(working);
        }

        return null;
    }
}
