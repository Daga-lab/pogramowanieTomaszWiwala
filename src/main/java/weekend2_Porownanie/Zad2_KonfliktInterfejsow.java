package weekend2_Porownanie;

/**
 * ...comment class...
 *
 * @author dagmarakitkowska@gmail.com
 * @since 23.02.2020
 */
final class Zad2_KonfliktInterfejsow extends  KonfliktParent implements Person, Idd {
    public static void main(String[] args) {
        Zad2_KonfliktInterfejsow konfliktInterfejsow = new Zad2_KonfliktInterfejsow();
        System.out.println(konfliktInterfejsow.getId());
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public int getId() {
        return Idd.super.getId();
    }
}
interface Person{
    String getName();
    default int getId(){
        return -1;
    }
}
interface Idd{
    default int  getId(){
        return Math.abs(hashCode());
    }
}
class KonfliktParent{
    public int getId(){
        return 10;
    }
}
