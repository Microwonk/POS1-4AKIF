import sys
#Programm zur Berechnung des multiplikativen Inversen einer Zahl a modulo einer Zahl m
#Das Programm benutzt den Euklidischen Algorithmus

def ggteuklid(a,b):
   # dieses Programm bestimmt den ggT der beiden Zahlen a und b
   # mit dem euklidischen Algorithmus
   a1=a 
   b1=b
   r = a1%b1
   while r != 0:
      a1 = b1
      b1 = r
      r = a1%b1
   return b1

print "Dies ist ein Programm zur Berechnung des multiplikativen Inversen einer Zahl a modulo einer Zahl m. "
print "Achtung: a und m muessen teilerfremd und groesser als 1 sein "

test=0
while test==0:
   m = input("Gib die Zahl m ein: ")
   a = input("Gib die Zahl a ein: ")

#Check, ob m und a teilerfremd sind
   t = ggteuklid(m,a)
   if t==1:
      test=1
   else:
      print "Die Zahlen m = ",m," und a = ",a," sind nicht teilerfremd. Ihr ggT ist ",t
r = range(m)
c = range(m)
d = range(m)
r[0] = m 
r[1] = a
c[0] = 1
c[1] = 0
d[0] = 0
d[1] = 1
i=1
while r[i]!= 1:
   i = i+1
   factor = r[i-2] / r[i-1]
   r[i] = r[i-2]%r[i-1]
   c[i] = c[i-2]-factor*c[i-1]
   d[i] = d[i-2]-factor*d[i-1]

b = d[i]%m
print " Multiplikatives Inverses von ",a," modulo ",m," ist b = ", b

#Probe:
test = (b* a)% m
print 'Probe: (b*a) modulo m = ',  test
sys.stdin.readline()
