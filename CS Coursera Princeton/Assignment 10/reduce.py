from functools import reduce


def plus(x, y):
    return x + y
def odd(x):
    return 2*x + 1

print (reduce(plus, [1]*100))