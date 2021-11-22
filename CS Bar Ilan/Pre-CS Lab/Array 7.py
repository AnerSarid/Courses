array = [1,2,3,4,1,6,7,8,9,1]

i=9
length = len(array)

while i > -1:
    for x in array:
        if x == array[i]:
            array.pop(i)
        i -= 1            
print (array)
