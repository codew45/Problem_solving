import sys
input = sys.stdin.readline

def pre_order(root):
    if root!=None:
        print(root,end='')
        pre_order(tree[root][0])
        pre_order(tree[root][1])

def in_order(root):
    if root!=None:
        in_order(tree[root][0])
        print(root,end='')
        in_order(tree[root][1])

def post_order(root):
    if root!=None:
        post_order(tree[root][0])
        post_order(tree[root][1])
        print(root,end='')

n = int(input())
tree = {}

for i in range(n):
    data, left, right = input().split()
    if left=='.':
        left=None
    if right=='.':
        right=None
    tree[data] = [left,right]

pre_order('A')
print()
in_order('A')
print()
post_order('A')
        