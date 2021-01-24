#Sales by match

def sockMerchant(n,ar): 
    return sum([ar.count(sock)//2 for sock in set(ar)])
   

#print(sockMerchant(9, [10,20,20,10,10,30,50,10,20,]))

#Counting Valleys


def countingValleys(steps, path):
    count = 0
    valleys = 0
    for letter in path:
        if letter=='D':
            if count == 0:
                valleys +=1
            count-=1
        elif letter=='U':
            count+=1
    return valleys
        

#print(countingValleys(8, "DDUUUUDD"))

#Jumping on the clouds

def jumpingOnClouds(c):
    jumps = 0
    zeroes = 0
    for cloud in c:
        if cloud == 0:
            zeroes += 1
        if cloud == 1:
            jumps += 1
            jumps += zeroes // 2
            zeroes = 0
    jumps += zeroes // 2

    return jumps
    

#print(jumpingOnClouds([0,1,0,0,0,1,0]))

#Repeated String

def repeatedString(s, n):
    
    
    return s.count("a") * (n // len(s)) +  s[:n % len(s)].count("a")
    
    

print(repeatedString("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", 534802106762)) # 534802106762
print(repeatedString("afcfffaged", 962645758455)) # 192529151691