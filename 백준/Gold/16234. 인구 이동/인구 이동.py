from collections import deque
n,l,r = map(int,input().split())
graph = []
for _ in range(n):
    graph.append(list(map(int,input().split())))
dx = [-1,1,0,0]
dy = [0,0,-1,1]
total_cnt = 0

def bfs(index,x,y):
    q = deque()
    q.append((x,y))
    union[x][y]=index
    unite = []
    unite.append((x,y))
    cnt = 1
    summary = graph[x][y]
    while q:
        x,y = q.popleft()
        for i in range(4):
            nx = x+dx[i]
            ny = y+dy[i]
            if 0<=nx<n and 0<=ny<n and union[nx][ny]==-1:
                if l<=abs(graph[x][y]-graph[nx][ny])<=r:
                    q.append((nx,ny))
                    union[nx][ny] = index
                    summary+=graph[nx][ny]
                    cnt += 1
                    unite.append((nx,ny))
    for i,j in unite:
        graph[i][j] = summary//cnt
    #return cnt

while True:
    union = [[-1]*n for _ in range(n)]
    index = 0
    for i in range(n):
        for j in range(n):
            if union[i][j]==-1:
                bfs(index,i,j)
                index +=1
    if index==n*n:
        break
    total_cnt +=1
print(total_cnt)
                