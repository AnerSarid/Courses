arrayOne = [5,4,13,15,2,58,1234,123,6,7]

leng = len(arrayOne)

idxOne = 0

duplicate = False

while idxOne < leng:
    for num in range(0,leng):
        if arrayOne[idxOne] == arrayOne[num] and num != idxOne:
            duplicate = True
    idxOne = idxOne + 1
print(duplicate)
