import {MyStack} from "./Stack";

const stack: MyStack<number> = new MyStack();

stack.push(5);
stack.push(2);

for (let i = 0; i <= 10; i++) {
    stack.push(i);
}

console.log(String(stack));

while (!stack.isEmpty()) {
    const poppedNode = stack.pop();
    console.log(`Popped node value: ${poppedNode?.value}`);
}

console.log(`Final stack size: ${stack.getCount()}`);