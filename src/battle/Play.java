package battle;

import java.util.Scanner;

public class Play
{
    Spieler spieler = new Spieler();
    Monster monster = new Monster();
    Attack attack = new Attack();
    public void play() {
        //Spieler spieler = new Spieler();
        //Monster monster = new Monster();
        int i;
        String c;
        System.out.println("Do you wanna fight? ( y/n)");
        Scanner in = new Scanner(System.in);
        c = in.nextLine();
        switch (c) {
            case "n":
                return;
            case "y":
        do {
            //switch (c) {
                //case "n":
                    //return;
                //case "y":
                    System.out.println("#####New Round#####");
                    System.out.print("Your Life: ");
                    System.out.println(spieler.getLife());
                    System.out.print("Your Mana: ");
                    System.out.println(spieler.getMana());
                    System.out.print("Monster Life: ");
                    System.out.println(monster.getLife());
                    System.out.println("----------------------");
                    System.out.println("It is your turn. Which attack do you want to perform?\n"+
                            "Melee Attack with Sword. Deals 7 to 9 Damage ( 1 )\n"+
                            "Magic Spell called Fire Ball. Costs 10 Mana and deals 1 to 18 Damage ( 2 )");
                    i = in.nextInt();
                    switch (i)
                    {
                        case 1:
                            attack.attackWithSword();
                            monster.setLife(monster.getLife()-attack.getDamage());
                            if (finishedPlay())
                            {
                                return;
                            }
                            attack.monsterAttack();
                            spieler.setLife(spieler.getLife()-attack.getDamage());
                            if (finishedPlay())
                            {
                                return;
                            }
                            break;
                        case 2:
                            if (finishedMana())
                            {
                                System.out.println("Your Mana is" +
                                        " already finished!");
                                break;
                            }
                            attack.attackWithFireBall();
                            spieler.setMana(spieler.getMana()-10);
                            monster.setLife(monster.getLife()-attack.getDamage());
                            if (finishedPlay())
                            {
                                return;
                            }
                            attack.monsterAttackAfterFillBall();
                            spieler.setLife(spieler.getLife()-attack.getDamage());
                            if (finishedPlay())
                            {
                                return;
                            }
                            break;
                    }
                    //break;
            }while (0 != 1);
        }
    }
    public boolean finishedPlay()
    {
        if (spieler.getLife()<=0)
        {
            System.out.println("Your Life is over!\n"+"You lost!");
            System.out.print("Your Life: ");
            System.out.println(spieler.getLife());
            System.out.print("Your Mana: ");
            System.out.println(spieler.getMana());
            System.out.print("Monster Life: ");
            System.out.println(monster.getLife());
            return true;
        }
        else if (monster.getLife()<=0)
        {
            System.out.println("Congratulations!\n"+
                    "You killed the monster, bro!");
            System.out.print("Your Life: ");
            System.out.println(spieler.getLife());
            System.out.print("Your Mana: ");
            System.out.println(spieler.getMana());
            System.out.print("Monster Life: ");
            System.out.println(monster.getLife());
            return true;
        }
        else
        {
            return false;
        }
    }
    public boolean finishedMana()
    {
        if (spieler.getMana()<10)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}