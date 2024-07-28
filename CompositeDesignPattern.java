import java.util.ArrayList;
import java.util.List;

// Component
interface GUIComponent {
    void render();
    void addComponent(GUIComponent component);
    void removeComponent(GUIComponent component);
}

// Leaf
class Button implements GUIComponent {
    private String label;

    public Button(String label) {
        this.label = label;
    }

    @Override
    public void render() {
        System.out.println("Rendering Button: " + label);
    }

    @Override
    public void addComponent(GUIComponent component) {
        // Leaf cannot add components
        throw new UnsupportedOperationException();
    }

    @Override
    public void removeComponent(GUIComponent component) {
        // Leaf cannot remove components
        throw new UnsupportedOperationException();
    }
}

// Leaf
class TextField implements GUIComponent {
    private String text;

    public TextField(String text) {
        this.text = text;
    }

    @Override
    public void render() {
        System.out.println("Rendering TextField: " + text);
    }

    @Override
    public void addComponent(GUIComponent component) {
        // Leaf cannot add components
        throw new UnsupportedOperationException();
    }

    @Override
    public void removeComponent(GUIComponent component) {
        // Leaf cannot remove components
        throw new UnsupportedOperationException();
    }
}

// Composite
class Panel implements GUIComponent {
    private String name;
    private List<GUIComponent> components = new ArrayList<>();

    public Panel(String name) {
        this.name = name;
    }

    @Override
    public void render() {
        System.out.println("Rendering Panel: " + name);
        for (GUIComponent component : components) {
            component.render();
        }
    }

    @Override
    public void addComponent(GUIComponent component) {
        components.add(component);
    }

    @Override
    public void removeComponent(GUIComponent component) {
        components.remove(component);
    }
}

// Client
public class GUICompositePatternDemo {
    public static void main(String[] args) {
        GUIComponent button1 = new Button("Submit");
        GUIComponent button2 = new Button("Cancel");
        GUIComponent textField = new TextField("Enter your name");

        Panel panel = new Panel("Main Panel");
        panel.addComponent(button1);
        panel.addComponent(button2);
        panel.addComponent(textField);

        panel.render();
    }
}
