def solution(s):
    answer = len(s)
    for size in range(1,len(s)//2+1):
        tmp = ""
        cnt = 1
        prev = s[0:size]
        for i in range(size,len(s),size):
            if prev==s[i:i+size]:
                cnt +=1
            else:
                tmp += str(cnt) + prev if cnt>=2 else prev
                prev = s[i:i+size]
                cnt = 1
        tmp += str(cnt)+prev if cnt>=2 else prev
        answer = min(answer, len(tmp))
    return answer
