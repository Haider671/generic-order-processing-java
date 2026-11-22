/*
 *
 * It can contain computer parts, peripherals, cheeses,
 * fruits, and services in the same order.
 */

public class ComputerPartyOrder extends GenericOrder<Product> {
    public ComputerPartyOrder() {
        super();
    }

    public void add(ComputerPart part) {
        products.add(part);
    }

    public void add(Peripheral peripheral) {
        products.add(peripheral);
    }

    public void add(Service service) {
        products.add(service);
    }

    public void add(Cheese cheese) {
        products.add(cheese);
    }

    public void add(Fruit fruit) {
        products.add(fruit);
    }
}