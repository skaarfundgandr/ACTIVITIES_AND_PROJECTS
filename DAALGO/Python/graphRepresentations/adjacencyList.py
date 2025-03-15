class Node:
    def __init__(self, value):
        self.vertex = value
        self.next = None

class Graph:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = [None] * self.vertices # Initialize a 2d list of N vertices

    def addEdge(self, src, dest):
        node = Node(dest)
        node.next = self.graph[src]
        self.graph[src] = node # Add edge on source node

        node = Node(src)
        node.next = self.graph[dest]
        self.graph[dest] = node # Add edge on dest node
