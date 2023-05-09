from collections import deque
n, m = map(int, input().split())
graph = []
queue = deque()
dist = [[0 for i in range(m)] for j in range(n)]
dx = [1,-1,0,0]
dy = [0,0,1,-1]
for i in range(n):
    graph.append(input())

dist[0][0]=1
queue.append((0,0))

def bfs() :
    while queue :
        x, y = queue.popleft()
        for i in range(4):
            rx = x +dx[i]
            ry = y +dy[i]
            if 0<=rx<m and 0<=ry<n and graph[ry][rx]=='1' and dist[ry][rx] == 0:
                dist[ry][rx] = dist[y][x] +1
                queue.append((rx,ry))
bfs()
print(dist[n-1][m-1])