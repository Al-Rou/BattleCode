package battle;

public class Spieler
{
    private int life;
    private int mana;
    public Spieler()
    {
        life = 100;
        mana = 35;
    }
    public void setLife(int a)
    {
        life = a;
    }
    public int getLife()
    {
        return life;
    }
    public void setMana(int a)
    {
        mana = a;
    }
    public int getMana()
    {
        return mana;
    }
}
