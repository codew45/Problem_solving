import sys
from collections import deque
input = sys.stdin.readline

n = int(input())
a,b=map(int,input().split())
m=int(input())

graph = [[]for i in range(n+1)]
result = []

for i in range(m):
    s,e = map(int,input().split())
    graph[s].append(e)
    graph[e].append(s)

def bfs(start):
    visited = [False]*(n+1)
    num = [0]*(n+1)
    queue = deque()
    queue.append(start)
    while queue:
        v = queue.popleft()
        for i in graph[v]:
            if not visited[i]:
                queue.append(i)
                visited[i]=True
                num[i] = num[v]+1
    return num

res = bfs(a)

if res[b]==0:
    print(-1)
else:
    print(res[b])