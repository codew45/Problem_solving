def is_palindrome(s):
    l = len(s)
    for i in range(l//2):
        if s[i]!=s[l-i-1]:
            return False
    return True
    
T = 10
for test_case in range(1, T + 1):
    l = int(input())
    data = []
    cnt = 0
    
    for i in range(8):
        data.append(list(input()))
        
    for i in range(8):
        
        for j in range(8-l+1):
            tmp = ""
            for k in range(l):
                tmp += data[i][j+k]
            if is_palindrome(tmp):
                cnt += 1
          
    for i in range(8-l+1):  
        for j in range(8):
            tmp = ""
            for k in range(l):
                tmp += data[i+k][j]
            if is_palindrome(tmp):
                cnt +=1
            

    print("#%d %d" %(test_case, cnt))