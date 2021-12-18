package others;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class TwoButtons {

    static int twoButtons(int current, int goal) {
        Queue<Node> waiting = new ArrayDeque<>(Collections.singletonList(new Node(current, 0)));
        Set<Integer> over = new HashSet<>();
        while (!waiting.isEmpty()) {
            Node wait = waiting.remove();
            if (wait.value == goal) {
                return wait.trans;
            }
            Collection<Node> transforms = wait.transform(goal).stream()
                    .filter(trans -> !over.contains(trans.value))
                    .collect(Collectors.toSet());
            transforms.forEach(tran -> over.add(tran.value));
            waiting.addAll(transforms);

        }
        return -1;
    }

    static class Node {
        int value;
        int trans;

        Node(int value, int trans) {
            this.value = value;
            this.trans = trans;
        }

        Collection<Node> transform(int goal) {
            ArrayList<Node> addNodes = new ArrayList<>();
            if (value - 1 > 0) {
                addNodes.add(new Node(value - 1, trans + 1));
            }
            if (value > 0 && value < goal) {
                addNodes.add(new Node(value * 2, trans + 1));
            }
            return addNodes;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int current = scanner.nextInt();
        int goal = scanner.nextInt();
        System.out.println(twoButtons(current, goal));
    }
}
