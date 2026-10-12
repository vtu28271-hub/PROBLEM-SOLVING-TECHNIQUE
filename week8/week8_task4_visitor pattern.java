import java.util.ArrayList;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import java.util.ArrayList;
import java.util.Scanner;

enum Color {
    RED, GREEN
}

abstract class Tree {

    private int value;
    private Color color;
    private int depth;

    public Tree(int value, Color color, int depth) {
        this.value = value;
        this.color = color;
        this.depth = depth;
    }

    public int getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    public int getDepth() {
        return depth;
    }

    public abstract void accept(TreeVis visitor);
}

class TreeNode extends Tree {

    private ArrayList<Tree> children = new ArrayList<>();

    public TreeNode(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitNode(this);

        for (Tree child : children) {
            child.accept(visitor);
        }
    }

    public void addChild(Tree child) {
        children.add(child);
    }
}

class TreeLeaf extends Tree {

    public TreeLeaf(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitLeaf(this);
    }
}

abstract class TreeVis
{
    public abstract int getResult();
    public abstract void visitNode(TreeNode node);
    public abstract void visitLeaf(TreeLeaf leaf);

}

class SumInLeavesVisitor extends TreeVis {

    private int sum = 0;

    public int getResult() {
        return sum;
    }

    public void visitNode(TreeNode node) {
        // We only need leaf values.
    }

    public void visitLeaf(TreeLeaf leaf) {
        sum += leaf.getValue();
    }
}

class ProductOfRedNodesVisitor extends TreeVis {

    private long product = 1;

    public int getResult() {
        return (int) product;
    }

    public void visitNode(TreeNode node) {
        if (node.getColor() == Color.RED) {
            product = (product * node.getValue()) % 1000000007;
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor() == Color.RED) {
            product = (product * leaf.getValue()) % 1000000007;
        }
    }
}

class FancyVisitor extends TreeVis {

    private int evenDepthSum = 0;
    private int greenLeafSum = 0;

    public int getResult() {
        return Math.abs(evenDepthSum - greenLeafSum);
    }

    public void visitNode(TreeNode node) {
        if (node.getDepth() % 2 == 0) {
            evenDepthSum += node.getValue();
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor() == Color.GREEN) {
            greenLeafSum += leaf.getValue();
        }
    }
}

public class Solution {

    public static Tree solve() {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        // Read values
        int[] values = new int[n];

        for (int i = 0; i < n; i++) {
            values[i] = sc.nextInt();
        }

        // Read colors
        Color[] colors = new Color[n];

        for (int i = 0; i < n; i++) {
            int color = sc.nextInt();

            if (color == 0) {
                colors[i] = Color.RED;
            } else {
                colors[i] = Color.GREEN;
            }
        }

        // Build adjacency list
        ArrayList<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // Read edges
        for (int i = 0; i < n - 1; i++) {

            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;

            graph[u].add(v);
            graph[v].add(u);
        }

        // Node 1 is the root.
        // We use index 0 because arrays are zero-based.
        return buildTree(0, -1, 0, values, colors, graph);
    }

    private static Tree buildTree(
            int current,
            int parent,
            int depth,
            int[] values,
            Color[] colors,
            ArrayList<Integer>[] graph) {

        // Find children
        ArrayList<Integer> children = new ArrayList<>();

        for (int next : graph[current]) {
            if (next != parent) {
                children.add(next);
            }
        }

        // No children => leaf
        if (children.isEmpty()) {
            return new TreeLeaf(
                values[current],
                colors[current],
                depth
            );
        }

        // Has children => node
        TreeNode node = new TreeNode(
            values[current],
            colors[current],
            depth
        );

        for (int child : children) {

            Tree childTree = buildTree(
                child,
                current,
                depth + 1,
                values,
                colors,
                graph
            );

            node.addChild(childTree);
        }

        return node;
    }

    


    public static void main(String[] args) {
      	Tree root = solve();
		SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
      	ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
      	FancyVisitor vis3 = new FancyVisitor();

      	root.accept(vis1);
      	root.accept(vis2);
      	root.accept(vis3);

      	int res1 = vis1.getResult();
      	int res2 = vis2.getResult();
      	int res3 = vis3.getResult();

      	System.out.println(res1);
     	System.out.println(res2);
    	System.out.println(res3);
	}
}