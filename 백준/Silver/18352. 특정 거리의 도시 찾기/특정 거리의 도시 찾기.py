from collections import deque
import sys
input = sys.stdin.readline

n,m,k,x = map(int,input().split())
graph = [[] for _ in range(n+1)]

for _ in range(m):
    s,e = map(int,input().split())
    graph[s].append(e)

distance = [-1]*(n+1)

def bfs(x):
    q = deque()
    q.append(x)
    distance[x] = 0
    while q:
        now = q.popleft()
        for next in graph[now]:
            if distance[next]==-1:
                distance[next] = distance[now]+1
                q.append(next)

bfs(x)

if k not in distance:
    print(-1)
else:
    for i in range(1,n+1):
        if distance[i]==k:
            print(i)