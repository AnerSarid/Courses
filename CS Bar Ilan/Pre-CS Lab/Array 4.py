yises = [1,2,3,4,5,6,7,8,9,10]

s = len(yises)-1
i = 0

while i<s:
    yises[i],yises[s] = yises[s], yises[i]
    i += 1
    s -= 1
print(yises)

        
