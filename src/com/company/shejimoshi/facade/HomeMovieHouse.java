package com.company.shejimoshi.facade;

// 外观类：家庭影院外观
public class HomeMovieHouse {
    private StereaSystem stereo;
    private Projector projector;
    private LightsControl lights;

    public void watchMovie() {
        stereo.turnOn();
        projector.turnOn();
        lights.turnOn();
    }

    public void endMovie() {
        stereo.turnOn();
        projector.turnOn();
        lights.turnOn();
    }

    public HomeMovieHouse() {
        stereo = new StereaSystem();
        projector = new Projector();
        lights = new LightsControl();
    }
}
