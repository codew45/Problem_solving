def balanced_idx(p):
    cnt=0
    for i in range(len(p)):
        if p[i]=='(':
            cnt +=1
        else:
            cnt -=1
        if cnt==0:
            return i
        
def check_proper(p):
    cnt = 0
    for i in p:
        if i=='(':
            cnt +=1
        else:
            if cnt==0:
                return False
    
    return True

def solution(p):
    answer = ''
    if p=='':
        return answer
    idx = balanced_idx(p)
    u = p[:idx+1]
    v = p[idx+1:]
    if check_proper(u):
        answer = u+solution(v)
    else:
        answer +='('
        answer += solution(v)
        answer +=')'
        u = list(u[1:-1])
        for i in u:
            if i=='(':
                answer += ')'
            else:
                answer += '('
    return answer