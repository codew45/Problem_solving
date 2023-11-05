for i in range(1, 11):
    num = int(input())
    target = input()
    s = input()
    cnt = 0
    idx = 0
    while len(s)>=len(target):
        idx = s.find(target)
        if idx==-1:
            break
        else:
            cnt +=1
            s = s[idx+len(target):]
    print("#%d %d" %(i, cnt))    