def fibonacci(n):
    if n<=1:
        return 1 if n == 1 else 0
    else:
        return fibonacci(n-1) + fibonacci(n-2)
    # Write your code here.

#this is the simple, but inefficient version of recurive fibonacci, as each call must be computed as if
#it were a new call

#print(fibonacci(5))

fibDict = {}
def fibonacciMap(n):
    if(n in fibDict):
        return fibDict[n]
    if(n<=1):
        fibDict[n] = n
    else:
        fibDict[n] = fibonacciMap(n-1) + fibonacciMap(n-2)
    return fibDict[n]


#stepPerms is essentially fibonacci with an extra arg and base case, so we
#can perform tail recursion in a helper method by creating the next stepPerm cases
#in the params
def stepPermsTail(n):
    def stepsHelp(a,b,c,n):
        if(n==1):
            return a
        if(n==2):
            return b
        if(n==3):
            return c
        else:
            return stepsHelp(b, c, a+b+c,n-1) #we know what 1,2,3 should be, and therefore and work out 4 in this line
    return stepsHelp(1,2,4,n)
    


#to keep the lookup dict local, create a private method within the method to carry out the recursion
def stepPerms(n):
    lookup = {}
    def _stepPerms(n):
        if n in lookup:
            return lookup[n]
        else:
            if(n==1):
                lookup[n] = 1
            elif(n==2):
                lookup[n] = 2
            elif(n==3):
                lookup[n] = 4
            else:
                lookup[n] = _stepPerms(n-1)+_stepPerms(n-2)+_stepPerms(n-3)
        return lookup[n]
    return _stepPerms(n)

'''            
print(stepPerms(5))
print(stepPerms(6))
print(stepPerms(7))
    
print(stepPermsTail(5))
print(stepPermsTail(6))
print(stepPermsTail(7))'''

def superDigit(n, k):
    def _superDigit(n):
        if(n<10):
            return n        
        return _superDigit(sum(map(int, list(str(n)))))

    if(len(str(n)) and k == 1):
        return n
    else:        
        return _superDigit(sum(map(int, list(str(n))))*k)


print(superDigit(9875,4))
print(superDigit(148,3))
