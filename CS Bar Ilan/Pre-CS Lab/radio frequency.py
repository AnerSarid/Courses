x = input ('Please input a radio frequency between 88 and 107: ')

freq = int(x)

if freq>=88 and freq <=107:
    print('You are now listening to', freq, 'fm')
else:
    print('You have entered an invalid number. Try again')
