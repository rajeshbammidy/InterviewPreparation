package TopicWiseSolutions.BST;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TopicWiseSolutions.Strings.BST|FloorInBst| on Jul,2020
 *  
 * Happy Coding :)
 **/

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
    }
}

public class FloorInBst {
    int floor(Node root, int key) {
        int res = -1;
        while (root != null) {

            if (root.data == key) return key;
            if (key > root.data) {
                res = root.data;
                root = root.right;
            } else {
                root = root.left;
            }

        }
        return res;
    }
}
