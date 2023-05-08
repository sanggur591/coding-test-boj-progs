def solution(tickets):
    way = []
    tickets.sort(key=lambda x : x[1])
    answer = ['ICN']
    start = []
    visit = [0 for i in range(len(tickets))]
    for i in range(len(tickets)):
        if tickets[i][0] == 'ICN':
            start.append(i)
    def dfs(x) :
        visit[x] = 1
        way.append(x)
        if len(way) == len(tickets) :
            return 1
        for i in range(len(tickets)):
            if visit[i] == 0 and tickets[x][1] == tickets[i][0] :
                dfs(i)
        if len(way) != len(tickets) :
            visit[x]=0
            way.pop()

    for s in start :
        r = dfs(s)
        if len(way) == len(tickets) :
            break
        else : 
            way = []
    for i in way :
        answer.append(tickets[i][1])
    return answer