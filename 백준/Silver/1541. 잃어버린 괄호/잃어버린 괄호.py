data = input().split('-')
total = 0

for i in data[0].split('+'):
    total += int(i)
for i in data[1:]:
    for j in i.split('+'):
        total -= int(j)
print(total)