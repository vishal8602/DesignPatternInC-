# Design Pattern In C++

# 1.Strategy Design Pattern
## Overview:
    When multiple classes inherit from a common parent class and some of these child classes share similar functionalities, the Strategy Design Pattern can be employed. This pattern allows different behaviors to be defined as separate classes, which can then be selected and used interchangeably within the context of the parent class.

## Example:
     Consider a scenario where we have a parent class called Vehicle, and several child classes extending its functionality:

    SportsVehicle
    NormalVehicle
    HeavyLoadVehicle

    Each of these classes needs to implement a speed function, but the implementation may vary based on the type of vehicle.

# Implementation:
    The Strategy Design Pattern can be applied as follows:

    Define an interface or base class SpeedStrategy that declares the speed method.
    Create concrete strategy classes:
    HighSpeedStrategy for sports and heavy load vehicles, providing a faster speed implementation.
    NormalSpeedStrategy for normal vehicles, implementing the standard speed behavior.
    In the Vehicle class, include a reference to the SpeedStrategy interface.
    Allow vehicles to set their speed strategy dynamically or during instantiation.
# Benefits:
    Promotes code reusability by encapsulating behavior in separate strategy classes.
    Enables easy addition of new behaviors without modifying existing classes.
    Improves maintainability and flexibility of the codebase.

# Example Code (C++):
    In  Strategy Directory 