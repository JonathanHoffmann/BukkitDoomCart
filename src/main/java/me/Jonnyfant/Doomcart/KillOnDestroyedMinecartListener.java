package me.Jonnyfant.Doomcart;

import org.bukkit.entity.Minecart;
import org.bukkit.entity.Player;
import org.bukkit.entity.Vehicle;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleDestroyEvent;

import java.util.List;

public class KillOnDestroyedMinecartListener implements Listener {
    @EventHandler
    public void onDestroyedMinecart(VehicleDestroyEvent event) {
        Vehicle vehicle = event.getVehicle();
        List passengers = vehicle.getPassengers();
        if (vehicle instanceof Minecart) {
            for (int i = 0; i < passengers.size(); i++) {
                if (passengers.get(i) instanceof Player) {
                    ((Player) passengers.get(i)).damage(100.0, event.getAttacker());
                }
            }
        }
    }
}
