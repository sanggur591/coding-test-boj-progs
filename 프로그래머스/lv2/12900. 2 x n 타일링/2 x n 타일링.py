def solution(n):
    list = [1,1]
    while n>len(list)-1 :
        list.append((list[len(list)-1]+list[len(list)-2])%1000000007)
    return list[n]