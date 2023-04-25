def solution(rsp):
    x = ['2','0','5']
    answer = ''
    for i in rsp :
        answer += x[(x.index(i)+1)%3]
    return answer