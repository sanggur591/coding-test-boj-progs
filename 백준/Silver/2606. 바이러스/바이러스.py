n = int(input())
connections = int(input())
#dfs
graph = [[] for i in range(n+1)]
visited = [0]*(n+1)
for i in range(connections) :
    a ,b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

def dfs(num) :
    visited[num]=1
    for x in graph[num]:
        if visited[x]==0:
            dfs(x)

dfs(1)

print(sum(visited)-1)