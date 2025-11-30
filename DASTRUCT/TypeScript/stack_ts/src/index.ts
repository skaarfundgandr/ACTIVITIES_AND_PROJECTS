import {MyNode, MyStack} from "./Stack";

let node: MyNode = new MyNode(10);
let stack: MyStack = new MyStack(node);

console.log(stack.peek());

stack.pop()

console.log(stack.peek());