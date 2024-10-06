class Node:
    def __init__(self, data):
        self.previous = None
        self.data = data
        self.next = None

class NodeList:
    def __init__(self):
        self.head = None
        self.tail = None
        self.count = 0

    def add(self, item):
        newNode = item

        if self.head is None:
            newNode.previous = None
            newNode.next = None
            self.head = self.tail = newNode
        else:
            newNode.previous = self.tail
            self.tail.next = newNode
            self.tail = self.tail.next

        self.count += 1

    def delete(self, location):
        if (self.isEmpty()):
            return False
        else:
            curr_idx = 0
            currNode = self.head
            while (currNode is not None and curr_idx < location):
                currNode = currNode.next
                curr_idx += 1
            
            if currNode is None:
                return False
            
            if currNode is self.head:
                self.head = self.head.next
                self.head.previous = None
            elif currNode is self.tail:
                self.tail = self.tail.previous
                self.tail.next = None
            else:
                currNode.previous.next = currNode.next

            currNode = None

    def isEmpty(self):
        return self.head is None

    def displayFIFO(self):
        currNode = self.head

        while currNode is not None:
            print(currNode.data)
            currNode = currNode.next
    
    def displayLIFO(self):
        currNode = self.tail

        while currNode is not None:
            print(currNode.data)
            currNode = currNode.previous

if __name__ == "__main__":
    nodeList = NodeList()

    print(nodeList.isEmpty())

    nodeList.add(Node(1))
    nodeList.add(Node(2))
    nodeList.add(Node(3))

    print(nodeList.isEmpty())
    nodeList.delete(2)

    nodeList.displayFIFO()
    