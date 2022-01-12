package controller;

import model.*;

import java.util.ArrayList;

public class DataController {

        static ArrayList<Vehicle> VehicleList = new ArrayList();
        static ArrayList<Driver> DriverList = new ArrayList();
        static ArrayList<String> VehicleTypeList = new ArrayList();
        static ArrayList<Park> ParkingList = new ArrayList();
        static ArrayList<Delivery> DeliveryList = new ArrayList();

    static SlotNumber[] vanSlot ={new SlotNumber("null","1"),new SlotNumber("null","2"),new SlotNumber("null","3"),new SlotNumber("null","4"),new SlotNumber("null","12"),new SlotNumber("null","13")};
    static SlotNumber[] busSlot ={new SlotNumber("null","14")};
    static SlotNumber[] cargoLorrySlot = {new SlotNumber("null","5"),new SlotNumber("null","6"),new SlotNumber("null","7"),new SlotNumber("null","8"),new SlotNumber("null","9"),new SlotNumber("null","10"),new SlotNumber("null","11")};

    static ArrayList<DriverSearch> driverSearch = new ArrayList();


       /* static ArrayList<SaveDriver> SaveDriverList = new ArrayList();

        public static ArrayList<Integer> VanSlotList = new ArrayList();
        public static ArrayList<Integer> BusSlotList = new ArrayList();
        public static ArrayList<Integer> LorrySlotList = new ArrayList();

    public static ArrayList<Integer> ParkVanSlotList = new ArrayList();
    public static ArrayList<Integer > ParkBusSlotList = new ArrayList();
    public static ArrayList<Integer > ParkLorrySlotList = new ArrayList();
*/


   /* static {
            VanSlotList.add(1);
            VanSlotList.add(2);
            VanSlotList.add(3);
            VanSlotList.add(4);
            VanSlotList.add(12);
            VanSlotList.add(13);
            BusSlotList.add(14);
            LorrySlotList.add(5);
            LorrySlotList.add(6);
            LorrySlotList.add(7);
            LorrySlotList.add(8);
            LorrySlotList.add(9);
            LorrySlotList.add(10);
            LorrySlotList.add(11);

        }*/
        static {
            VehicleTypeList.add("Bus");
            VehicleTypeList.add("Van");
            VehicleTypeList.add("Van");
            VehicleTypeList.add("Van");
            VehicleTypeList.add("Van");
            VehicleTypeList.add("Van");
            VehicleTypeList.add("Van");
            VehicleTypeList.add("Cargo Lorry");
            VehicleTypeList.add("Cargo Lorry");
            VehicleTypeList.add("Cargo Lorry");
            VehicleTypeList.add("Cargo Lorry");
            VehicleTypeList.add("Cargo Lorry");
            VehicleTypeList.add("Cargo Lorry");
            VehicleTypeList.add("Cargo Lorry");
        }
    }

