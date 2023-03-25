package me.Jonnyfant.Doomcart;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleExitEvent;

public class ExitDoomcartListener implements Listener {
    @EventHandler
    public void onExit(VehicleExitEvent event)
    {
        if(event.getVehicle()!=null)
        {
            if(event.getExited().isDead()==false) {
                Player p = (Player) event.getExited();
                p.sendMessage("You can not exit minecarts!");
                event.setCancelled(true);
            }
        }
    }
}
