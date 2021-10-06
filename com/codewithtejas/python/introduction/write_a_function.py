# https://www.hackerrank.com/challenges/write-a-function/problem

def is_leap(year):
    
    # Write your logic here
    if year%400 == 0:
        return True
    elif year%100 != 0 and year%4 == 0:
        return True
    
    return False

year = int(input())
print(is_leap(year))
