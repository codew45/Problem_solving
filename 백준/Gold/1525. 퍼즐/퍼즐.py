from collections import deque
target = ""

for i in range(3):
    target += input().replace(' ','')
target = target.replace('0', '9')
visited = dict()
visited[target]=0

dx = [-1,1,0,0]
dy = [0,0,-1,1]

def bfs(start):
    queue = deque([start])
    while queue:
        v = queue.popleft()
        if v=="123456789":
            return visited[v]
        #tmp = str(v)
        idx = v.find('9')
        x, y = idx//3, idx%3
        for i in range(4):
            nx = x+dx[i]
            ny = y+dy[i]
            if nx>=0 and nx<3 and ny>=0 and ny<3:
                nidx = nx*3+ny
                nstr = list(v)
                nstr[idx],nstr[nidx] = nstr[nidx],nstr[idx]
                nstr = (''.join(nstr))
                if not visited.get(nstr):
                    visited[nstr] = visited[v]+1
                    queue.append(nstr)
    return -1
print(bfs(target))
