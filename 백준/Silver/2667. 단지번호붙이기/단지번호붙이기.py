import sys
n = int(input())

graph = [list(map(int, sys.stdin.readline().rstrip())) for _ in range(n)]

dx = [0,0,1,-1]
dy = [1,-1,0,0]

houses = []

num = 0

def dfs(x, y) :
    global num
    if graph[y][x] == 1 :

        num+=1
        graph[y][x] = 0

        if y<n-1 :
            dfs(x+dx[0],y+dy[0])
        if y>0 :
            dfs(x+dx[1],y+dy[1])
        if x<n-1 :
            dfs(x+dx[2],y+dy[2])
        if x>0 :
            dfs(x+dx[3],y+dy[3])
    
    return num

for i in range(n) :
    for j in range(n):
        x = dfs(i,j)
        if x !=0 :
            houses.append(x)
            num=0

print(len(houses))
houses.sort()
for _ in houses :
    print(_)