package me.Jonnyfant.Doomcart;

import org.bukkit.entity.Player;
import org.bukkit.entity.Vehicle;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleDestroyEvent;
import java.util.List;

public class KillOnDestroyedMinecartListener implements Listener {
    @EventHandler
    public void onDestroyedMinecart(VehicleDestroyEvent event)
    {
        //Bukkit.broadcastMessage("Minecart breaks!");
        //Bukkit.broadcastMessage("Passengers:");
        Vehicle vehicle = event.getVehicle();
        List passengers = vehicle.getPassengers();
        for(int i = 0; i<passengers.size();i++)
        {
            //Bukkit.broadcastMessage(i+1 + ": " + passengers.get(i).toString());
            if(passengers.get(i) instanceof Player)
            {
                //((Player) passengers.get(i)).setHealth(0.1);
                ((Player) passengers.get(i)).damage(100.0, event.getAttacker());
                //((Player) passengers.get(i)).setHealth(0.0);
                //Bukkit.broadcastMessage("Passenger is a player");
            }
            /*
            //EntityDamageByEntityEvent damageEvent = new EntityDamageByEntityEvent(event.getAttacker(), (Entity) passengers.get(i), EntityDamageEvent.DamageCause.CUSTOM,1.0);
            Map<EntityDamageEvent.DamageModifier, Double> modifiers = new EnumMap<>(EntityDamageEvent.DamageModifier.class);
            modifiers.put(EntityDamageEvent.DamageModifier.BASE, 1.0);
            //EntityDamageByEntityEvent damageEvent = new EntityDamageByEntityEvent  (event.getAttacker(), (Entity) passengers.get(i), EntityDamageEvent.DamageCause.CUSTOM, modifiers);
            EntityDamageByEntityEvent damageEvent = new EntityDamageByEntityEvent(event.getAttacker(),(Entity) passengers.get(i), EntityDamageEvent.DamageCause.CUSTOM,1.0);
            Bukkit.getServer().getPluginManager().callEvent(damageEvent);
            //Bukkit.getServer().getPluginManager().registerEvent(EntityDamageByEntityEvent(event.getAttacker(), (Entity) passengers.get(i), EntityDamageEvent.DamageCause.CUSTOM,5000));
             */
        }
    }
}
