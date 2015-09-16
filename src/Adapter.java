// Используется, если имеется класс, который имеет несовместимый интерфейс. Для этого создается еще один итерфейс для
// доступа к этому классу и адаптер, который находится между интерфейсом и этим классом.

class FahrenheitSensor {
    public float getFarenheitTemp() {
        float t = 32.0f;
        return t;
    }
}

interface Sensor {
    float getTemp();
}

class TempAdapter implements Sensor {
    private FahrenheitSensor fahrenheitSensor = null;
    public TempAdapter(FahrenheitSensor s) {
        fahrenheitSensor = s;
    }

    public float getTemp() {
        return (fahrenheitSensor.getFarenheitTemp()-32.0f)*5.0f/9.0f;
    }
}

public class Adapter {
    public static void main(String[] args) {
        Sensor s = new TempAdapter(new FahrenheitSensor());
        System.out.println(s.getTemp());
    }
}
