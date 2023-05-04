def solution(numbers):
    a = []
    for num in numbers :
        answer = 0
        bin_num = bin(num)
        x = bin_num[2:]

        if len(x) == x.count("1") :
            answer = num + (num+1)//2
        
        elif x[len(x)-1] == '0' :
            answer = num +1
        
        else:
            for i in range(0,len(x)) :
                    if x[len(x)-1-i]=='0':
                        answer = num + 2 ** (i-1) 
                        break
            

        a.append(answer)

    return a