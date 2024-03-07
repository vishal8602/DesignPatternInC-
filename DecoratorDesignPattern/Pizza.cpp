#include <bits/stdc++.h>
using namespace std;


class Pizza
{
public:
    virtual int price() = 0;
};


class BasePizza : public Pizza
{
public:
    int price()
    {
        cout << " Base Pizza added\n ";
        return 10;
    }
};


class FarmhousePizza : public Pizza
{
public:
    int price()
    {
        cout << "Farmhouse Pizza added \n";
        return 20;
    }
};


class ToppingDecorator : public Pizza
{
};


class chessDecorator : public ToppingDecorator
{
public:
    Pizza *pizzaType;
    chessDecorator(Pizza *pizzaType)
    {
        this->pizzaType = pizzaType;
    };
    int price()
    {
        cout << "chess  added \n";
        return pizzaType->price() + 20;
    }
};


class cornDecorator : public ToppingDecorator
{
public:
    Pizza *pizzaType;
    cornDecorator(Pizza *pizzaType)
    {
        this->pizzaType = pizzaType;
    };
    int price()
    {
        cout << "corn  added \n";
        return pizzaType->price() + 30;
    }
};


int main()
{
    cout << "started";
    Pizza *basePizza = new BasePizza();
    Pizza *farmHousePizza = new FarmhousePizza();


    Pizza *withChess = new chessDecorator(new BasePizza());
    withChess->price();
    Pizza *withChessAndCorn = new cornDecorator(new chessDecorator(new BasePizza()));
    withChessAndCorn->price();
}

