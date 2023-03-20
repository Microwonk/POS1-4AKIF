import sys
#Programm zur Berechnung des ggT zweier einzugebender positiver ganzer Zahlen a und b
#Das Programm benutzt den Euklidischen Algorithmus

print "Hier ist ein Programm zur Berechnung des ggT zweier natuerlicher Zahlen. "
a = input("Gib die erste natuerliche Zahl ein: ")
b = input("Gib die zweite natuerliche Zahl ein: ")

a1=a 
b1=b
r = a1%b1     #   "%" steht fuer die Modulo-Funktion
while r != 0:
   a1 = b1
   b1 = r
   r = a1%b1

print "Der ggT der Zahlen ",a," und ", b, " ist ", b1
sys.stdin.readline()
