for test_case in range(1, 11):
    n = int(input())
    n = 100
    data = []
    row, col, diagonal = 0, 0, 0
    for i in range(n):
        data.append(list(map(int, input().split())))
        row = max(row, sum(data[i]))

    left, right = 0, 0
    for i in range(n):
        left += data[i][i]
        right += data[n - i - 1][n - i - 1]
    diagonal = max(left, right)

    for i in range(n):
        tmp = 0
        for j in range(n):
            tmp += data[j][i]
        col = max(col, tmp)

    print('#{} {}'.format(test_case, max(row, col, diagonal)))

