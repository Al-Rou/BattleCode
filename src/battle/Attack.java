package battle;

import java.util.Random;

public class Attack
{
    private int damage;
    Random random = new Random();
    public void setDamage(int a)
    {
        damage = a;
    }
    public int getDamage()
    {
        return damage;
    }
    public void attackWithSword()
    {
        setDamage(random.nextInt(3)+7);
    }
    public void attackWithFireBall()
    {
        setDamage(random.nextInt(18)+1);
    }
    public void monsterAttack()
    {
        setDamage(random.nextInt(6)+5);
    }
    public void monsterAttackAfterFillBall()
    {
        setDamage(random.nextInt(10)+8);
    }
}
