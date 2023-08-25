from collections import deque

f,s,g,u,d = map(int,input().split())
visited=[[0 for j in range(2)]for i in range(f+1)]

def bfs(s,g):
    queue = deque()
    queue.append(s)
    visited[s][0]=1
    while queue:
        a = queue.popleft()
        if a==g:
            print(visited[a][1])
            return
        if a+u<=f and visited[a+u][0]==0:
            queue.append(a+u)
            visited[a+u][0] = 1
            visited[a+u][1] = visited[a][1]+1
        if a-d>0 and visited[a-d][0]==0:
                queue.append(a-d)
                visited[a-d][0] = 1
                visited[a-d][1] = visited[a][1]+1
    if visited[g][1] ==0:
        print("use the stairs")
        return
bfs(s,g)