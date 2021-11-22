x, y = input('Please enter two numbers ').split()
num = int(x)
div = int(y)
if  num>0 and div>0 and num % div == 0:
    print(num, "is a multiple of ", div)
else:
    print(num, "is not a multiple of ", div)
