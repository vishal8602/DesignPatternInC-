// 

// Subsystem classes
class DVDPlayer {
    void on() { System.out.println("DVD Player is on"); }
    void play(String movie) { System.out.println("Playing " + movie); }
    void off() { System.out.println("DVD Player is off"); }
}

class Projector {
    void on() { System.out.println("Projector is on"); }
    void setInput(String input) { System.out.println("Projector input set to " + input); }
    void off() { System.out.println("Projector is off"); }
}

class SoundSystem {
    void on() { System.out.println("Sound System is on"); }
    void setVolume(int volume) { System.out.println("Sound System volume set to " + volume); }
    void off() { System.out.println("Sound System is off"); }
}

class Lights {
    void dim(int level) { System.out.println("Lights dimmed to " + level + "%"); }
    void on() { System.out.println("Lights are on"); }
}

// Facade class
class HomeTheaterFacade {
    private DVDPlayer dvdPlayer;
    private Projector projector;
    private SoundSystem soundSystem;
    private Lights lights;

    public HomeTheaterFacade(DVDPlayer dvdPlayer, Projector projector, SoundSystem soundSystem, Lights lights) {
        this.dvdPlayer = dvdPlayer;
        this.projector = projector;
        this.soundSystem = soundSystem;
        this.lights = lights;
    }

    public void watchMovie(String movie) {
        System.out.println("Get ready to watch a movie...");
        lights.dim(10);
        projector.on();
        projector.setInput("DVD");
        soundSystem.on();
        soundSystem.setVolume(20);
        dvdPlayer.on();
        dvdPlayer.play(movie);
    }

    public void endMovie() {
        System.out.println("Shutting down the home theater...");
        lights.on();
        projector.off();
        soundSystem.off();
        dvdPlayer.off();
    }
}

// Client code
public class FacadePatternExample {
    public static void main(String[] args) {
        DVDPlayer dvdPlayer = new DVDPlayer();
        Projector projector = new Projector();
        SoundSystem soundSystem = new SoundSystem();
        Lights lights = new Lights();

        HomeTheaterFacade homeTheater = new HomeTheaterFacade(dvdPlayer, projector, soundSystem, lights);

        homeTheater.watchMovie("Inception");
        // After watching
        homeTheater.endMovie();
    }
}
