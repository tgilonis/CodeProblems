#2d array

def hourglassSum(arr):

    sums = []

    for i in range(len(arr)-2):
        for j in range(len(arr)-2):
            sums.append(arr[i][j] + arr[i][j+1] + arr[i][j+2] 
            + arr[i+1][j+1] + 
            arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2])

    

    return max(sums)

#left rotation

def rotLeft(a, d):
    rotated = []
    for x in range(len(a)):
       rotated.insert((x - d + len(a)) % len(a), a[x])
    return rotated


#rotLeft([1,2,3,4,5],4)

def minimumSwaps(arr):
    
    count = 0
   
    for i in range(len(arr)):

      while(arr[i] != i+1):

        temp = arr[i]-1
        arr[i], arr[temp] = arr[temp], arr[i]
        count+=1
        

    return count
        

#print(minimumSwaps([7, 1, 3, 2, 4, 5, 6]))
#print(minimumSwaps([2,3,4,1,5]))

#array manipulation

def arrayManipulation(n, queries):

    resultant = [0 for x in range(n + 1)]

    for query in queries:
        resultant[query[0]-1] += query[2]
        resultant[query[1]] -= query[2]
    
    sum = 0
    max = 0
    for num in resultant:
        sum+=num
        if sum > max:
            max = sum

    return max


    

#print(arrayManipulation(5,[[1,2,100],[2,5,100],[3,4,100]]))

def minimumBribes(q):
    #first, check if too chaotic:
    '''
    for i in range(len(q)):
        #If a number is greater than 2 compared to its current index, it must 
        #have bribed more than 2 numbers to get there
        if((q[i] - (i+1))>2):
            print("Too chaotic")
            return

    count = 0

    #now that we know it's not chaotic, check how many bribes

    #working from the right, check how many elements on the left
    #are larger than the current element, and add each instance to the 
    #count
    

    for i in range(len(q), 0, -1):
        for j in range(i-1, 0, -1):
            if(q[i-1]<q[j-1]):
                count += 1

    print(count)
    
    for i in range(len(q)):
        #If a number is greater than 2 compared to its current index, it must 
        #have bribed more than 2 numbers to get there
        if((q[i] - (i+1))>2):
            print("Too chaotic")
            return

    '''

    count = 0

    #now that we know it's not chaotic, check how many bribes

    #working from the right, check how many elements on the left
    #are larger than the current element, and add each instance to the 
    #count
    queue = [i-1 for i in q]
    for i, p in enumerate(queue):
        if p-i>2:
            print("Too chaotic")
            return
        for j in range(max(p-1,0),i):
            if queue[j] > p:
                count+=1

    

    print(count)

#minimumBribes([2,1,5,3,4])
minimumBribes([1, 2, 5, 3, 7, 8, 6, 4])
#minimumBribes([2,5,1,3,4])
