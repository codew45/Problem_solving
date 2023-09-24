from collections import deque
import sys
input = sys.stdin.readline

def bfs(start):
    q = deque()
    q.append(start)
    visited[start] = True
    while q:
        cur = q.popleft()
        for i in range(1,7):
            ncur = cur+i
            if ncur==100:
                board[ncur]=board[cur]+1
                visited[ncur] = True
                return
            if 0<ncur<=100 and not visited[ncur]:
                if ncur in ladder:
                    visited[ncur] = True
                    board[ncur] = board[cur]+1

                    if not visited[ladder[ncur]]:
                        visited[ladder[ncur]]=True
                        board[ladder[ncur]] = board[ncur]
                    else:
                        board[ladder[ncur]]=min(board[ladder[ncur]], board[ncur])

                    q.append(ladder[ncur])
                    
                elif ncur in snake:
                    visited[ncur] = True
                    board[ncur] = board[cur]+1

                    if not visited[snake[ncur]]:
                        visited[snake[ncur]]=True
                        board[snake[ncur]] = board[ncur]
                    else:
                        board[snake[ncur]]=min(board[snake[ncur]], board[ncur])

                    q.append(snake[ncur])

                else:
                    q.append(ncur)
                    visited[ncur] = True
                    board[ncur] = board[cur]+1
                

N,M = map(int,input().split())
board = [0]*101
visited= [False]*101
ladder = {}
snake = {}

for _ in range(N):
    x,y = map(int,input().split())
    ladder[x] = y
for _ in range(M):
    u,v = map(int,input().split())
    snake[u] = v

bfs(1)
print(board[100])