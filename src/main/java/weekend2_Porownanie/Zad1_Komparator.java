package weekend2_Porownanie;

import java.util.Arrays;
import java.util.Comparator;

/**
 * ...comment class...
 *
 * @author dagmarakitkowska@gmail.com
 * @since 23.02.2020
 */
final class Zad1_Komparator {
    public static void main(String[] args) {
        String[] tab = {"Anna", "Vlad"};
        Arrays.sort(tab);
        System.out.println(Arrays.toString(tab));

        Arrays.sort(tab, new WomenFirstComparato());
        System.out.println(Arrays.toString(tab));

    }
}

class WomenFirstComparato implements Comparator<String> {

    @Override
    public int compare(String o, String t1) {
        char c1 = o.charAt(o.length() - 1);
        char c2 = t1.charAt(t1.length() - 1);
    /*    if (c1 == 'a'){
            return  (-1);
        }else if (c2 == 'a') {
            return 0;
        }else
            return 0; */
        return Character.toLowerCase(c1) - Character.toLowerCase(c2);
    }
}
