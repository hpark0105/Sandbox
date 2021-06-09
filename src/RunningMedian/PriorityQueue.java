package RunningMedian;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

class RunningMedian {
/*
6
12
4
5
3
8
7
---
12
8.0
5
4.5
5
6.0
 */
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {

      int n = in.nextInt();

      PriorityQueue<Integer> minHeap = new PriorityQueue<>();
      PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

      for (int i = 0; i < n; ++i) {
        int v = in.nextInt();
        if (maxHeap.isEmpty() || (v < maxHeap.peek())) {
          maxHeap.add(v);
        } else {
          minHeap.add(v);
        }

        if (maxHeap.size() > (minHeap.size() + 1)) {
          minHeap.add(maxHeap.poll());
        }

        if (minHeap.size() > (maxHeap.size() + 1)) {
          maxHeap.add(minHeap.poll());
        }

        if (maxHeap.size() > minHeap.size()) {
          System.out.println(maxHeap.peek());
        } else if (minHeap.size() > maxHeap.size()) {
          System.out.println(minHeap.peek());
        } else {
          System.out.println(0.5 * (minHeap.peek() + maxHeap.peek()));
        }
      }
    }
  }
}
