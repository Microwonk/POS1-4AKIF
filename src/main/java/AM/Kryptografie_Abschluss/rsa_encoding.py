import sys

# Dieses Programm codiert Zahlen gemaess dem RSA-Algorithmus
# Eingabe: Die Teile n und a des oeffentlichen Schluessels sowie zu verschluesselnde Zahlen

n = input("Gib den Teil n des oeffentlichen Schluessels ein! ")
a = input("Gib den Teil a des oeffentlichen Schluessels ein! ")

yc=1
while yc!=0:
   text = "Gib eine zu verschluesselnde Nachricht ein, die kleiner als n = "\
          +str(n)+" ist "
   test = 0
   while test == 0:
      t = long(input(text))
      if t>=n:
         print "Eingabefehler: Nachricht ist groesser oder gleich n; Eingabe wiederholen! "
      else:
         test = 1

   tn = t%n
   x = tn
   for i in range(a-1):
      x=x*tn%n

   print "Die verschluesselte Nachricht lautet: ", x
   print ""

   answered = False
   while not answered:
      try:
         yc = input("Noch eine Nachricht verschluesseln? 1 fuer ja, 0 fuer nein eingeben ")
         if yc==0 or yc==1:
            answered = True
      except:
         print("Please answer the question!")

sys.stdin.readline()
