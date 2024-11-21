 Code:

 def square(x):
 if x < 10:
 return x * x
 n = len(str(x))
 mid=n//2
 a = x // (10 ** mid)
 b = x % (10 ** mid)
 # Recursive calls
 a2 = square(a)
 b2 = square(b)
 ab = square(a + b) - a2 - b2
 return a2 * (10 ** (2 * mid)) + ab * (10 ** mid) + b2
 n = int(input("Enter a number: "))
 print("Square is " + str(square(n)))

 Output:
 PS D:\OneDrive\Desktop\python> python DAA1.py
 Enter a number: 1234
 Square is 1522756
