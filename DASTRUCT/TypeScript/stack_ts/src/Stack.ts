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
    size: number;

    constructor();
    constructor(node: MyNode<T>);
    constructor(node?: MyNode<T>) {
        if (node) {
            this.head = node;
            this.tail = node;
            this.size = 1;
        } else {
            this.head = null;
            this.tail = null;
            this.size = 0;
        }
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

        this.size += 1;

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
        this.size -= 1;

        poppedNode!.next = null;
        return poppedNode;
    }

    peek(): MyNode<T> | null {
        return this.head;
    }

    display(): void {
        console.log(this);
    }

    getCount(): number {
        return this.size;
    }

    toString(): string {
        let result: string = '';
        let curr: MyNode<T> | null = this.head;

        while (curr !== null) {
            result += String(curr.value) + (curr.next ? ' -> ' : '');
            curr = curr.next;
        }

        return result;
    }
}

export { MyNode, MyStack };