@echo off
echo Kompiluje zrodla
javac *.java
echo Kompilacja zakonczona powodzeniem
echo Tworzenie stuba
rmic CalculatorServer
echo Stub utworzony, trwa przygotowanie do rejestracji uslugi
echo Uruchom plik serwer.bat / Nie wylaczaj tego pliku 
rmiregistry 2005
PAUSE