def solution(numbers):
    answer = list(map(twice, numbers))
    return answer
def twice(x) :
    return x*2