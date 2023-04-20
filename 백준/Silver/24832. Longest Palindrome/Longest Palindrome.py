n,m = map(int, input().split())
words = []
reverseNum=[]
decal=[]
answer=''

for i in range(n) :
    word = input()
    words.append(word)

    if m==1 : 
        decal.append(word)

    else :
        if word==word[::-1] :
            decal.append(word)
            
if len(decal)>0 :
    answer=decal[0]
    

for i in words :
    if i[::-1] in words and i not in decal :
        reverseNum.append(i)

checker=[0 for i in range(len(reverseNum))]
for i in range(len(reverseNum)) :
    if checker[i] == 0 :    
        answer = reverseNum[i]+answer+reverseNum[i][::-1]
        checker[i]=1
        checker[reverseNum.index(reverseNum[i][::-1])]=1

print(len(answer))
if len(answer) != 0 :
    print(answer)