#include<stdio.h>
#include<stdlib.h>

typedef struct node {
    struct node *prev;
    int data;
    struct node *next;
} Node;

Node *head = NULL;

Node* create();
void push(Node**);
void pop(Node**);
void display(Node*);
void reverseDisplay(Node*);

int main() {
    int ch;
    do {
        printf("\nEnter choice:\n1.Push\n2.Pop\n3.Display\n4.Reverse Display\n5.Exit\n\n");
        scanf("%d",&ch);
        switch(ch) {
        case 1:
            push(&head);
            break;
        case 2:
            pop(&head);
            break;
        case 3:
            display(head);
            break;
        case 4:
            reverseDisplay(head);
            break;
        case 5:
            ch = 5;
            break;
        default:
            printf("\nWrong input from the user!\n");
            break;
        }

    } while(ch!=5);
}

Node* create() {

    int data;
    printf("\nEnter the data for the node: \n");
    scanf("%d",&data);
    Node* new = (Node*)malloc(sizeof(Node));
    new->data = data;
    new->prev = NULL;
    new->next = NULL;
    printf("\nThe node with the data %d is pushed successfully!\n",new->data);
    return new;
}

void push(Node** head) {
    Node* new = create();
    if( *head == NULL ) {
        *head = new;
    } else {
        new->next = *head;
        new->prev = NULL;
        (*head)->prev = new;
        *head = new;
    }
}

void pop(Node** head) {
    if ( *head == NULL ) {
        printf("\nThe linked list is empty!\n");
    } else {
        Node* pointer = *head;
        printf("\nThe element %d is popped from DLL!\n",pointer->data);
        *head = pointer->next;
    }
}

void display(Node* head) {
    if( head == NULL ) {
        printf("\nLinked List is empty!\n");
    }
    else {
        Node* pointer = head;
        printf("\nThe elements of DLL are displayed: \n");
        while( pointer != NULL ) {
            printf("\n%d\n",pointer->data);
            pointer = pointer->next;
        }
    }
}

void reverseDisplay(Node *head) {
    if( head == NULL ) {
        printf("\nLinked List is empty!\n");
    }
    else {
        Node* pointer = head;
        Node* prepointer;
        while( pointer != NULL ) {
            prepointer = pointer; // storing the reference
            pointer = pointer->next;
        }
        pointer = prepointer; // assigning the reference of the last node
        printf("\nThe elements of DLL are displayed in reverse order: \n");
        while( pointer != head->prev ) {
            printf("\n%d\n",pointer->data);
            pointer = pointer->prev;
        }


    }
}
