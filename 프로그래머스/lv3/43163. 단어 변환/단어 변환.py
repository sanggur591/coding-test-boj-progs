from collections import deque
def solution(begin, target, words):
    dist = [0 for i in range(len(words))]
    length = len(begin)
    queue = deque()

    for i in range(len(words)) :
        same = 0
        for j in range(length):
            if begin[j] == words[i][j] :
                same += 1
        if same+1 == length :
            dist[i]=1
            queue.append(i)

    def bfs():
        while queue :
            x = queue.popleft()
            for i in range(len(words)) :
                if dist[i]!=0:
                    continue

                same = 0
                for j in range(len(words[x])):
                    if words[x][j] == words[i][j] :
                        same +=1
                if same+1 == len(words[x]) :
                    dist[i] = dist[x]+1
                    queue.append(i)

    bfs()
    if target in words:
        return dist[words.index(target)]
    else:
        return 0
