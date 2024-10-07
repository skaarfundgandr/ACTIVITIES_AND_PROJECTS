from NodeList import Node, NodeList

nodeList = NodeList()

print(nodeList.isEmpty())

nodeList.add(Node(1))
nodeList.add(Node(2))
nodeList.add(Node(3))
nodeList.add(Node(4))

print(nodeList.isEmpty())
nodeList.delete(2)
nodeList.delete(1)

nodeList.displayFIFO()
nodeList.displayLIFO()