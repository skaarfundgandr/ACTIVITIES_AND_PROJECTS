import {MyNode, MyStack} from "./Stack";

const stack: MyStack = new MyStack();

stack.push(5);
stack.push(2);

for (let i = 0; i <= 10; i++) {
    stack.push(i);
}

console.log(stack);