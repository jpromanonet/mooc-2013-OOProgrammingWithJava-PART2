package application;

public class ConstantSensor implements Sensor {

    private int reading;

    public ConstantSensor(int reading) {
        this.reading = reading;
    }

    @Override
    public boolean isOn() {
        return true;
    }

    @Override
    public void on() {
    }

    @Override
    public void off() {
    }

    @Override
    public int measure() {
        return this.reading;
    }

}