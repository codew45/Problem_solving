from collections import deque
n,k = map(int,input().split())

MAX = 100001

def bfs(s,k):
    visited =[[0]*2 for i in range(MAX)]
    queue = deque()
    queue.append(s)
    visited[s][0] = 1
    visited[s][1] = 0
    while queue:
        c = queue.popleft()
        if c==k:
            print(visited[c][1])
            return
        for i in (c*2, c+1, c-1):
            if 0<=i<MAX and visited[i][0]==0:
                queue.append(i)
                visited[i][0] = 1
                visited[i][1] = visited[c][1]+1
            
bfs(n,k)