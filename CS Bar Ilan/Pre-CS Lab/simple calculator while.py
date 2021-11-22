answer = 'yes'
while answer == 'yes':
    x,y = input('Enter 2 numbers to calculate: ').split()
    print (x, '+', y, '=', int(x)+int(y))
    print (x, '-', y, '=', int(x)-int(y))
    print (x, '*', y, '=', int(x)*int(y))
    print (x, '/', y, '=', int(x)/int(y))
    answer = input('Would you like to continue?')
                   
    
