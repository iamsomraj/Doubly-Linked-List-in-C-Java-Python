import java.util.*;

class Node {
  int data;
  Node next;
  Node prev;

  Node(int data) {
    this.data = data;
    this.next = null;
    this.prev = null;
  }

  @Override
  public String toString() {
    return "\n\nNode Value: " + this.data;
  }
}

class LinkedList {

  Node head = null;

  public static Node create() {
    Scanner sc = new Scanner(System.in);
    System.out.println("\nEnter the data for the node:\n");
    int data = sc.nextInt();
    Node node = new Node(data);
    System.out.println("\n\nThe node with the " + data + " is successfully pushed to list!");
    return node;
  }

  public void push() {
    Node node = create();
    if (this.head == null) {
      this.head = node;
    } else {
      node.next = this.head;
      this.head.prev = node;
      this.head = node;
    }

  }

  public void pop() {
    if (this.head == null) {
      System.out.println("The linked list is empty!");
    } else {
      System.out.printf("\nThe data %d is popped from the list\n", this.head.data);
      Node nextHead = this.head.next;
      this.head.prev = null;
      this.head.next = null;
      this.head = null;
      this.head = nextHead;
      this.head.prev = null;
    }
  }

  public void display() {
    if (this.head == null) {
      System.out.println("The linked list is empty!");
    } else {
      System.out.printf("\nThe linked list is displayed : \n\n");
      Node pointer = this.head;
      Node headCopy = this.head;
      while (pointer != null) {
        System.out.println(pointer);
        pointer = pointer.next;
      }
      this.head = headCopy;
    }
  }

  public void reverseDisplay() {
    if (this.head == null) {
      System.out.println("The linked list is empty!");
    } else {
      Node pointer = this.head;
      Node headCopy = this.head;
      Node prepointer = null;
      while (pointer != null) {
        prepointer = pointer;
        pointer = pointer.next;
      }
      pointer = prepointer;
      System.out.printf("\nThe linked list is displayed in reverse order : \n\n");
      while (pointer != null) {
        System.out.println(pointer);
        pointer = pointer.prev;
      }
      this.head = headCopy;
    }
  }

}

/**
 * App
 */
public class App {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    LinkedList linkedList = new LinkedList();
    int ch;
    do {
      System.out.println("\nEnter choice:\n1.Push\n2.Pop\n3.Display\n4.Reverse Display\n5.Exit\n");
      ch = sc.nextInt();
      switch (ch) {
      case 1:
        linkedList.push();
        break;
      case 2:
        linkedList.pop();
        break;
      case 3:
        linkedList.display();
        break;
      case 4:
        linkedList.reverseDisplay();
        break;
      case 5:
        ch = 5;
        break;
      default:
        System.out.println("\nThe user input is wrong!\n");
        break;
      }
    } while (ch != 5);
  }
}