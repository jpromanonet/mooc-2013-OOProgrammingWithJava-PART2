package application;

import java.util.ArrayList;
import java.util.List;

public class AverageSensor implements Sensor {
    private List<Sensor> averageSensor;
    private List<Integer> readings;

    public AverageSensor() {
        this.averageSensor = new ArrayList<Sensor>();
        this.readings = new ArrayList<Integer>();
    }

    public void addSensor(Sensor additional) {
        this.averageSensor.add(additional);
    }

    @Override
    public boolean isOn() {
        for (Sensor sensor : this.averageSensor) {
            if (sensor.isOn() == false) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void on() {
        for (Sensor sensor : this.averageSensor) {
            sensor.on();
        }
    }

    @Override
    public void off() {
        for (Sensor sensor : this.averageSensor) {
            sensor.off();
        }
    }

    @Override
    public int measure() {
        if (this.isOn() == false || this.averageSensor.size() == 0) {
            throw new IllegalStateException();
        }

        int reading = 0;
        for (Sensor sensor : this.averageSensor) {
            reading += sensor.measure();
        }
        reading /= this.averageSensor.size();
        this.readings.add(reading);
        return reading;
    }

    public List<Integer> readings() {
        return this.readings;
    }


}