def solution(numbers, direction):
    answer = []
    if direction == "right" :
        x = numbers.pop()
        numbers.insert(0,x)
    elif direction == "left" :
        x = numbers.pop(0)
        numbers.append(x)
    answer = numbers
    return answer