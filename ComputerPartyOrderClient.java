/*
 * Client program used to test Part 2 of Assignment 2.
 *
 * This program demonstrates that a ComputerPartyOrder can
 * contain computer parts, peripherals, cheeses, fruits,
 * and services in a single order.
 */

public class ComputerPartyOrderClient {

    public static void main(String[] args) {

        // Create one combined computer/party order.
        ComputerPartyOrder total =
                new ComputerPartyOrder();

        // Add computer parts.
        total.add(new Motherboard("ACER", 400));
        total.add(new RAM("RAM 16GB", 16, 300));
        total.add(new Drive("Lenovo SSD", 22, 22));

        // Add peripherals.
        total.add(new Printer("HP", 500));
        total.add(new Monitor("Acer", 200));

        // Add computer-related services.
        total.add(new AssemblyService("Telus", 300));
        total.add(
                new DeliveryService(
                        "DHL Boeing 757", 1000));

        // Add cheeses.
        total.add(new Cheddar(20));
        total.add(new Mozzarella(25));

        // Add fruits.
        total.add(new Apple(20));
        total.add(new Orange(30));

        // Add additional services.
        total.add(new AssemblyService("Shaw", 300));
        total.add(
                new DeliveryService(
                        "PAN-AM Boeing 747-200B", 1000));

        // Create an OrderProcessor.
        OrderProcessor processor2 =
                new OrderProcessor();

        // Submit and process the ComputerPartyOrder.
        processor2.accept(total);
        processor2.process();

        // Display each processed category.
        System.out.println("COMPUTER PARTS");
        processor2.dispatchComputerParts();

        System.out.println();

        System.out.println("PERIPHERALS");
        processor2.dispatchPeripherals();

        System.out.println();

        System.out.println("CHEESES");
        processor2.dispatchCheeses();

        System.out.println();

        System.out.println("FRUITS");
        processor2.dispatchFruits();

        System.out.println();

        System.out.println("SERVICES");
        processor2.dispatchServices();
    }
}