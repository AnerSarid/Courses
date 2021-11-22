for x in range (0, 501):
    s = str(x)
    if x >= 100 and int(s[0])**3+int(s[1])**3+int(s[2])**3 == x:
        print(x)
    elif x>=10 and x<100 and int(s[0])**3+int(s[1])**3 == x:
        print(x)

    
    
