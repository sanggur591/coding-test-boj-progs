def solution(numbers):
    answer = 0
    numbers.sort()
    plus = numbers[-1]*numbers[-2]
    minus = numbers[0]*numbers[1]
    answer = max(plus, minus)
    return answer