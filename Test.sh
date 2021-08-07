#!/bin/bash

javac *.java */*.java -d class
cd class

echo ""

java Calculator