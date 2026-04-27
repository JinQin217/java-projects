# Custom Die Class (Java)

## Overview
An object-oriented implementation of a customizable die with dynamic face labels and random rolling functionality.

## Features
- Supports any number of faces with custom labels
- Random roll functionality using a uniform distribution
- Implements Comparable for value comparison
- Overrides equals and hashCode methods
- Includes multiple constructors

## Example Usage
Die d1 = new Die("A", "B", "C");
d1.Roll();
System.out.println(d1.GetValue());

## Motivation
This project was built to practice object-oriented programming concepts such as encapsulation, constructors, and method overriding.

## Concepts Used
- Object-Oriented Programming (OOP)
- Encapsulation
- Class invariants

## How to Run
1. Compile:<br>
   javac Die.java
2. Run:<br>
   java MagicSquare
