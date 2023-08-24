import sys
from collections import deque
input = sys.stdin.readline

def dist(ax,ay,bx,by):
    return abs(ax-bx)+abs(ay-by)

def bfs(start,fest,conv):
    queue = deque()
    queue.append((start[0],start[1]))
    visited = [False]*(len(conv))
    
    while queue:
        x,y = queue.popleft()
        if dist(x,y,fest[0],fest[1])<=1000:
            print("happy")
            return
        for i in range(len(conv)):
            if dist(x,y,conv[i][0],conv[i][1])<=1000:
                if not visited[i]:
                    queue.append((conv[i][0],conv[i][1]))
                    visited[i]=True
    print("sad")
    return

t = int(input())
    
for i in range(t):
    n = int(input())
    conv = []
    start = list(map(int,input().split()))
    for i in range(n):
        conv.append(list(map(int,input().split())))
    fest = list(map(int,input().split()))

    bfs(start,fest,conv)