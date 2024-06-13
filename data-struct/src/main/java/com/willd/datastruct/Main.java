package com.willd.datastruct;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        /*
        Stack (FIFO)
        1. push
        2. pop
        3. peek
        4. isEmpty
        5. search
         */
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.pop();

        stack.peek();
        boolean isEmpty =stack.isEmpty();

        //search: 스택에서 주어진 요소의 위치를 반환한다. 스택의 맨 위 요소가 1번 위치에 해당한다.
        stack.search(1);

        /*
        Queue (LILO)
        1. offer
        2. poll
        3. peek
        4. isEmpty
         */
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(1);
        queue.offer(2);
        queue.offer(3);

        int peek = queue.peek();
        int poll = queue.poll();

        boolean isEmpty2 = queue.isEmpty();

        /*
        ArrayDeque
        Deque = Stack (FIFO) + Queue (LILO)
        1. addFirst
        2. addLast
        3. removeFirst
        4. removeLast
        5. peekFirst
        6. peekLast
        7. isEmpty
         */

        Deque<Integer> deque = new ArrayDeque<>();

        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);

        deque.addLast(4);
        deque.addLast(5);
        deque.addLast(6);

        int first = deque.removeFirst();
        int last = deque.removeLast();

        int firstPeek = deque.peekFirst();
        int lastPeek = deque.peekLast();
    }
}
