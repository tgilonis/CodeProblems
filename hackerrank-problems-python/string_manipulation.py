def isValid(s):
    count = {}
    for x in s:
        count[x] = count.get(x,0) + 1


    freqDict = {}
    for x in count:
        freqDict[count[x]] = freqDict.get(count[x], 0) + 1
    #check size of dict for each condition:
    
    #size is 1    
    if(len(freqDict.keys())==1):
        return "YES"
    else:
        for x in freqDict:
            print(f"{x}:{freqDict[x]}")
        if(len(freqDict.keys())==2 and freqDict.get(1,0)==1):  
            return "YES"
        else:
            if(len(freqDict.keys())==2 and list(freqDict)[1] - list(freqDict)[0]==1 and freqDict[list(freqDict)[1]]==1):
                print(1)
                return "YES"
            else:
                return "NO"
       
        
    
    

    #size is 2, difference between the two frequencies is 1, and the max freq val is 1
          

#print(isValid("abbccc"))

def substrCount(n, s):
    count = n
    for i in range(0, n):

        tempIndex = 1        
        oddCharIndex = i-1 if i-1>=0 else i+1
        while(i+tempIndex <= n-1 and i-tempIndex>=0 and s[i-tempIndex]==s[i+tempIndex]==s[oddCharIndex]):
            print(s[i-tempIndex:i+tempIndex+1])
            count += 1
            tempIndex += 1
        
        tempIndex = 0
        while(i+tempIndex < n-1 and i-tempIndex>=0 and s[i-tempIndex]==s[i+1+tempIndex]==s[i]):
            print(s[i-tempIndex:i+tempIndex+2])
            count += 1
            tempIndex += 1

    return count
#print(substrCount(7, "abcbaba"))
#print(substrCount(4,"aaaa"))    
#print(substrCount(5,"asasd"))
#print(substrCount(8,"mnonopoo"))

















def substrCount(n, s):
    print()