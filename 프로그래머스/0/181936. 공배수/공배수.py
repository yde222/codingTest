def solution(number, n, m):
    if int(not(number % n)) & int(not(number % m)):
        return 1
    else:
        return 0