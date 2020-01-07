class Node:
    def __init__(self, data):
        self.data = data
        self.prev = None
        self.next = None

    def __str__(self):
        return "\n\nNode Value: %d" % self.data


class LinkedList:
    head = None
    
    @staticmethod
    def create(self):
        data = int(input("\nEnter the data for the node:\n"))
        node = Node(data)
        print("\nThe data {} is successfully pushed to the linked list!\n".format(data))
        return node

    def push(self):
        node = self.create(self)
        if self.head is None:
            self.head = node
        else:
            node.next = self.head
            self.head.prev = node
            self.head = node

    def pop(self):
        if self.head is None:
            print("\nThe linked list is empty!\n")
        else:
            print("\n\nThe element %d is popped from the linked list\n\n" %
                  self.head.data)
            nextHead = self.head.next
            self.head.prev = None
            self.head.next = None
            self.head = None
            self.head = nextHead
            self.head.prev = None

    def display(self):
        if self.head is None:
            print("\nThe linked list is empty!\n")
        else:
            print("\nThe linked list is displayed: \n")
            headCopy = self.head
            headNewCopy = self.head
            while headCopy is not None:
                print(headCopy)
                headCopy = headCopy.next
            self.head = headNewCopy

    def reverseDisplay(self):
        if self.head is None:
            print("\nThe linked list is empty!\n")
        else:
            print("\nThe linked list is displayed in the reverse order: \n")
            prepointer = self.head
            headCopy = self.head
            headNewCopy = self.head
            while headCopy is not None:
                prepointer = headCopy
                headCopy = headCopy.next
            headCopy = prepointer
            while headCopy is not None:
                print(headCopy)
                headCopy = headCopy.prev
            self.head = headNewCopy


ch = int(input(
    "\n\nEnter choice:\n1.Push\n2.Pop\n3.Display\n4.Reverse Display\n5.Exit\n\n"))
linkedList = LinkedList()
while ch != 5:
    if ch == 1:
        linkedList.push()
    elif ch == 2:
        linkedList.pop()
    elif ch == 3:
        linkedList.display()
    elif ch == 4:
        linkedList.reverseDisplay()
    elif ch == 5:
        exit(31)
    ch = int(input(
        "\nEnter choice:\n1.Push\n2.Pop\n3.Display\n4.Reverse Display\n5.Exit\n\n"))
