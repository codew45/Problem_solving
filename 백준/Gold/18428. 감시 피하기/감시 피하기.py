n = int(input())
data = []
teachers = []
for i in range(n):
    data.append(list(input().split()))
    for j in range(n):
        if data[i][j]=='T':
            teachers.append((i,j))
dx = [-1,1,0,0]
dy = [0,0,-1,1]

def watch(x,y):
    for i in range(4):
        nx = x+dx[i]
        ny = y+dy[i]

        while 0<=nx<n and 0<=ny<n and data[nx][ny]!='O':
            if data[nx][ny]=='S':
                return True
            else:
                nx += dx[i]
                ny += dy[i]
    return False

def dfs(cnt):
    global answer
    if cnt == 3:
        count = 0
        for x,y in teachers:
            if not watch(x,y):
                count +=1
        if count==len(teachers):
            answer = True
        return
    
    for i in range(n):
        for j in range(n):
            if data[i][j]=='X':
                data[i][j] = 'O'
                cnt +=1
                dfs(cnt)
                data[i][j] = 'X'
                cnt -= 1

answer = False
dfs(0)

if answer:
    print("YES")
else:
    print("NO")