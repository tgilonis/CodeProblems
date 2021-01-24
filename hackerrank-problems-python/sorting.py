def countSwaps(a):
    count = 0

    for i in range(len(a)):
        for j in range(len(a)-1):            
            while(a[j] > a[j+1]):
                count+=1
                a[j], a[j+1] = a[j+1], a[j]
    
    print(f"Array is sorted in {count} swaps.")
    print(f"First Element: {a[0]}")
    print(f"Last Element: {a[len(a)-1]}")

#countSwaps([6,4,1])
    
def maximumToys(prices, k):
    sum = 0
    count = 0
    for price in sorted(prices):
        if(sum + price < k):
            count += 1
            sum += price
        else:
            return count

#print(maximumToys([1,12,5,111,200,1000,10],50))

def activityNotifications(expenditure, d):
    #grab the last d expenditures, sort, get median, then check current expenditure

     

    for i in range(d, len(expenditure)): 

        temp = sorted(expenditure[i-d:i])  #how can we improve efficiency by avoiding sorting a new array each time

        median = 0
        if(d%2==0):
            median =(temp[d//2] + temp[d//2-1]) / 2
        else:
            median = temp[d//2]
        
        if(expenditure[i] >= median*2):
            frauds += 1

    return frauds

def activityNotificationsCountSort(expenditure, d):
    #grab the last d expenditures, sort, get median, then check current expenditure

    def activityNotifications(expenditure, d):
    freq = {}
    notify=0
    def find(idx):
        total_count = 0
        for i in range(201): 
            if i in freq:
                total_count = total_count + freq[i]
            if total_count >= idx: 
                # when the total count of a number is greater or equal to the 
                # index we are searching for, we have found the correct i
                # this means that at position idx in the sorted mini-array, we would 
                #find element i
                return i
                
    for i in range(len(expenditure)-1):
        if expenditure[i] in freq:
            freq[expenditure[i]]+=1
        else:
            freq[expenditure[i]]=1
        #print(f"i: {i},val: {expenditure[i]}, freq: {freq}")
        if i>=d-1:
            if d%2 ==0:
                median = (find(d//2)+find(d//2+1))/2
            else:
                median = find(d/2)
            #print("median: ",median)
            if expenditure[i+1]>= (median*2) :
                notify +=1
                print("notify: ",notify)
            #remove the previous element from dictionary
            freq[expenditure[i-d+1]]-=1

    return notify  


                                        
                

    
   

activityNotificationsCountSort([10,20,30,40,50], 3)
activityNotificationsCountSort([2, 3, 4, 2, 3, 6, 8, 4, 5], 5)
    