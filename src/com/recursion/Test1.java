package src.com.recursion;

public class Test1 {

    //https://mp.weixin.qq.com/s/mJ_jZZoak7uhItNgnfmZvQ

    // 反转链表
    public static void main(String[] args) {
        Node firstNode = generateNodeList(4);
        printNodeList(firstNode);

        firstNode = reverseNode(firstNode);
        printNodeList(firstNode);
    }

    public static Node reverseNode(Node head) {
        if (head == null || head.next == null) return head;

        Node newHead = reverseNode(head.next);

        Node t1 = head.next;
        t1.next = head;
        head.next = null;

        return newHead;
    }

    public static Node generateNodeList(int value) {
        Node preNode = null;
        Node firstNode = null;
        for (int i = 1; i <= value; i++) {
            Node node = null;
            if (preNode != null) {
                node = new Node(i);
                preNode.next = node;
            } else {
                node = new Node(i);
                firstNode = node;
            }
            preNode = node;
        }
        return firstNode;
    }

    public static void printNodeList(Node node) {
        while (node != null) {
            System.out.println("-----------" + node.data);
            node = node.next;
        }
    }
}
