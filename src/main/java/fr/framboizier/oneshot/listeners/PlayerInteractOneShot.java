package fr.framboizier.oneshot.listeners;

import fr.framboizier.oneshot.Main;
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

import java.util.Random;

public class PlayerInteractOneShot implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        ItemStack it = e.getItem();
        Action act = e.getAction();


        //if(it .equals( null) return;
        if (it != null) {

            if (it.getType().equals(Material.DIAMOND_AXE) && it.getItemMeta().getDisplayName().equals(Main.getInstance().getPrefix() + "§bJouer")) {
                Random posRandom = new Random();
                int position = 1 + posRandom.nextInt(Main.getInstance().getLocations().getNumber());
                p.teleport(Main.getInstance().getLocations().getPos(position));
                Main.getInstance().getPlay().playGame(p);
                return;

            }


            if (it.getType().equals(Material.CHEST)) {
                if (it.getItemMeta().getDisplayName().equals("§eSelection de kit")) {
                    e.setCancelled(true);
                    Main.getInstance().getKits().Kit(p);
                    return;
                }
            }
            if (it.getType().equals(Material.FEATHER)) {
                if (Main.getInstance().getKit().get(p).equals("oneshot")) {
                    if (Main.getInstance().getPlayerCoolDown().get(p.getUniqueId()).equals(false)) {
                        p.sendMessage("§aMode invisible activé !");
                        Main.getInstance().getPlayerCoolDown().put(p.getUniqueId(), true);
                        if (Main.getInstance().getBow().get(p.getUniqueId()) < 3) {
                            p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 10 * 20, 1, true, false));
                            Bukkit.getServer().getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
                                @Override
                                public void run() {
                                    Main.getInstance().getPlayerCoolDown().put(p.getUniqueId(), false);
                                }
                            }, 610 * 20L);
                            return;
                        }
                        if (Main.getInstance().getBow().get(p.getUniqueId()).equals(3)) {
                            p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 10 * 20, 1, true, false));
                            Bukkit.getServer().getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
                                @Override
                                public void run() {
                                    Main.getInstance().getPlayerCoolDown().put(p.getUniqueId(), false);
                                }
                            }, 310 * 20L);
                            return;
                        }
                        if (Main.getInstance().getBow().get(p.getUniqueId()).equals(4)) {
                            p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 30 * 20, 1, true, false));
                            Bukkit.getServer().getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
                                @Override
                                public void run() {
                                    Main.getInstance().getPlayerCoolDown().put(p.getUniqueId(), false);
                                }
                            }, 330 * 20L);
                            return;
                        }
                        if (Main.getInstance().getBow().get(p.getUniqueId()).equals(5)) {
                            p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 30 * 20, 1, true, false));
                            Bukkit.getServer().getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
                                @Override
                                public void run() {
                                    Main.getInstance().getPlayerCoolDown().put(p.getUniqueId(), false);
                                }
                            }, 150 * 20L);
                            return;
                        }
                    }
                    p.sendMessage("§cVous ne pouvez pas encore activer cette capacité ultime !");
                }
            }
            if (act.equals(Action.RIGHT_CLICK_AIR) || act.equals(Action.RIGHT_CLICK_BLOCK)) {
                if (it.getType().equals(Material.IRON_SWORD)) {
                    if (Main.getInstance().getKit().get(p).equals("guerrier")) {
                        if (Main.getInstance().getPlayerCoolDown().get(p.getUniqueId()).equals(false)) {
                            Main.getInstance().getPlayerCoolDown().put(p.getUniqueId(), true);
                            p.setVelocity(p.getLocation().getDirection().multiply(3));
                            p.setVelocity(new Vector(p.getVelocity().getX(), 0.3, p.getVelocity().getZ()));
                            if (Main.getInstance().getGuerrier().get(p.getUniqueId()).equals(1)) {
                                Bukkit.getServer().getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
                                    @Override
                                    public void run() {
                                        Main.getInstance().getPlayerCoolDown().put(p.getUniqueId(), false);
                                    }
                                }, 600 * 20L);
                                return;
                            }
                            if (Main.getInstance().getGuerrier().get(p.getUniqueId()).equals(2)) {
                                Bukkit.getServer().getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
                                    @Override
                                    public void run() {
                                        Main.getInstance().getPlayerCoolDown().put(p.getUniqueId(), false);
                                    }
                                }, 480 * 20L);
                                return;
                            }
                            if (Main.getInstance().getGuerrier().get(p.getUniqueId()).equals(3)) {
                                Bukkit.getServer().getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
                                    @Override
                                    public void run() {
                                        Main.getInstance().getPlayerCoolDown().put(p.getUniqueId(), false);
                                    }
                                }, 240 * 20L);
                                return;
                            }
                            if (Main.getInstance().getGuerrier().get(p.getUniqueId()).equals(4)) {
                                Bukkit.getServer().getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
                                    @Override
                                    public void run() {
                                        Main.getInstance().getPlayerCoolDown().put(p.getUniqueId(), false);
                                    }
                                }, 60 * 20L);
                                return;
                            }
                            if (Main.getInstance().getGuerrier().get(p.getUniqueId()).equals(5)) {
                                Bukkit.getServer().getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
                                    @Override
                                    public void run() {
                                        Main.getInstance().getPlayerCoolDown().put(p.getUniqueId(), false);
                                    }
                                }, 30 * 20L);
                                return;
                            }
                        }
                        p.sendMessage("§cVous ne pouvez pas encore activer cette capacité ultime !");
                    }
                }
                if (it.getType().equals(Material.DIAMOND_SWORD)) {
                    if (Main.getInstance().getKit().get(p).equals("guerrier")) {
                        if (Main.getInstance().getPlayerCoolDown().get(p.getUniqueId()).equals(false)) {
                            Main.getInstance().getPlayerCoolDown().put(p.getUniqueId(), true);
                            p.setVelocity(p.getLocation().getDirection().multiply(5));
                            p.setVelocity(new Vector(p.getVelocity().getX(), 0.3, p.getVelocity().getZ()));
                            if (Main.getInstance().getGuerrier().get(p.getUniqueId()).equals(1)) {
                                Bukkit.getServer().getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
                                    @Override
                                    public void run() {
                                        Main.getInstance().getPlayerCoolDown().put(p.getUniqueId(), false);
                                    }
                                }, 600 * 20L);
                                return;
                            }
                            if (Main.getInstance().getGuerrier().get(p.getUniqueId()).equals(2)) {
                                Bukkit.getServer().getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
                                    @Override
                                    public void run() {
                                        Main.getInstance().getPlayerCoolDown().put(p.getUniqueId(), false);
                                    }
                                }, 480 * 20L);
                                return;
                            }
                            if (Main.getInstance().getGuerrier().get(p.getUniqueId()).equals(3)) {
                                Bukkit.getServer().getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
                                    @Override
                                    public void run() {
                                        Main.getInstance().getPlayerCoolDown().put(p.getUniqueId(), false);
                                    }
                                }, 240 * 20L);
                                return;
                            }
                            if (Main.getInstance().getGuerrier().get(p.getUniqueId()).equals(4)) {
                                Bukkit.getServer().getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
                                    @Override
                                    public void run() {
                                        Main.getInstance().getPlayerCoolDown().put(p.getUniqueId(), false);
                                    }
                                }, 60 * 20L);
                                return;
                            }
                            if (Main.getInstance().getGuerrier().get(p.getUniqueId()).equals(5)) {
                                Bukkit.getServer().getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
                                    @Override
                                    public void run() {
                                        Main.getInstance().getPlayerCoolDown().put(p.getUniqueId(), false);
                                    }
                                }, 30 * 20L);
                                return;
                            }
                        }
                        p.sendMessage("§cVous ne pouvez pas encore activer cette capacité ultime !");
                    }
                }
            }
            if (it.getType().equals(Material.SLIME_BALL)) {
                if (Main.getInstance().getKit().get(p).equals("acrobate")) {
                    if (Main.getInstance().getPlayerCoolDown().get(p.getUniqueId()).equals(false)) {
                        Main.getInstance().getPlayerCoolDown().put(p.getUniqueId(), true);
                        p.setVelocity(p.getLocation().getDirection().multiply(1));
                        p.setVelocity(new Vector(p.getVelocity().getX(), 1.5, p.getVelocity().getZ()));
                        if (Main.getInstance().getAcrobate().get(p.getUniqueId()).equals(3)) {
                            Bukkit.getServer().getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
                                @Override
                                public void run() {
                                    Main.getInstance().getPlayerCoolDown().put(p.getUniqueId(), false);
                                }
                            }, 300 * 20L);
                            return;
                        }
                        if (Main.getInstance().getAcrobate().get(p.getUniqueId()).equals(4)) {
                            Bukkit.getServer().getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
                                @Override
                                public void run() {
                                    Main.getInstance().getPlayerCoolDown().put(p.getUniqueId(), false);
                                }
                            }, 120 * 20L);
                            return;
                        }
                        if (Main.getInstance().getAcrobate().get(p.getUniqueId()).equals(5)) {
                            Bukkit.getServer().getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
                                @Override
                                public void run() {
                                    Main.getInstance().getPlayerCoolDown().put(p.getUniqueId(), false);
                                }
                            }, 30 * 20L);
                            return;
                        }
                    }
                    p.sendMessage("§cVous ne pouvez pas encore activer cette capacité ultime !");
                }
            }
            if (it.getType().equals(Material.IRON_DOOR)) {
                if (Main.getInstance().getKit().get(p).equals("tank")) {
                    if (Main.getInstance().getPlayerCoolDown().get(p.getUniqueId()).equals(false)) {
                        Main.getInstance().getPlayerCoolDown().put(p.getUniqueId(), true);
                        p.setWalkSpeed(0F);
                        Main.getInstance().getTortue().add(p);
                        if (Main.getInstance().getTank().get(p.getUniqueId()).equals(1)) {
                            Bukkit.getServer().getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
                                @Override
                                public void run() {
                                    p.setWalkSpeed(0.2F);
                                    Main.getInstance().getTortue().remove(p);
                                    Bukkit.getServer().getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
                                        @Override
                                        public void run() {
                                            Main.getInstance().getPlayerCoolDown().put(p.getUniqueId(), false);
                                        }
                                    }, 600 * 20L);
                                }
                            }, 10 * 20L);
                            return;
                        }
                        if (Main.getInstance().getTank().get(p.getUniqueId()).equals(2) || Main.getInstance().getTank().get(p.getUniqueId()).equals(3)) {
                            Bukkit.getServer().getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
                                @Override
                                public void run() {
                                    p.setWalkSpeed(0.2F);
                                    Main.getInstance().getTortue().remove(p);
                                    Bukkit.getServer().getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
                                        @Override
                                        public void run() {
                                            Main.getInstance().getPlayerCoolDown().put(p.getUniqueId(), false);
                                        }
                                    }, 480 * 20L);
                                }
                            }, 10 * 20L);
                            return;
                        }
                        if (Main.getInstance().getTank().get(p.getUniqueId()).equals(4)) {
                            Bukkit.getServer().getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
                                @Override
                                public void run() {
                                    p.setWalkSpeed(0.2F);
                                    Main.getInstance().getTortue().remove(p);
                                    Bukkit.getServer().getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
                                        @Override
                                        public void run() {
                                            Main.getInstance().getPlayerCoolDown().put(p.getUniqueId(), false);
                                        }
                                    }, 480 * 20L);
                                }
                            }, 30 * 20L);
                            return;
                        }
                        if (Main.getInstance().getTank().get(p.getUniqueId()).equals(5)) {
                            Bukkit.getServer().getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
                                @Override
                                public void run() {
                                    p.setWalkSpeed(0.2F);
                                    Main.getInstance().getTortue().remove(p);
                                    Bukkit.getServer().getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
                                        @Override
                                        public void run() {
                                            Main.getInstance().getPlayerCoolDown().put(p.getUniqueId(), false);
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
