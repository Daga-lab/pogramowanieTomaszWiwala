package weekend1_IO;

/**
 * ...comment class...
 *
 * @author dagmarakitkowska@gmail.com
 * @since 15.02.2020
 */
final class Zad8_RozkodowanieTablicyBajtow {
    public static void main(String[] args) {

        byte[] tab = {80, 105, 101, 110, 105, -60, -123, 100, 122, 101, 32, 116, 111, 32, 110, 105, 101, 32, 119, 115, 122, 121, 115, 116, 107, 111};

        String przyslowie = new String(tab);
        System.out.println(przyslowie);


        int[] tab2 = {68, 112, 100, 117, 125, 37, 118, 118, 107, 131, -50, -112, 128, 114, 121, 47, 132, 128, 50, 131, 131, -38, -104, 134, 143, 122, 58, 141, 139, 127, 141, 147, 153, 79};
        byte [] tab3 = new byte[tab2.length];

        for (int i = 0; i < tab2.length ; i++) {
            tab3[i] =(byte)( tab3[i] - i);
        }
        String przyslowie2 = new String(tab3);
        System.out.println(przyslowie2);
    }
}


