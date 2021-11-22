import random
num = random.randint (1,100)

userName = input('Who are you?')

times = 1
bestTry = 100
answer = 'yes'
while answer == 'yes':
    num = random.randint (1,100)
    guess = int(input('Try to guess the number between 1 and 100:'))
    while guess != num:
        times = times+1
        if num>guess:
            print('You need to guess a bigger number')
        elif num<guess:
            print('You need to guess a smaller number')
        guess = int(input('Guess again!'))

    if num==guess:
            if bestTry < times:
                print('Good guess', userName,'! Took you', times, 'tries. Your best score was', bestTry)
            elif bestTry > times:
                print('Good guess', userName,'! Took you', times, 'tries. That is the new high score!')
                bestTry = times
                times = 1
    answer = input('Do you want to play again?')
                


    
