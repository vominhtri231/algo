package tri.algo.types.search;

import java.util.List;

public interface Node {

    List<Node> getChildren();

    boolean isFullFill();
}
