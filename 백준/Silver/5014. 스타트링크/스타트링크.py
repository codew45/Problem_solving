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
        for i in (a+u, a-d):
            if 0<i<=f and visited[i][0] == 0:
                queue.append(i)
                visited[i][0] = 1
                visited[i][1] = visited[a][1]+1
    if visited[g][1] ==0:
        print("use the stairs")
        return
bfs(s,g)