numbers = [1,1000,23,100000,3467,42354,3467,74321,123478,492817]

x,y = input('Enter 2 numbers between 1 and 10: ').split()
leng = 0
sum = 0
for idx in range(int(x)-1,int(y)):
    sum = sum + numbers[idx]
    leng = leng + 1
print(sum)
print(sum/leng)

