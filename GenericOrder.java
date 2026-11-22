import java.util.ArrayList;
import java.util.Collection;

/*
 * Base class for every product that can be placed in an order.
 * Generic container for an arbitrary number of Product objects.
 * T must be Product or a subclass of Product.
 *
 * Each GenericOrder receives a unique order ID.
 */

class GenericOrder<T extends Product> {

    protected Collection<T> products;

    // Shared counter used to generate unique order IDs.
    private static int counter = 1;

    // Unique ID belonging to this particular order.
    private final int id;

    public GenericOrder() {
        products = new ArrayList<T>();

        // Assign current counter value, then increment it.
        id = counter++;
    }

    /*
     * Allows subclasses to add products while keeping the collection
     * protected from unrelated client code.
     */
    protected void addProduct(T product) {
        products.add(product);
    }

    // Returns the unique identifier for this order.
    public int getId() {
        return id;
    }

    // Returns the products stored in this order.
    Collection<T> getProducts() {
        return products;
    }
}

/*
 * ComputerOrder only exposes add methods for computer parts,
 * peripherals, and services.
 */
class ComputerOrder extends GenericOrder<Product> {

    public ComputerOrder() {
        super();
    }

    public void add(ComputerPart part) {
        addProduct(part);
    }

    public void add(Peripheral peripheral) {
        addProduct(peripheral);
    }

    public void add(Service service) {
        addProduct(service);
    }
}

/*
 * PartyTrayOrder only exposes add methods for cheese,
 * fruit, and services.
 */
class PartyTrayOrder extends GenericOrder<Product> {

    public PartyTrayOrder() {
        super();
    }

    public void add(Cheese cheese) {
        addProduct(cheese);
    }

    public void add(Fruit fruit) {
        addProduct(fruit);
    }

    public void add(Service service) {
        addProduct(service);
    }
}

/*
 * Associates a product with the ID of the order that contained it.
 *
 * This performs a role similar to the TwoTuple example mentioned
 * in the assignment.
 */
class Identification<T extends Product> {

    public final T product;
    public final int orderId;

    public Identification(T product, int orderId) {
        this.product = product;
        this.orderId = orderId;
    }
}

/*
 * Accepts orders, processes their products, and sorts the products
 * into collections according to product type.
 */
class OrderProcessor {

    // Stores every order accepted by the processor.
    private Collection<GenericOrder<? extends Product>> orders =
            new ArrayList<GenericOrder<? extends Product>>();

    // Collections containing the processed product categories.
    private Collection<Identification<ComputerPart>> computerParts =
            new ArrayList<Identification<ComputerPart>>();

    private Collection<Identification<Peripheral>> peripherals =
            new ArrayList<Identification<Peripheral>>();

    private Collection<Identification<Cheese>> cheeses =
            new ArrayList<Identification<Cheese>>();

    private Collection<Identification<Fruit>> fruits =
            new ArrayList<Identification<Fruit>>();

    private Collection<Identification<Service>> services =
            new ArrayList<Identification<Service>>();

    /*
     * Accepts a GenericOrder or any subclass of GenericOrder.
     */
    public void accept(GenericOrder<? extends Product> order) {
        orders.add(order);
    }

    /*
     * Processes all accepted orders.
     *
     * Each product is placed in the appropriate collection and
     * associated with the unique ID of its original order.
     */
    public void process() {

        // Prevent duplicate results if process() is called more than once.
        computerParts.clear();
        peripherals.clear();
        cheeses.clear();
        fruits.clear();
        services.clear();

        for (GenericOrder<? extends Product> order : orders) {

            for (Product product : order.getProducts()) {

                if (product instanceof ComputerPart) {

                    computerParts.add(
                            new Identification<ComputerPart>(
                                    (ComputerPart) product,
                                    order.getId()));

                } else if (product instanceof Peripheral) {

                    peripherals.add(
                            new Identification<Peripheral>(
                                    (Peripheral) product,
                                    order.getId()));

                } else if (product instanceof Cheese) {

                    cheeses.add(
                            new Identification<Cheese>(
                                    (Cheese) product,
                                    order.getId()));

                } else if (product instanceof Fruit) {

                    fruits.add(
                            new Identification<Fruit>(
                                    (Fruit) product,
                                    order.getId()));

                } else if (product instanceof Service) {

                    services.add(
                            new Identification<Service>(
                                    (Service) product,
                                    order.getId()));
                }
            }
        }
    }

    /*
     * Simulates dispatching all processed computer parts.
     */
    public void dispatchComputerParts() {

        for (Identification<ComputerPart> item : computerParts) {

            System.out.print(
                    item.product.getClass().getSimpleName() + " - ");

            if (item.product instanceof Motherboard) {

                Motherboard motherboard = (Motherboard) item.product;

                System.out.print(
                        "name=" + motherboard.getManufacturer()
                                + ", price=$" + motherboard.price()
                                + ", order number=" + item.orderId);

            } else if (item.product instanceof RAM) {

                RAM ram = (RAM) item.product;

                System.out.print(
                        "name=" + ram.getManufacturer()
                                + ", size=" + ram.getSize()
                                + ", price=$" + ram.price()
                                + ", order number=" + item.orderId);

            } else if (item.product instanceof Drive) {

                Drive drive = (Drive) item.product;

                System.out.print(
                        "type=" + drive.getType()
                                + ", speed=" + drive.getSpeed()
                                + ", price=$" + drive.price()
                                + ", order number=" + item.orderId);
            }

            System.out.println();
        }
    }

    /*
     * Simulates dispatching all processed peripherals.
     */
    public void dispatchPeripherals() {

        for (Identification<Peripheral> item : peripherals) {

            System.out.print(
                    item.product.getClass().getSimpleName() + " - ");

            if (item.product instanceof Printer) {

                Printer printer = (Printer) item.product;

                System.out.print(
                        "model=" + printer.getModel()
                                + ", price=$" + printer.price()
                                + ", order number=" + item.orderId);

            } else if (item.product instanceof Monitor) {

                Monitor monitor = (Monitor) item.product;

                System.out.print(
                        "model=" + monitor.getModel()
                                + ", price=$" + monitor.price()
                                + ", order number=" + item.orderId);
            }

            System.out.println();
        }
    }

    /*
     * Simulates dispatching all processed cheeses.
     */
    public void dispatchCheeses() {

        for (Identification<Cheese> item : cheeses) {

            System.out.println(
                    item.product.getClass().getSimpleName()
                            + " - price=$" + item.product.price()
                            + ", order number=" + item.orderId);
        }
    }

    /*
     * Simulates dispatching all processed fruits.
     */
    public void dispatchFruits() {

        for (Identification<Fruit> item : fruits) {

            System.out.println(
                    item.product.getClass().getSimpleName()
                            + " - price=$" + item.product.price()
                            + ", order number=" + item.orderId);
        }
    }

    /*
     * Simulates dispatching all processed services.
     */
    public void dispatchServices() {

        for (Identification<Service> item : services) {

            System.out.print(
                    item.product.getClass().getSimpleName() + " - ");

            if (item.product instanceof AssemblyService) {

                AssemblyService service =
                        (AssemblyService) item.product;

                System.out.print(
                        "provider=" + service.getProvider()
                                + ", price=$" + service.price()
                                + ", order number=" + item.orderId);

            } else if (item.product instanceof DeliveryService) {

                DeliveryService service =
                        (DeliveryService) item.product;

                System.out.print(
                        "courier=" + service.getCourier()
                                + ", price=$" + service.price()
                                + ", order number=" + item.orderId);
            }

            System.out.println();
        }
    }
}