def solution(my_string, num1, num2):
    x = list(my_string)
    a = x[num1]
    x[num1]=x[num2]
    x[num2]=a
    return ''.join(x)