#!/bin/bash

javac *.java */*.java -d class

cd class
jar -cvfm Calculator.jar ../Calculator.mf *.class */*.class

echo ""

java -jar Calculator.jar