package codecool;

public class CustomQueue {

    private class Node {

        private String value;
        private Node nextNode, prevNode;

        public Node(String value){
            this.value = value;
        }

        public String getValue(){
            return this.value;
        }

        public Node getNextNode(){
            return this.nextNode;
        }

        public void setNextNode(Node node) {
            this.nextNode = node;
        }

        public void setPrevNode(Node prevNode) {
            this.prevNode = prevNode;
        }
    }

    private Node head;
    private Node tail;
    private int size = 0;

    public CustomQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int queueSize() {
        return size;
    }

    public void enqueue(String value) {
        if(isEmpty()) {
            Node currentNode = new Node(value);
            this.head = currentNode;
            this.tail = this.head;

        } else {
            Node lastNode = new Node(value);

            Node tempNode = this.tail;
            lastNode.setPrevNode(tempNode);
            tempNode.setNextNode(lastNode);

            this.tail = tempNode.getNextNode();
        }
        this.size++;
    }

    public String peek() throws QueueEmptyException {
        if(isEmpty()) {
            throw new QueueEmptyException("Queue is empty");
        }
        Node firstNode = this.head;

        return firstNode.getValue();
    }

    public void dequeue() throws QueueEmptyException {
        if(isEmpty()) {
            throw new QueueEmptyException("Queue is empty");
        }
        Node firstNode = this.head;
        Node tempNode = firstNode.getNextNode();

        firstNode.nextNode = null;
        firstNode.value = null;

        this.head = tempNode;

        this.size--;
    }
}
