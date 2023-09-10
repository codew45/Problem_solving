from collections import deque
import sys
input = sys.stdin.readline

def bfs(a,b):
    q = deque()
    q.append((a,b))
    while q:
        x,y = q.popleft()
        if x==d_x and y==d_y:
            return board[x][y]
        for i in range(8):
            nx,ny = x+dx[i],y+dy[i]
            if 0<=nx<l and 0<=ny<l and board[nx][ny]==0:
                q.append((nx,ny))
                board[nx][ny] = board[x][y]+1

T = int(input())
for i in range(T):
    l = int(input())
    board = [[0 for k in range(l)]for j in range(l)]
    s_x,s_y = map(int,input().split())
    d_x,d_y = map(int,input().split())
    dx = [-1,-2,-2,-1,1,2,2,1]
    dy = [-2,-1,1,2,-2,-1,1,2]

    print(bfs(s_x,s_y))