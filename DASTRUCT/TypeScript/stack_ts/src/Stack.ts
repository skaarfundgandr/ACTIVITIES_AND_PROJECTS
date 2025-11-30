class MyNode {
    value: number;
    next: MyNode | null;

    constructor(value: number) {
        this.value = value;
        this.next = null;
    }
}

class MyStack {
    head: MyNode | null;
    tail: MyNode | null;

    constructor();
    constructor(node: MyNode);
    constructor(node?: MyNode) {
        this.head = node ?? null;
        this.tail = node ?? null;
    }

    isEmpty(): boolean {
        return this.head === null;
    }

    push (node: MyNode): boolean {
        if (this.isEmpty()) {
            this.head = node;
            this.tail = node;
        } else {
            node.next = this.head;
            this.head = node;
        }

        return true;
    }

    pop(): MyNode | null {
        if (this.isEmpty()) {
            return null;
        }

        const poppedNode: MyNode | null = this.head;
        this.head = this.head!.next;

        if (this.head === null) {
            this.tail = null;
        }

        poppedNode!.next = null;
        return poppedNode;
    }

    peek(): MyNode | null {
        return this.head;
    }

    display(): void {
        console.log(this);
    }

    toString(): string {
        let result: string = '';
        let currentNode: MyNode | null = this.head;

        while (currentNode !== null) {
            result += currentNode.value.toString() + (currentNode.next ? ' -> ' : '');
            currentNode = currentNode.next;
        }

        return result;
    }
}

export { MyNode, MyStack };