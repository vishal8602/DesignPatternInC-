#include <bits/stdc++.h>
using namespace std;


// Interfrence fro strategy
class doCalculation{
    public:
      virtual int calculate(int a ,int b);
};

// Define Strategy concrete class
class add :public doCalculation{
     public:
     int calculate(int a,int b){
        cout<< "Result of addition of "<<a <<" "<< b << "is" <<a+b <<"\n";
         return a+b;
     }
};
class sub :public doCalculation{
     public:
     int calculate(int a,int b){
        cout<< "Result of subtraction of "<<a <<" "<< b << "is" <<a-b<<"\n";
         return a-b;
     }
};
class mul :public doCalculation{
     public:
     int calculate(int a,int b){
        cout<< "Result of multiplication of "<<a <<" "<< b << "is" <<a*b <<"\n";
         return a*b;
     }
};
class divSion :public doCalculation{
     public:
     int calculate(int a,int b){
        cout<< "Result of division of "<<a <<" "<< b << "is" <<a/b <<"\n";
        return a/b;
     }
};

class calculator{
  private:
         doCalculation* strategy;
  public:
     calculator(doCalculation* strategy){
              this->strategy=strategy;
     }
     void setStrategy(doCalculation* strategy){
              this->strategy=strategy;
     }
     int result(int a,int b){
        return strategy->calculate(a,b);
     }
};


int main(){
    divSion divideStartegy;
    add adderStrategy;
    sub subtractorStrategy;
    mul multilyStategy;

    // calculator calciForDivision(&divideStartegy);
    // calciForDivision.result(20,10);
 
    // calculator calciForAddition(&adderStrategy);
    // calciForAddition.result(20,10);

    // calculator calciForSub(&subtractorStrategy);
    // calciForSub.result(20,10);

    // calculator calciForMul(&multilyStategy);
    // calciForMul.result(20,10);

    // another way to do 
    calculator calciForDivision(&divideStartegy);
    calciForDivision.result(20,10);


    calciForDivision.setStrategy(&adderStrategy);
    calciForDivision.result(20,10);
 
}