def solution(N, stages):
    answer = []
    length = len(stages)
    
    for i in range(1,N+1):
        cnt = stages.count(i)
        
        if length==0:
            fail = 0
        else:
            fail = cnt/length
            
        answer.append((fail, i))
        length -= cnt
    answer.sort(key=lambda x:-x[0])
    answer = [i[1] for i in answer]
    
    return answer