import math
def solution(n):
    answer = 2
    if math.floor(math.sqrt(n))**2==n:
        answer=1
    return answer