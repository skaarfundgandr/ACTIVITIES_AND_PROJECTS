class MyNode<T> {
    value: T;
    next: MyNode<T> | null;

    constructor(value: T) {
        this.value = value;
        this.next = null;
    }
}

class MyStack<T> {
    head: MyNode<T> | null;
    tail: MyNode<T> | null;

    constructor();
    constructor(node: MyNode<T>);
    constructor(node?: MyNode<T>) {
        this.head = node ?? null;
        this.tail = node ?? null;
    }

    isEmpty(): boolean {
        return this.head === null;
    }

    push(nodeOrValue: MyNode<T> | T): boolean {
        const node: MyNode<T> = nodeOrValue instanceof MyNode ? nodeOrValue
            : new MyNode(nodeOrValue);

        if (this.isEmpty()) {
            this.head = node;
            this.tail = node;
        } else {
            node.next = this.head;
            this.head = node;
        }

        return true;
    }

    pop(): MyNode<T> | null {
        if (this.isEmpty()) {
            return null;
        }

        const poppedNode: MyNode<T> | null = this.head;
        this.head = this.head!.next;

        if (this.head === null) {
            this.tail = null;
        }

        poppedNode!.next = null;
        return poppedNode;
    }

    peek(): MyNode<T> | null {
        return this.head;
    }

    display(): void {
        console.log(this);
    }

    toString(): string {
        let result: string = '';
        let currentNode: MyNode<T> | null = this.head;

        while (currentNode !== null) {
            result += String(currentNode.value) + (currentNode.next ? ' -> ' : '');
            currentNode = currentNode.next;
        }

        return result;
    }
}

export { MyNode, MyStack };