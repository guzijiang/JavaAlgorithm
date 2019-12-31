package src.com.list;

import src.com.recursion.Node;

public class Test2 {

    //https://mp.weixin.qq.com/s/NuxffdWZlzK2tWsTUIXfZQ

    //单链表有环
    public static void main(String[] args) {

    }

    public static Node detectCycle(Node head) {
        Node slow = head, fast = head;

        //找出相遇点
        while (true) {
            if (fast == null || fast.next == null) return null;

            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                break;
            }
        }

        //找出环的入口
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}
