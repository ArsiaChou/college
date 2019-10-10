package test;

import gun.HandGun;
import gun.MachineGun;
import gun.Rifle;
import role.Soldier;

public class Client {
    public static void main(String[] args) {
        Soldier soldier = new Soldier();

        soldier.killEnemy(new HandGun());
        soldier.killEnemy(new MachineGun());
        soldier.killEnemy(new Rifle());
        soldier.killEnemy(new gun.ToyGun());
        soldier.killEnemy(new gun.toy.ToyGun());
    }
}
