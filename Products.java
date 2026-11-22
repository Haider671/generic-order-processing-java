abstract class Product {
    protected float price;

    // Returns the price of a product.
    abstract float price();
}

/*
 * Base class for computer parts.
 */
class ComputerPart extends Product {

    public ComputerPart(float p) {
        price = p;
    }

    public float price() {
        return price;
    }
}

/*
 * Represents a motherboard.
 */
class Motherboard extends ComputerPart {
    protected String manufacturer;

    public Motherboard(String mfg, float p) {
        super(p);
        manufacturer = mfg;
    }

    public String getManufacturer() {
        return manufacturer;
    }
}

/*
 * Represents computer RAM.
 */
class RAM extends ComputerPart {
    protected int size;
    protected String manufacturer;

    public RAM(String mfg, int size, float p) {
        super(p);
        this.manufacturer = mfg;
        this.size = size;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getSize() {
        return size;
    }
}

/*
 * Represents a computer drive.
 */
class Drive extends ComputerPart {
    protected String type;
    protected int speed;

    public Drive(String type, int speed, float p) {
        super(p);
        this.type = type;
        this.speed = speed;
    }

    public String getType() {
        return type;
    }

    public int getSpeed() {
        return speed;
    }
}

/*
 * Base class for peripheral devices.
 */
class Peripheral extends Product {

    public Peripheral(float p) {
        price = p;
    }

    public float price() {
        return price;
    }
}

/*
 * Represents a printer peripheral.
 */
class Printer extends Peripheral {
    protected String model;

    public Printer(String model, float p) {
        super(p);
        this.model = model;
    }

    public String getModel() {
        return model;
    }
}

/*
 * Represents a monitor peripheral.
 */
class Monitor extends Peripheral {
    protected String model;

    public Monitor(String model, float p) {
        super(p);
        this.model = model;
    }

    public String getModel() {
        return model;
    }
}

/*
 * Base class for services.
 */
class Service extends Product {

    public Service(float p) {
        price = p;
    }

    public float price() {
        return price;
    }
}

/*
 * Represents an assembly service.
 */
class AssemblyService extends Service {
    private String provider;

    public AssemblyService(String pv, float p) {
        super(p);
        provider = pv;
    }

    public String getProvider() {
        return provider;
    }
}

/*
 * Represents a delivery service.
 */
class DeliveryService extends Service {
    private String courier;

    public DeliveryService(String c, float p) {
        super(p);
        courier = c;
    }

    public String getCourier() {
        return courier;
    }
}

/*
 * Base class for cheese products.
 */
class Cheese extends Product {

    public Cheese(float p) {
        price = p;
    }

    public float price() {
        return price;
    }
}

/*
 * Specific types of cheese.
 */
class Cheddar extends Cheese {

    public Cheddar(float p) {
        super(p);
    }
}

class Mozzarella extends Cheese {

    public Mozzarella(float p) {
        super(p);
    }
}

/*
 * Base class for fruit products.
 */
class Fruit extends Product {

    public Fruit(float p) {
        price = p;
    }

    public float price() {
        return price;
    }
}

/*
 * Specific types of fruit.
 */
class Apple extends Fruit {

    public Apple(float p) {
        super(p);
    }
}

class Orange extends Fruit {

    public Orange(float p) {
        super(p);
    }
}