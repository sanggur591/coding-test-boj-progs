import math
def solution(price):
    answer =price
    if 100000<=price<300000 :
        answer = math.floor(price*0.95)
    elif 300000<=price<500000 :
        answer = math.floor(price *0.9)
    elif 500000<=price :
        answer = math.floor(price*0.8)
    return answer