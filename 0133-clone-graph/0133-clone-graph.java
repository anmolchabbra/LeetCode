/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Map<Node, Node> nodesMap = new HashMap<>();
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        //base
        if (nodesMap.containsKey(node)) {
            return nodesMap.get(node);
        }
        
        Node newNode = new Node(node.val, new ArrayList<>());
        
        //add mapping
        nodesMap.put(node, newNode);
        
        //recursion call
        for (Node n : node.neighbors) {
            newNode.neighbors.add(cloneGraph(n));
        }
        return newNode;
    }
}