#include <bits/stdc++.h>
using namespace std;

//Interface for observer for multiple types of observer we have just extend it and define concrete class 
class Observer {
public:
    virtual void update(string product_name)=0;
};

//Frist observer type 
class Customer : public Observer {
    string name;

public:
    Customer( string customer_name) {
        this->name=customer_name;
    }

    void update(string product_name)  {
        cout << "Hello " << name << ", " << product_name << " is now available in stock." << endl;
    }
};


//Second Observer type 
class Warehouse : public Observer {
public:
    void update(string product_name)  {
        cout << "Warehouse: " << product_name << " is now available in stock." << endl;
    }
};

//Third observer type
class MarketingTeam : public Observer {
public:
    void update( string product_name) override {
        cout << "Marketing Team: " << product_name << " is now available in stock." << endl;
    }
};

class Product {
    string name;
    bool available;
    vector<Observer*> observers;

public:
    Product(string product_name) {
        this->name=product_name;
        this->available=false;
        this->observers={};
    }

    void attach(Observer* observer) {
        observers.push_back(observer);
    }

    void detach(Observer* observer) {
        // Implementation to remove observer
    }

    void notify() {
        for (Observer* observer : observers) {
            observer->update(name);
        }
    }

    void changeStockStatus(bool is_available) {
        available = is_available;
        if (available) {
            cout << name << " is now available in stock!" << endl;
            notify();
        }
    }
};

int main() {
    Product apple_mobile("Apple Mobile");
    Product samsung_tv("Samsung TV");

    Customer john("John");
    Customer alice("Alice");
    Warehouse warehouse_observer;
    MarketingTeam marketing_observer;

    apple_mobile.attach(&john);
    apple_mobile.attach(&alice);
    apple_mobile.attach(&warehouse_observer);
    apple_mobile.attach(&marketing_observer);

    samsung_tv.attach(&alice);
    samsung_tv.attach(&warehouse_observer);

    // Assume Apple Mobile becomes available
    apple_mobile.changeStockStatus(true);

    // Assume Samsung TV becomes available
    samsung_tv.changeStockStatus(true);

    return 0;
}
