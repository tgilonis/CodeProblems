def checkMagazine(magazine, note):
    magDict = {}
    for word in magazine:
        if word in magDict:
            magDict[word] = magDict[word] + 1
        else:
            magDict[word] = 1

    for word in note:
        if word in magDict and magDict[word]>0:
            magDict[word] = magDict[word] - 1            
        else:
            print("No")
            return
    print("Yes")

def twoStrings(s1, s2):
    if set(s1) & set(s2):
        return "YES"
    else :
        return "NO"

def sherlockAndAnagrams(s):
    
    anagrams = {}
    count = 0
    for i in range(len(s)):
        for j in range(i+1, len(s)+1):
            anag = ''.join(sorted(s[i:j]))
            if(anag in anagrams):
                count += anagrams[anag] 
                anagrams[anag] = anagrams[anag] + 1
            else:
                anagrams[anag] = 1
    
    return count
            
def countTriplets(arr, r):

    rightMap = {}
    for i in arr:
        rightMap[i] = rightMap.get(i, 0) + 1
    leftMap = {}

    count = 0


    for key in arr:
        rightVal = key*r
        leftVal = key//r
        rightMap[key] = rightMap[key] -1
        
        right = 0
        left = 0
        if rightMap.get(rightVal, 0) > 0 and key%r==0:
            right = rightMap[rightVal]
        if leftMap.get(leftVal, 0) > 0:
            left = leftMap[leftVal]
        count += left * right

        leftMap[key] = leftMap.get(key, 0) + 1

    

    return count

def freqQuery(queries):

    #two dicts are needed here: one to keep track of the number of each integer,
    #one to keep track of the number of each frequency
    #this way, when we need to check if a number has an exact frequency value,
    #we check if the freqMap has that frequency at >0
    result = []
    integerMap = {}
    freqMap = {}
    for operation, data in queries:
        #here we need to check the operation and act accordingly
        oldFrequency = integerMap.get(data,0)

        if(operation==1):
            #increment the count value of the integer
            integerMap[data] = oldFrequency + 1
            
            #decrease the frequency that the integer was at
            freqMap[oldFrequency] = freqMap.get(oldFrequency, 1) - 1            
            
            newFrequency = integerMap[data]
            #increase the frequency that the integer has moved to
            freqMap[newFrequency] = freqMap.get(newFrequency, 0) + 1
        
        elif(operation==2):
            #decrement the count value of the integer
            integerMap[data] = max(oldFrequency - 1, 0)
            
            #decrease the frequency that the integer was at
            freqMap[oldFrequency] = max(0,freqMap.get(oldFrequency, 0) - 1)            
            
            newFrequency = integerMap[data]
            #increase the frequency that the integer has moved to, unless that new integer is zero
            #(zero is not in the integer parameters for this challenge)
            if(newFrequency>0):
                freqMap[newFrequency] = freqMap.get(newFrequency, 0) + 1
            
        
        elif(operation==3):
            result.append(1 if freqMap.get(data) else 0)
    
    return result

#freqQuery([[1,1],[2,2],[3,2],[1,1],[1,1],[2,1],[3,2]])

#print(countTriplets([1,5,5,25,125],5))

#print(sherlockAndAnagrams("ifailuhkqq"))
#print(sherlockAndAnagrams("kkkk"))


#print(twoStrings("and", "art"))

#checkMagazine(["give", "me", "one", "grand", "today", "night"],["give","one", "grand", "today"])

