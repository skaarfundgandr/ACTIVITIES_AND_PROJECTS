from collections import deque

def bfs(graph, root):
    visited, queue = set(), deque([root])
    visited.add(root)

    while queue:
        vertex = queue.popleft()

        print(vertex, end=" ")

        for neighbour in graph[vertex]:
            if neighbour not in visited:
                visited.add(neighbour)
                queue.append(neighbour)

if __name__ == "__main__":
    graph = {0: [1, 2], 1: [2], 2: [3], 3: [1, 2]}
    bfs(graph, 0)
    print()