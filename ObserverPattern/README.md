# Overview:
      The Observer Design Pattern is a behavioral pattern
       where an object, known as the subject, maintains a 
        list of its dependents, called observers, and 
         notifies them of any state changes, usually by 
          calling one of their methods.

# Example:
      Consider an e-commerce platform like Flipkart or     Amazon. When a customer is interested in a product        that is currently out of stock, they     can opt to be notified when the item becomes available again. In this scenario:

      The customer acts as the observer.
      The product acts as the subject.
      The e-commerce platform manages the communication between the product and the customer.
# Implementation:
### Subject Interface:
    Defines methods for adding, removing, and notifying observers.
### Concrete Subject: 
      Implements the subject interface and maintains the list of observers. Notifies observers of any state changes.
### Observer Interface: 
      Declares the method that the subject uses to notify observers.
### Concrete Observer: 
      Implements the observer interface and defines the behavior to be executed when notified by the subject.
### Client:
      Creates instances of concrete subjects and observers, and establishes the relationships between them.
### Benefits:
      Loose Coupling: Subjects and observers can interact without having explicit knowledge of each other.
### Flexibility: 
      Allows for dynamic relationships between objects, enabling changes to one object without affecting others.
### Reusability: 
     Observers can be reused across different subjects, promoting code modularization and reusability.

# Example Code (C++):