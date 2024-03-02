#include <bits/stdc++.h>
using namespace std;

// Strategy interface
class SpeedStrategy {
public:
    virtual void speed() = 0;
};

// Concrete strategy classes
class HighSpeedStrategy : public SpeedStrategy {
public:
    void speed() {
        // Implementation for high-speed vehicles
        cout<<"Vehical have HighSpeedStrategy"<<"\n";
    }
};

class NormalSpeedStrategy : public SpeedStrategy {
public:
    void speed()  {
        // Implementation for normal-speed vehicles
        cout<<"Vehical have NormalSpeedStrategy"<<"\n";
    }
};

// Context class
class Vehicle {
private:
    SpeedStrategy* speedStrategy;

public:
    Vehicle(SpeedStrategy* strategy) {
        speedStrategy = strategy;
    }

    void move() {
        // Move the vehicle
        speedStrategy->speed(); // Delegate speed behavior to the strategy
    }
};

// Usage
int main() {
    HighSpeedStrategy highSpeed;
    NormalSpeedStrategy normalSpeed;

    Vehicle sportsCar(&highSpeed);
    Vehicle normalCar(&normalSpeed);
    Vehicle truck(&highSpeed);

    sportsCar.move();
    normalCar.move();
    truck.move();


    return 0;
}
