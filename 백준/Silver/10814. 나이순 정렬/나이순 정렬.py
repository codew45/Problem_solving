import sys
input=sys.stdin.readline
n=int(input())
arr=[]
for i in range(n):
    age,name = input().split()
    arr.append([i,int(age),name])
arr.sort(key=lambda x:(x[1],x[0]))
for i in arr:
    print(i[1],i[2])