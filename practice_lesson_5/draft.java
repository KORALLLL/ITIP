import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.management.modelmbean.InvalidTargetObjectTypeException;

public class draft {
    public static void main(String[] args){
        System.out.println(spiderVsFly("H3", "E2"));//задано
        System.out.println(spiderVsFly("A4", "B2"));//задано
        System.out.println(spiderVsFly("A4", "C2"));//задано
        System.out.println(spiderVsFly("C2", "A4"));//муха дальше, чем паук от центра + обратное направление
        System.out.println(spiderVsFly("H4", "A3"));//муха ближе, направление обратное
        System.out.println(spiderVsFly("G4", "A3"));//муха ближе, ещё одно обратное
        System.out.println(spiderVsFly("H3", "H3"));//нахождение в одной точке
        System.out.println(spiderVsFly("A3", "H3"));//шаг назад через граничный случай
        System.out.println(spiderVsFly("A3", "G3"));//два шага назад через граничный случай
        System.out.println(spiderVsFly("C4", "E4"));//два шага вперёд
    }

    private static String spiderVsFly(String a, String b) {
        int aX = Character.digit(a.charAt(1), 10); //Позиция по оси цифр
        int bX = Character.digit(b.charAt(1), 10);
        double throughCenterDistance = aX + bX;

        int aY = a.charAt(0) - 'A'; //Позиция по оси букв
        int bY = b.charAt(0) - 'A';
        int h = Math.abs(aY - bY) < 4 ? Math.abs(aY - bY) : 8 - Math.abs(aY - bY);
        int commonLevel = Math.min(aX, bX);

        double sqrt = Math.sqrt(2 - 2 * Math.cos(Math.toRadians(50)));
        double roundDistance = Math.abs(aX - bX) + h * commonLevel * sqrt;
        List<String> path = new ArrayList<>();
        if (throughCenterDistance < roundDistance) {
            for (int i = aX; i >= 0; i--) {
                path.add(a.charAt(0) + String.valueOf(i));
            }
            for (int i = 1; i <= bX; i++) {
                path.add(b.charAt(0) + String.valueOf(i));
            }
        } else {
            List<Character> letters = Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H');
            for (int i = aX; i >= commonLevel; i--) {
                path.add(a.charAt(0) + String.valueOf(i));
            }
            int val = aY - bY;
            boolean direction = val > 3 || (val > -3 && val <= 0); //true - clockwise
            for (int i = 0; i < h; i++) {
                Character character = letters.get(((aY + (direction ? i + 1 : -i - 1)) + 8) % 8);
                path.add(character + String.valueOf(commonLevel));
            }
            for (int i = commonLevel; i < bX; i++) {
                path.add(letters.get(bY) + String.valueOf(i + 1));
            }
        }
        return String.join("-", path);
    }

}