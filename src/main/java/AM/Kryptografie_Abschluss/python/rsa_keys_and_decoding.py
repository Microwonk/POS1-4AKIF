import sys

# Dieses Programm dient zur Durchfuehrung des RSA-Verfahrens.
# Der erste Teil des Hauptprogramms berechnet den oeffentlichen Schluessel.
# Der zweite Teil das multiplikative Inverse zu a modulo m.
# Im dritten Teil des Hauptprogramms werden Nachrichten entschluesselt.
# Mit dem im gleichen Ordner befindlichen Programm rsa_encoding.py 
# koennen Nachrichten (Zahlen) verschluesselt werden.

def multinv(a,m):
# Funktion zur Berechnung des multiplikativen Inversen einer Zahl a
# modulo einer Zahl m
# Die Funktion benutzt den Euklidischen Algorithmus
   r = range(m)
   t = range(m)
   s = range(m)
   d = range(m)
   r[0]=m 
   r[1]=a
   r[2] = r[0]%r[1]
   t[0] = r[0] / r[1]
   i=2
   while r[i]!= 1:
      t[i-1] = r[i-1] / r[i]
      i = i+1
      r[i] = r[i-2]%r[i-1]
   ie = i-1   
   s[ie] = 1
   d[ie] = - t[ie-1]
   for i in range(ie-1,0,-1):
      s[i] = d[i+1]
      d[i] = s[i+1] - d[i+1] *t[i-1]
   d[1]= d[1]%m
   return d[1]

def ggteuklid(a,b):
# Funktion zur Bestimmung des ggT der beiden Zahlen a und b
# mit dem Euklidischen Algorithmus
   a1=a 
   b1=b
   r = a1%b1
   while r != 0:
      a1 = b1
      b1 = r
      r = a1%b1
   return b1

#################
# HAUPTPROGRAMM #
#################

#Erster Teil des Hauptprogramms: Berechnung des oeffentlichen Schluessels

p = input("Gib eine Primzahl p ein: ")
q=p
while q==p:
   q = input("Gib eine von p verschiedene Primzahl q ein: ")

n = p * q
m = (p-1)*(q-1)

#DER FOLGDENDE PRINT-BEFEHL KANN ZU KONTROLLZWECKEN AKTIVIERT WERDEN.
#DIE ZAHL M SOLLTE UNBEDINGT GEHEIM BLEIBEN; DENN JEDER, DER DIESE ZAHL
#ODER DIE PRIMZAHLEN P UND Q KENNT, KANN NACHRICHTEN PROBLEMLOS ENTSCHLUESSELN
#print "m = ",m

test = 0
while test == 0:
   a = input("Gib eine Zahl a ein, die zu m=(p-1)(q-1) teilerfremd ist: ")
   #Check, ob m und a teilerfremd sind
   t = ggteuklid(m,a)
   if t==1:
      test=1
   else:
      print "die Zahlen m = ",m," und a = ",a," sind nicht teilerfremd. Ihr ggT ist ",t

print
print " Der oeffentliche Schluessel besteht aus den Zahlen n = ",n," und a = ", a
print

#Zweiter Teil des Hauptprogramms:
   # Berechnung des multiplikativen Inversen zu a modulo m:
        # Das simple Ausprobieren wuerde bedeuten:
           # b = a
           # i = 1
           # while b != 1:
           #    i = i + 1
           #    b = (a*i)%m
           # b = i
        # Dies kann aber sehr lange dauern, wenn m sehr gross ist, und das
        # ist die Regel!
        # Daher wird im folgenden Funktionsaufruf der erweiterte
        # Euklidische Algorithmus verwendet

b = multinv(a,m)

#Dritter Teil des Hauptprogramms: Entschluesseln von Nachrichten

yc = input("eine Nachricht entschluesseln? 1 fuer ja, 0 fuer nein eingeben ")
while yc != 0:
   text = "Gib eine verschluesselte Nachricht ein, die kleiner als n = "\
          +str(n)+" ist "
   test = 0
   while test == 0:
      y = input(text)
      if y>=n:
         print "Eingabefehler: y ist groesser oder gleich n; Eingabe wiederholen!"
      else:
         test = 1
   x = y
   for i in range(b-1):
      x=x*(y%n)%n

   print "x = ", x
   print
   yc = input("noch eine Nachricht entschluesseln? 1 fuer ja, 0 fuer nein eingeben ")
sys.stdin.readline()
