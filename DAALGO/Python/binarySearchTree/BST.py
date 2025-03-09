class Node:
    def __init__(self, key, data: any = None):
        self.parent = None
        self.leftChild = None
        self.rightChild = None
        self.data = None if data is None else data
        self.key = key

class BST:
    def __init__(self):
        self.root = None

    def insert(self, newNode: Node) -> None:
        curr = self.root
        parentNode = None

        while curr is not None:
            parentNode = curr
            if newNode.key < curr.key:
                curr = curr.leftChild
            else:
                curr = curr.rightChild

        newNode.parent = parentNode

        if parentNode is None:
            self.root = newNode
        elif newNode.key < parentNode.key:
            parentNode.leftChild = newNode
        else:
            parentNode.rightChild = newNode

    def minimum(self, parent: Node = None) -> Node:
        current = self.root if parent is None else parent

        while current.leftChild is not None:
            current = current.leftChild

        return current

    def maximum(self, parent: Node = None) -> Node:
        current = self.root if parent is None else parent

        while current.rightChild is not None:
            current = current.rightChild

        return current

    def inorderWalk(self, parent) -> None:
        if parent is not None:
            self.inorderWalk(parent.leftChild)
            print(parent.key, end=" ")
            self.inorderWalk(parent.rightChild)

    def search(self, key) -> Node:
        current = self.root

        while current is not None and key != current.key:
            if key < current.key:
                current = current.leftChild
            else:
                current = current.rightChild

        return current

    def successor(self, node: Node = None) -> Node:
        current = self.root if node is None else node

        if current.rightChild is not None:
            return self.minimum(current.rightChild)
        else:
            parent = node.parent
            while parent is not None and current is parent.rightChild:
                current = parent
                parent = parent.parent
            return parent

    def predecessor(self, node: Node = None) -> Node:
        current = self.root if node is None else node

        if current.leftChild is not None:
            return self.maximum(current.leftChild)
        else:
            parent = node.parent
            while parent is not None and current is parent.leftChild:
                current = parent
                parent = parent.parent
            return parent

    def transplant(self, target: Node, source: Node) -> None:
        if target.parent is None:
            self.root = source
        elif target is target.parent.leftChild:
            target.parent.leftChild = source
        else:
            target.parent.rightChild = source

        if source is not None:
            source.parent = target.parent

    def delete(self, key) -> None:
        target: Node = self.search(key)

        if target is None:
            return

        if target.leftChild is None:
            self.transplant(target, target.rightChild)
        elif target.rightChild is None:
            self.transplant(target, target.leftChild)
        else:
            successor: Node = self.minimum(target.rightChild)
            if successor is not target.rightChild:
                self.transplant(successor, successor.rightChild)
                successor.rightChild = target.rightChild
                successor.rightChild.parent = successor
            self.transplant(target, successor)
            successor.leftChild = target.leftChild
            successor.leftChild.parent = successor

        target = None # Delete target node