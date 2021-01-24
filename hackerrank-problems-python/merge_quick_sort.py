def quicksort(arr):
    quicksortHelper(arr,0,len(arr)-1)

def quicksortHelper(arr,first,last):

    if(first<last):
        mid = partition(arr,first,last)
        quicksortHelper(arr,first,mid-1)
        quicksortHelper(arr,mid+1,last)


def partition(arr,first,last):
    pivot = arr[first]
    left = first+1
    right = last

    done = False

    while not done:
        while left<=right and arr[left]<=pivot:
            left += 1
        
        while arr[right] >= pivot and right >= left:
            right -= 1

        if right < left:
            done = True
        else:
            arr[left], arr[right] = arr[right], arr[left]

    arr[first], arr[right] = arr[right], arr[first]

    return right


tobe = [3,44,38,5,47,15,36,26,27,2,46,4,19,50,48]


#quicksort(tobe)
#print(tobe)

def mergeSort(arr):

    if len(arr)>1:
        mid = len(arr)//2
        leftArr = arr[:mid] 
        rightArr = arr[mid:] 

        mergeSort(leftArr)
        mergeSort(rightArr)

        i = 0
        j = 0
        k = 0

        while i < len(leftArr) and j < len (rightArr):
            if leftArr[i] < rightArr[j]:
               arr[k] = leftArr[i]
               i+=1
            else:
                arr[k] = rightArr[i]
                j+=1
            k+=1

        while i < len(leftArr):
            arr[k] = leftArr[i]
            k+=1
            i+=1

        while j < len(rightArr):
            arr[k] = rightArr[j]
            k+=1
            j+=1
        
threebe = [3,44,38,5,47,15,36,26,27,2,46,4,19,50,48]

mergeSort(threebe)
print(threebe)