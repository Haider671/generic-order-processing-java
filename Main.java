public class Main {
    public static void main(String[] args) {

        ComputerOrder thinkPad = new ComputerOrder();

        Motherboard lenovoMotherboard = new Motherboard("Lenovo", 400);
        RAM lenovoRam = new RAM("LenovoRAM 16GB ", 16, 300);
        Drive lenovoDrive = new Drive(" 512 GB SSD", 512, 500);
        thinkPad.add(lenovoMotherboard);
        thinkPad.add(lenovoRam);
        thinkPad.add(lenovoDrive);
        thinkPad.add(new Printer("HP", 500));
        thinkPad.add(new Monitor("Acer", 200));
        thinkPad.add(new AssemblyService("Telus", 300));
        thinkPad.add(new DeliveryService("DHL Boeing 757", 1000));

        PartyTrayOrder cheese = new PartyTrayOrder();
        cheese.add(new Cheddar(20));
        cheese.add(new Mozzarella(25));
        cheese.add(new Apple(20));
        cheese.add(new Orange(30));
        cheese.add(new AssemblyService("Shaw", 300));
        cheese.add(new DeliveryService("PAN-AM Boeing 747-200B", 1000));

        OrderProcessor processor = new OrderProcessor();

        processor.accept(thinkPad);
        processor.accept(cheese);
        processor.process();

        processor.dispatchComputerParts();
        System.out.println();

        processor.dispatchPeripherals();
        System.out.println();

        processor.dispatchCheeses();
        System.out.println();

        processor.dispatchFruits();
        System.out.println();

        processor.dispatchServices();
    }
}