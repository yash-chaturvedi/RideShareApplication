package com.lld;

import com.lld.dao.RideManager;
import com.lld.dao.UserManager;
import com.lld.dao.VehicleManager;
import com.lld.model.Ride;
import com.lld.service.RideShareService;
import com.lld.service.UserService;
import com.lld.service.VehicleService;
import com.lld.model.MostVacantPolicy;
import com.lld.model.PreferredVehiclePolicy;

/**
 * @author Yash Chaturvedi
 */
public class RideShareApplication {

    public static void main(String[] args) {
        UserManager userManager = new UserManager();
        VehicleManager vehicleManager = new VehicleManager();
        RideManager rideManager = new RideManager();

        UserService userService = new UserService(userManager);
        VehicleService vehicleService = new VehicleService(vehicleManager, userManager);
        RideShareService rideShareService = new RideShareService(userManager, rideManager, vehicleManager);

        userService.addUser("Rohan", "M", 36);
        vehicleService.addVehicle("Rohan", "Swift", "KA-01-12345");

        userService.addUser("Shashank", "M", 29);
        vehicleService.addVehicle("Shashank", "Baleno", "TS-05-62395");

        userService.addUser("Nandini", "F", 29);

        userService.addUser("Shipra", "F", 27);
        vehicleService.addVehicle("Shipra", "Polo", "KA-05-41491");
        vehicleService.addVehicle("Shipra", "Activa", "KA-12-12332");

        userService.addUser("Gaurav", "M", 29);

        userService.addUser("Rahul", "M", 35);
        vehicleService.addVehicle("Rahul", "XUV", "KA-05-1234");

        System.out.println();
        Ride r1 = rideShareService.offerRide("Rohan", "Hyderabad", 1,
                "Swift", "KA-01-12345", "Bangalore");
        Ride r2 = rideShareService.offerRide("Shipra", "Bangalore", 1,
                "Activa", "KA-12-12332", "Mysore");
        Ride r3 = rideShareService.offerRide("Shipra", "Bangalore", 2,
                "Polo", "KA-05-41491", "Mysore");
        Ride r4 = rideShareService.offerRide("Shashank", "Hyderabad", 2,
                "Baleno", "TS-05-62395", "Bangalore");
        Ride r5 = rideShareService.offerRide("Rahul", "Hyderabad", 5,
                "XUV", "KA-05-1234", "Bangalore");
        Ride r6 = rideShareService.offerRide("Rohan", "Bangalore", 1,
                "Swift", "KA-01-12345", "Pune");

        System.out.println();
        MostVacantPolicy mostVacantPolicy = new MostVacantPolicy();
        Ride ride1 = rideShareService.selectRide("Nandini", "Bangalore", "Mysore",
                1, mostVacantPolicy);

        PreferredVehiclePolicy preferredVehiclePolicy = new PreferredVehiclePolicy("Activa");
        Ride ride2 = rideShareService.selectRide("Gaurav", "Bangalore", "Mysore",
                1, preferredVehiclePolicy);

        preferredVehiclePolicy.setPreferredVehicleModel("Baleno");
        Ride ride3 = rideShareService.selectRide("Rohan", "Mumbai", "Bangalore",
                1, preferredVehiclePolicy);

        preferredVehiclePolicy.setPreferredVehicleModel("Baleno");
        Ride ride4 = rideShareService.selectRide("Rohan", "Hyderabad", "Bangalore",
                1, preferredVehiclePolicy);

        preferredVehiclePolicy.setPreferredVehicleModel("Polo");
        Ride ride5 = rideShareService.selectRide("Shashank", "Hyderabad", "Bangalore",
                1, preferredVehiclePolicy);

        System.out.println();
        rideShareService.endRide(r1);
        rideShareService.endRide(r2);
        rideShareService.endRide(r3);
        rideShareService.endRide(r4);

        System.out.println();
        rideShareService.printRideStats();
    }
}
