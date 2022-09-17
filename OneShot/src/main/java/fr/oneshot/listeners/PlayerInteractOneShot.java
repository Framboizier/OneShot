package fr.oneshot.listeners;

import fr.oneshot.Main;
import fr.oneshot.Mysql.PlayerInfo;
import fr.oneshot.utils.Kits;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

public class PlayerInteractOneShot implements Listener {
    public static Map<UUID, Boolean> playercooldown = new HashMap<>();
    Player p;
    String prefix = Main.prefix;

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        ItemStack it = e.getItem();
        Action act = e.getAction();
        PlayerInfo pinfo = new PlayerInfo(p);

        //if(it == null) return;
        if (it != null) {

            if (it.getType() == Material.DIAMOND_AXE && (it.getItemMeta().getDisplayName().equals(prefix + "§bJouer"))) {

                Random pos_random = new Random();
                int pos_final;
                pos_final = 1 + pos_random.nextInt(5);
                if (pos_final == 1) {
                    p.teleport(Main.getInstance().locations.getPos1());
                    //OneShot.title.sendFullTitle(p, 20, 40, 20, prefix, "§a§oBonne chance !");
                    Main.getInstance().play.playGame(p);
                    Main.getInstance().invunerability.add(p);
                    Bukkit.getServer().getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
                        @Override
                        public void run() {
                            Main.getInstance().invunerability.remove(p);
                        }
                    }, 3 * 20L);
                    return;
                }
                if (pos_final == 2) {
                    p.teleport(Main.getInstance().locations.getPos2());
                    //OneShot.title.sendFullTitle(p, 20, 40, 20, prefix, "§a§oBonne chance !");
                    Main.getInstance().play.playGame(p);
                    Main.getInstance().invunerability.add(p);
                    Bukkit.getServer().getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
                        @Override
                        public void run() {
                            Main.getInstance().invunerability.remove(p);
                        }
                    }, 3 * 20L);
                    return;
                }
                if (pos_final == 3) {
                    p.teleport(Main.getInstance().locations.getPos3());
                    //OneShot.title.sendFullTitle(p, 20, 40, 20, prefix, "§a§oBonne chance !");
                    Main.getInstance().play.playGame(p);
                    Main.getInstance().invunerability.add(p);
                    Bukkit.getServer().getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
                        @Override
                        public void run() {
                            Main.getInstance().invunerability.remove(p);
                        }
                    }, 3 * 20L);
                    return;
                }
                if (pos_final == 4) {
                    p.teleport(Main.getInstance().locations.getPos4());
                    //OneShot.title.sendFullTitle(p, 20, 40, 20, prefix, "§a§oBonne chance !");
                    Main.getInstance().play.playGame(p);
                    Main.getInstance().invunerability.add(p);
                    Bukkit.getServer().getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
                        @Override
                        public void run() {
                            Main.getInstance().invunerability.remove(p);
                        }
                    }, 3 * 20L);
                    return;
                }
                if (pos_final == 5) {
                    p.teleport(Main.getInstance().locations.getPos5());
                    Main.getInstance().play.playGame(p);
                    Main.getInstance().invunerability.add(p);
                    Bukkit.getServer().getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
                        @Override
                        public void run() {
                            Main.getInstance().invunerability.remove(p);
                        }
                    }, 3 * 20L);
                    return;
                }
                return;

            }


            if (it.getType() == Material.CHEST) {
                if (it.getItemMeta().getDisplayName().equals("§eSelection de kit")) {
                    e.setCancelled(true);
                    Kits.Kit(p);
                    return;
                }
            }
            if (it.getType() == Material.FEATHER) {
                if (Main.kit.get(p) == "oneshot") {
                    if (playercooldown.get(p.getUniqueId()) == false) {
                        p.sendMessage("§aMode invisible activé !");
                        playercooldown.put(p.getUniqueId(), true);
                        if (pinfo.getBow() < 3) {
                            p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 10 * 20, 1, true, false));
                            Bukkit.getServer().getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
                                @Override
                                public void run() {
                                    playercooldown.put(p.getUniqueId(), false);
                                }
                            }, 610 * 20L);
                            return;
                        }
                        if (pinfo.getBow() == 3) {
                            p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 10 * 20, 1, true, false));
                            Bukkit.getServer().getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
                                @Override
                                public void run() {
                                    playercooldown.put(p.getUniqueId(), false);
                                }
                            }, 310 * 20L);
                            return;
                        }
                        if (pinfo.getBow() == 4) {
                            p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 30 * 20, 1, true, false));
                            Bukkit.getServer().getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
                                @Override
                                public void run() {
                                    playercooldown.put(p.getUniqueId(), false);
                                }
                            }, 330 * 20L);
                            return;
                        }
                        if (pinfo.getBow() == 5) {
                            p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 30 * 20, 1, true, false));
                            Bukkit.getServer().getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
                                @Override
                                public void run() {
                                    playercooldown.put(p.getUniqueId(), false);
                                }
                            }, 150 * 20L);
                            return;
                        }
                    }
                    p.sendMessage("§cVous ne pouvez pas encore activer cette capacité ultime !");
                }
            }
            if (act.equals(Action.RIGHT_CLICK_AIR) || act.equals(Action.RIGHT_CLICK_BLOCK)) {
                if (it.getType() == Material.IRON_SWORD) {
                    if (Main.kit.get(p) == "guerrier") {
                        if (playercooldown.get(p.getUniqueId()) == false) {
                            playercooldown.put(p.getUniqueId(), true);
                            p.setVelocity(p.getLocation().getDirection().multiply(3));
                            p.setVelocity(new Vector(p.getVelocity().getX(), 0.3, p.getVelocity().getZ()));
                            if (pinfo.getGuerrier() == 1) {
                                Bukkit.getServer().getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
                                    @Override
                                    public void run() {
                                        playercooldown.put(p.getUniqueId(), false);
                                    }
                                }, 600 * 20L);
                                return;
                            }
                            if (pinfo.getGuerrier() == 2) {
                                Bukkit.getServer().getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
                                    @Override
                                    public void run() {
                                        playercooldown.put(p.getUniqueId(), false);
                                    }
                                }, 480 * 20L);
                                return;
                            }
                            if (pinfo.getGuerrier() == 3) {
                                Bukkit.getServer().getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
                                    @Override
                                    public void run() {
                                        playercooldown.put(p.getUniqueId(), false);
                                    }
                                }, 240 * 20L);
                                return;
                            }
                            if (pinfo.getGuerrier() == 4) {
                                Bukkit.getServer().getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
                                    @Override
                                    public void run() {
                                        playercooldown.put(p.getUniqueId(), false);
                                    }
                                }, 60 * 20L);
                                return;
                            }
                            if (pinfo.getGuerrier() == 5) {
                                Bukkit.getServer().getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
                                    @Override
                                    public void run() {
                                        playercooldown.put(p.getUniqueId(), false);
                                    }
                                }, 30 * 20L);
                                return;
                            }
                        }
                        p.sendMessage("§cVous ne pouvez pas encore activer cette capacité ultime !");
                    }
                }
                if (it.getType() == Material.DIAMOND_SWORD) {
                    if (Main.kit.get(p) == "guerrier") {
                        if (playercooldown.get(p.getUniqueId()) == false) {
                            playercooldown.put(p.getUniqueId(), true);
                            p.setVelocity(p.getLocation().getDirection().multiply(5));
                            p.setVelocity(new Vector(p.getVelocity().getX(), 0.3, p.getVelocity().getZ()));
                            if (pinfo.getGuerrier() == 1) {
                                Bukkit.getServer().getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
                                    @Override
                                    public void run() {
                                        playercooldown.put(p.getUniqueId(), false);
                                    }
                                }, 600 * 20L);
                                return;
                            }
                            if (pinfo.getGuerrier() == 2) {
                                Bukkit.getServer().getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
                                    @Override
                                    public void run() {
                                        playercooldown.put(p.getUniqueId(), false);
                                    }
                                }, 480 * 20L);
                                return;
                            }
                            if (pinfo.getGuerrier() == 3) {
                                Bukkit.getServer().getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
                                    @Override
                                    public void run() {
                                        playercooldown.put(p.getUniqueId(), false);
                                    }
                                }, 240 * 20L);
                                return;
                            }
                            if (pinfo.getGuerrier() == 4) {
                                Bukkit.getServer().getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
                                    @Override
                                    public void run() {
                                        playercooldown.put(p.getUniqueId(), false);
                                    }
                                }, 60 * 20L);
                                return;
                            }
                            if (pinfo.getGuerrier() == 5) {
                                Bukkit.getServer().getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
                                    @Override
                                    public void run() {
                                        playercooldown.put(p.getUniqueId(), false);
                                    }
                                }, 30 * 20L);
                                return;
                            }
                        }
                        p.sendMessage("§cVous ne pouvez pas encore activer cette capacité ultime !");
                    }
                }
            }
            if (it.getType() == Material.SLIME_BALL) {
                if (Main.kit.get(p) == "acrobate") {
                    if (playercooldown.get(p.getUniqueId()) == false) {
                        playercooldown.put(p.getUniqueId(), true);
                        p.setVelocity(p.getLocation().getDirection().multiply(1));
                        p.setVelocity(new Vector(p.getVelocity().getX(), 1.5, p.getVelocity().getZ()));
                        if (pinfo.getAcrobate() == 3) {
                            Bukkit.getServer().getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
                                @Override
                                public void run() {
                                    playercooldown.put(p.getUniqueId(), false);
                                }
                            }, 300 * 20L);
                            return;
                        }
                        if (pinfo.getAcrobate() == 4) {
                            Bukkit.getServer().getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
                                @Override
                                public void run() {
                                    playercooldown.put(p.getUniqueId(), false);
                                }
                            }, 120 * 20L);
                            return;
                        }
                        if (pinfo.getAcrobate() == 5) {
                            Bukkit.getServer().getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
                                @Override
                                public void run() {
                                    playercooldown.put(p.getUniqueId(), false);
                                }
                            }, 30 * 20L);
                            return;
                        }
                    }
                    p.sendMessage("§cVous ne pouvez pas encore activer cette capacité ultime !");
                }
            }
            if (it.getType() == Material.IRON_DOOR) {
                if (Main.kit.get(p) == "tank") {
                    if (playercooldown.get(p.getUniqueId()) == false) {
                        playercooldown.put(p.getUniqueId(), true);
                        p.setWalkSpeed(0F);
                        Main.getInstance().tortue.add(p);
                        if (pinfo.getTank() == 1) {
                            Bukkit.getServer().getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
                                @Override
                                public void run() {
                                    p.setWalkSpeed(0.2F);
                                    Main.getInstance().tortue.remove(p);
                                    Bukkit.getServer().getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
                                        @Override
                                        public void run() {
                                            playercooldown.put(p.getUniqueId(), false);
                                        }
                                    }, 600 * 20L);
                                }
                            }, 10 * 20L);
                            return;
                        }
                        if (pinfo.getTank() == 2 || pinfo.getTank() == 3) {
                            Bukkit.getServer().getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
                                @Override
                                public void run() {
                                    p.setWalkSpeed(0.2F);
                                    Main.getInstance().tortue.remove(p);
                                    Bukkit.getServer().getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
                                        @Override
                                        public void run() {
                                            playercooldown.put(p.getUniqueId(), false);
                                        }
                                    }, 480 * 20L);
                                }
                            }, 10 * 20L);
                            return;
                        }
                        if (pinfo.getTank() == 4) {
                            Bukkit.getServer().getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
                                @Override
                                public void run() {
                                    p.setWalkSpeed(0.2F);
                                    Main.getInstance().tortue.remove(p);
                                    Bukkit.getServer().getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
                                        @Override
                                        public void run() {
                                            playercooldown.put(p.getUniqueId(), false);
                                        }
                                    }, 480 * 20L);
                                }
                            }, 30 * 20L);
                            return;
                        }
                        if (pinfo.getTank() == 5) {
                            Bukkit.getServer().getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
                                @Override
                                public void run() {
                                    p.setWalkSpeed(0.2F);
                                    Main.getInstance().tortue.remove(p);
                                    Bukkit.getServer().getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
                                        @Override
                                        public void run() {
                                            playercooldown.put(p.getUniqueId(), false);
                                        }
                                    }, 300 * 20L);
                                }
                            }, 30 * 20L);
                            return;
                        }
                    }
                    p.sendMessage("§cVous ne pouvez pas encore activer cette capacité ultime !");
                }
            }
        }


        e.setCancelled(false);

    }


}
