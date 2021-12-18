package search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class FrogNode implements Node {
    private FrogNode mother;
    private int[] frogs;

    FrogNode(int[] frogs) {
        this(frogs, null);
    }

    private FrogNode(int[] frogs, FrogNode mother) {
        this.frogs = frogs;
        this.mother = mother;
    }

    public List<Node> getChildren() {
        List<Node> ans = new ArrayList<>();
        for (int i = 0; i < frogs.length; i++) {
            if (frogs[i] == 1) {
                if (i + 1 < frogs.length && frogs[i + 1] == 0) {
                    int[] cpFrogs = frogs.clone();
                    cpFrogs[i] = 0;
                    cpFrogs[i + 1] = 1;
                    ans.add(new FrogNode(cpFrogs, this));
                }

                if (i + 2 < frogs.length && frogs[i + 2] == 0) {
                    int[] cpFrogs = frogs.clone();
                    cpFrogs[i] = 0;
                    cpFrogs[i + 2] = 1;
                    ans.add(new FrogNode(cpFrogs, this));
                }
            }

            if (frogs[i] == 2) {
                if (i - 1 >= 0 && frogs[i - 1] == 0) {
                    int[] cpFrogs = frogs.clone();
                    cpFrogs[i] = 0;
                    cpFrogs[i - 1] = 2;
                    ans.add(new FrogNode(cpFrogs, this));
                }

                if (i - 2 >= 0 && frogs[i - 2] == 0) {
                    int[] cpFrogs = frogs.clone();
                    cpFrogs[i] = 0;
                    cpFrogs[i - 2] = 2;
                    ans.add(new FrogNode(cpFrogs, this));
                }
            }
        }

        return ans;
    }

    public boolean isFullFill() {
        int[] goal = new int[]{2, 2, 2, 0, 1, 1, 1};
        return Arrays.equals(frogs, goal);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(frogs);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof FrogNode)) {
            return false;
        }
        FrogNode cpFrogNode = (FrogNode) obj;
        return Arrays.equals(cpFrogNode.frogs, frogs);
    }

    @Override
    public String toString() {
        if (mother == null) {
            return Arrays.toString(frogs);
        }
        return mother.toString() + "\n" + Arrays.toString(frogs);
    }
}
