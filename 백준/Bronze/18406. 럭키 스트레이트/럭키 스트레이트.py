num = input()
head = 0
tail = 0
for i in range(len(num)):
    if i<len(num)//2:
        head+=int(num[i])
    else:
        tail+=int(num[i])
if head==tail:
    print("LUCKY")
else:
    print("READY")