numbers = []

print('Enter 10 numbers: ')

for i in range(0,10):
    newNumber = int(input())
    numbers.append(newNumber)

for number in numbers:
    if number%2 != 0:
        print(number)
