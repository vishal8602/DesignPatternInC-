// Command interface
public interface Command {
    void execute();
}

// Concrete Command for moving the player
public class MoveCommand implements Command {
    private Receiver receiver;
    private int x, y; // Destination coordinates

    public MoveCommand(Receiver receiver, int x, int y) {
        this.receiver = receiver;
        this.x = x;
        this.y = y;
    }

    @Override
    public void execute() {
        receiver.move(x, y);
    }
}

// Concrete Command for attacking an enemy
public class AttackCommand implements Command {
    private Receiver receiver;
    private String enemy;

    public AttackCommand(Receiver receiver, String enemy) {
        this.receiver = receiver;
        this.enemy = enemy;
    }

    @Override
    public void execute() {
        receiver.attack(enemy);
    }
}

// Concrete Command for using an item
public class UseItemCommand implements Command {
    private Receiver receiver;
    private String item;

    public UseItemCommand(Receiver receiver, String item) {
        this.receiver = receiver;
        this.item = item;
    }

    @Override
    public void execute() {
        receiver.useItem(item);
    }
}

// Receiver interface
public interface Receiver {
    void move(int x, int y);
    void attack(String enemy);
    void useItem(String item);
}

// Concrete Receiver representing the player character
public class Player implements Receiver {
    private String name;

    public Player(String name) {
        this.name = name;
    }

    @Override
    public void move(int x, int y) {
        System.out.println(name + " moves to coordinates (" + x + ", " + y + ")");
        // Logic to move player goes here
    }

    @Override
    public void attack(String enemy) {
        System.out.println(name + " attacks " + enemy);
        // Logic to attack enemy goes here
    }

    @Override
    public void useItem(String item) {
        System.out.println(name + " uses item: " + item);
        // Logic to use item goes here
    }
}
// Game manager class (Invoker)
public class GameManager {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void executeCommand() {
        command.execute();
    }
}

public class Client {
    public static void main(String[] args) {
        // Create receiver (player character)
        Receiver player = new Player("Hero");

        // Create commands
        Command moveCommand = new MoveCommand(player, 10, 5);
        Command attackCommand = new AttackCommand(player, "Dragon");
        Command useItemCommand = new UseItemCommand(player, "Health Potion");

        // Create game manager (player controller)
        GameManager gameManager = new GameManager();

        // Execute commands
        gameManager.setCommand(moveCommand);
        gameManager.executeCommand(); // Output: Hero moves to coordinates (10, 5)

        gameManager.setCommand(attackCommand);
        gameManager.executeCommand(); // Output: Hero attacks Dragon

        gameManager.setCommand(useItemCommand);
        gameManager.executeCommand(); // Output: Hero uses item: Health Potion
    }
}
