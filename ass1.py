def algo(num1,num2):
    if num1 < 10 or num2 < 10:
        return num1*num2


    n=max(len(str(num1)),len(str(num2)))
    half=n//2

    a=num1//(10**half)
    b=num1%(10**half)
    c=num2//(10**half)
    d=num2%(10**half)

    ac=algo(a,c)
    bd=algo(b,d)
    ad_bc=algo(a+b,c+d)-ac-bd

    result = ac * (10 ** (2 * half)) + ad_bc * (10 ** half) + bd
    return result

while(1):
    c1=int(input("Enter Your Choice: (1:For Multipication:) (2:For Square:)"))
    if(c1==1):
        num1=int(input("Enter No.1: "))
        num2=int(input("Enter No.2: "))
        result=algo(num1,num2)
        print("Ans is: ",result)

    if(c1==2):
        num1=int(input("Enter No.: "))
        result=algo(num1,num1)
        print("Ans is: ",result)

    
Output:
 Output:
 PS D:\OneDrive\Desktop\python> python ass1.py
 Enter a number: 1234
 Square is 1522756
