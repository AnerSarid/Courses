arrayOne = [5,35,16,15,27,38,34,2,6,7]
arrayTwo = [7,76,54,15,27,5,16,65,98,0]

idxOne = 0


while idxOne < 10:
    for idxTwo in range(0,10):
        if arrayOne[idxOne] == arrayTwo[idxTwo]:
            print(arrayOne[idxOne])
    idxOne = idxOne + 1
