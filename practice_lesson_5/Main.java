import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args){
        System.out.println(sameLetterPattern("ABAB", "CDCD"));
        System.out.println(sameLetterPattern("ABCBA", "BCDCB"));
        System.out.println(sameLetterPattern("FFGG", "CDCD"));
        System.out.println(sameLetterPattern("FFFF", "ABCD"));
        System.out.println("----------------");
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
        // System.out.println("-----------");
        // System.out.println(digitsCount(4666));
        // System.out.println(digitsCount(544));
        // System.out.println(digitsCount(121317));
        // System.out.println(digitsCount(0));
        // System.out.println(digitsCount(12345));
        // System.out.println(digitsCount(1289396387328L));
        // System.out.println("-----------");
        // System.out.println(totalPoints(new String[] {"cat", "create", "sat"}, "caster"));
        // System.out.println(totalPoints(new String[] {"trance", "recant"}, "recant"));
        // System.out.println(totalPoints(new String[] {"dote", "dotes", "toes", "set", "dot", "dots", "sted"}, "tossed"));
        // System.out.println("---------------");
        // System.out.println((sumsUp(new int[] {1, 2, 3, 4, 5})));
        // System.out.println((sumsUp(new int[] {1, 2, 3, 7, 9})));
        // System.out.println((sumsUp(new int[] {10, 9, 7, 2, 8})));
        // System.out.println((sumsUp(new int[] {1, 6, 5, 4, 8, 2, 3, 7})));
        // System.out.println("----------");
        // System.out.println(takeDownAverage(new String[] {"95%", "83%", "90%", "87%", "88%", "93%"}));
        // System.out.println(takeDownAverage(new String[] {"10%"}));
        // System.out.println(takeDownAverage(new String[] {"53%", "79%"}));
        // System.out.println("--------");
        // System.out.println(caesarCipher("encode", "hello world", 3));
        // System.out.println(caesarCipher("decode", "epqswx pewx xewo!", 4));
        // System.out.println(caesarCipher("encode", "ZZZ", 1));
        // System.out.println(caesarCipher("decode", "AAA", 1));
        // System.out.println("------");
        // System.out.println(setSetup(5, 3));
        // System.out.println(setSetup(7, 3));
        // System.out.println("------------");
        // System.out.println(timeDifference("Los Angeles", "April 1, 2011 00:23", "Canberra")); //ситуация, когда по времени плюс, но ничего в дате не меняется
        // System.out.println(timeDifference("Los Angeles", "April 1, 2011 23:23", "Canberra")); //новый день
        // System.out.println(timeDifference("London", "July 31, 1983 23:01", "Rome")); //новый месяц 31
        // System.out.println(timeDifference("London", "July 30, 1983 23:01", "Rome")); //остаток в том же месяце при 31 днях
        // System.out.println(timeDifference("London", "June 30, 1983 23:01", "Rome")); // переход на новый месяц при 30 днях
        // System.out.println(timeDifference("New York", "December 31, 1970 13:40", "Beijing")); //новый год
        // System.out.println(timeDifference("London", "February 29, 2000 23:40", "Rome")); //новый високосный месяц
        // System.out.println(timeDifference("Moscow", "February 28, 2000 23:40", "Tehran")); //старый високосный месяц февраль
        // System.out.println(timeDifference("Rome", "February 28, 2001 23:40", "Moscow")); // новый месяц после февраля в невисокосный год

        // System.out.println(timeDifference("Buenos Aires", "April 2, 2011 01:23", "Caracas")); //старый день
        // System.out.println(timeDifference("New Delhi", "June 1, 1983 01:01", "Tehran")); //старый месяц 31
        // System.out.println(timeDifference("Rome", "May 1, 2000 00:40", "London")); // возврат на 30 число
        // System.out.println(timeDifference("Beijing", "January 1, 1977 1:40", "New Delhi")); //старый год
        // System.out.println(timeDifference("Rome", "March 1, 2000 00:40", "London")); //возврат на 29 февраля
        // System.out.println(timeDifference("Rome", "March 1, 2001 00:40", "London")); //возврат на  28 февраля
        // System.out.println(timeDifference("Rome", "May 1, 2000 05:40", "London")); // ничего не происходит
        // System.out.println("-------------------");
        // System.out.println(isNew(3)); //true
        // System.out.println(isNew(30));//true
        // System.out.println(isNew(321));//false
        // System.out.println(isNew(123));//true
        // System.out.println(isNew(130));//false
        // System.out.println(isNew(103));//true
    }

    public static boolean sameLetterPattern(String a, String b){
        if (a.length()!=b.length()){
            return false;
        }

        for (int i=1; i<a.length(); i++){
            if ((a.charAt(i)-a.charAt(i-1)) != (b.charAt(i)-b.charAt(i-1))){
                return false;
            }
        }
        return true;
    }

    public static String spiderVsFly(String spider, String fly){
        //первый возможный кратчайший путь: паук идёт до центра, затем до мухи
        int way1 = spider.charAt(1) - '0'  + fly.charAt(1) - '0';
        //второй возможный кратчайший путь: объект спускается до одного и того же кольца, а затем по кольцу
        //доходит до второго объекта
        
        //Поскольку расположение мухи и паука могут быть разными, нам неважно идёт муха до паука или наоборот
        //Два случая когда паук дальше и когда паук ближе к центру.
        //Если паук дальше, то мы строим путь до кольца на уровне с мухой, а затем до мухи по кольцу
        //Если муха дальше, то мы меняем их местами, находим путь, при этом сохранив флаг о том, что мы их поменяли
        Boolean changeFlag;
        String tempBegin;
        String tempEnd;
        if (spider.charAt(1) < fly.charAt(1)){
            changeFlag = true;
            tempBegin = fly;
            tempEnd = spider;
        }
        else{
            changeFlag = false;
            tempBegin = spider;
            tempEnd = fly;
        }
        // переменная для подсчета пути по радиалу так, чтобы сравняться с объектом на кольце
        int way2radial = tempBegin.charAt(1) - tempEnd.charAt(1);
        // переменна для подсчёта количества "шагов" по кольцу
        int way2ring = Math.abs(tempBegin.charAt(0) - tempEnd.charAt(0));
        // Случай, если надо двигаться в обрантном направлении
        if (way2ring>=5){
            way2ring = 8 - way2ring;
        }

        // По теореме косинусов мы находим то, каким образом нам считать расстояние по кольцу
        // Находим у равнобедренного треугольника основание. В качестве длины ребер возьмем 1.
        // Так найдём коэффициент того, насколько надо умножить икс, чтобы получить длину основания
        // Из подобия треугольников следует то, что этот коэффициент необходимо будет умножить на номер кольца
        // Кольца расположены на одинаковом расстоянии друг от друга.
        // bc^2 = x^2 + x^2 - 2*x*x*cos(45)
        // bc^2 = 2*x^2 - 2*x^2*cos(45)
        // bc = x (2 - sqrt(2))^0.5
        double ratioForRing = Math.pow(2 - Math.pow(2, 0.5), 0.5);
        // нахождение расстояния, пройдённого по кольцу
        // у нас уже есть количество пройденных шагов. Его необходимо умножит на полученный косинусный коэффициент
        // и на коэффициент подобия треугольников

        double distanceOnRing = ratioForRing * way2ring * (tempEnd.charAt(1) - '0');

        //общее расстояние это сумма, пройденная по радиалам и по кольцу
        double way2 = way2radial + distanceOnRing;
        
        String[] steps;
        // Теперь сравнение двух полученных маршрутов, определение минимального и его построение
        if (way1 > way2){
            steps = new String[way2radial+way2ring+1];
            // спуск на нужное кольцо
            for (int i=0; i<= way2radial; i++){
                steps[i] = "" + tempBegin.charAt(0) + (tempBegin.charAt(1) - '0' - i);
            }
            // движение по кольцу
            for (int i=1; i<= way2ring; i++){
                //Мы берём нашу букву и переводим в базис цифр, с ним удобнее работать.
                //После этого мы увеличиваем на i нашу букву
                //Из-за того, что круг замкнут мы берём остаток от деления на 8, чтобы через H прийти в А
                //И в конце приводим к базису буквенному, то есть добавляем букву
                char newLetter = (char) ((tempBegin.charAt(0) - 'A'+i)% 8 + 'A');
                steps[way2radial+i] = "" + newLetter + (tempEnd.charAt(1)-'0');
            }
            // Случай, когд необходимо идти в обратном направлении
            if (!steps[steps.length-1].equals(tempEnd)){
                for (int i=1; i<= way2ring; i++){
                    char newLetter = (char) ((8 - tempBegin.charAt(0) + 'A'-i)% 8 + 'A');
                    steps[way2radial+i] = "" + newLetter + (tempEnd.charAt(1)-'0');
            }
            }
            if (changeFlag){return String.join("-", reverseArray(steps));}

        }
        else{
            steps = new String[way1+1];
            // спуск к центру
            for (int i=0; i<(spider.charAt(1) - '0'); i++){
                steps[i] = "" + spider.charAt(0) + (spider.charAt(1)-i-'0');
            }
            // центр
            steps[spider.charAt(1) - '0'] = "A0";
            // поднятие от центра
            for (int i=0; i<(fly.charAt(1) - '0'); i++){
                steps[spider.charAt(1) - '0'+1+i] = "" + fly.charAt(0) + (i+1);
            }

        }
        return String.join("-", steps);
    }

    public static String[] reverseArray(String[] arr) {
        String[] reversed = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            reversed[i] = arr[arr.length - 1 - i];
        }
        return reversed;
    }

    public static int digitsCount(long a){
        return Math.abs(a)<10 ? 1 : 1 + digitsCount(a/10);
    }

    public static int totalPoints(String[] words, String scrambleWord){
        int points = 0;
        for (int i=0; i<words.length; i++){ // iteration by words
            String tempWord = words[i];
            for (int j=0; j<scrambleWord.length(); j++){ //iteration by letters in scrambled word
                char currentLetter = scrambleWord.charAt(j);
                for (int k=0; k<count(currentLetter, scrambleWord); k++){
                    tempWord = tempWord.replaceFirst(""+currentLetter, ""); //deletion equale latters
                }
                if (tempWord.length()==0){
                    if (words[i].length()!=scrambleWord.length()){
                        points += words[i].length()-2;
                    }
                    else{
                        points += 54;
                    }
                    break;
            }
            }
        }
        return points;
    }

    public static int count(char letter, String word){
        return word.length() - word.replace(String.valueOf(letter), "").length();
    }

    public static ArrayList<ArrayList<Integer>> sumsUp(int[] nums){
        int[] countNums = new int[9];
        for (int i=0; i<nums.length; i++){// подсчёт чисел, которые можно использовать для пар
            if (nums[i]<=8){
                countNums[nums[i]]++;
            }
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i=0; i<=4; i++){// поиск пар
            ArrayList<Integer> pair = new ArrayList<>();
            pair.add(i);
            pair.add(8-i);
            for (int j=0; j<(i<4?Math.min(countNums[i], countNums[8-i]):countNums[i]/2); j++){//добавление пар
                result.add(pair);
            }
        }
        return result;
    }

    public static String takeDownAverage(String[] results){
        double firstSum = 0;
        for (int i=0; i<results.length; i++){ //нахождение суммы
            firstSum += Integer.parseInt(results[i].replaceAll("%", ""));
        }
        //(firstSum+x)/(results.length + 1) - firstSum/results.length = -5
        //(firstSum+x)/(results.length + 1) = -5 + firstSum/results.length
        //(firstSum+x) = (-5 + firstSum/results.length) * (results.length + 1)
        // x = (-5 + firstSum/results.length) * (results.length + 1) - firstSum
        return (int) ((firstSum/results.length - 5) * (results.length +1) - firstSum) + "%";
    }

    public static String caesarCipher(String mode, String phrase, int shift){
        if (!mode.equals("encode") & !mode.equals("decode")){
            return "incorrect";
        }
        phrase = phrase.toUpperCase();
        String result = "";
        for (int i=0; i<phrase.length(); i++){
            char symbol = phrase.charAt(i);
            if (symbol>='A' & symbol<='Z'){
                int temp = symbol - 'A'; //Приводим к базису где А=0, Z=25
                temp += (mode.equals("encode")?1:-1)*shift; //производим сдвиг. Если шифруем, то прибавляем, если дешифруем ,то вычитаем
                temp = (temp<0 ? 26 + temp : temp); //случая при дешифровании, когда получилось отрицательное число и нужно сделать его положительным
                temp %= 26; //случай, когда при шифровании число больше количества букв в алфавите
                temp += 'A'; // делаем снова буквой
                symbol = (char) temp;
            }
            result += String.valueOf(symbol);
        }
        return result;
    }

    public static int setSetup(int n, int k){
        if (n<k){return 0;}
        if (k==0){
            return 1;
        }
        else{
            //n*n(-1)*...*(n-k+1)
            return n*setSetup(n-1, k-1);
        }
    }

    public static String timeDifference(String cityA, String dateTime, String cityB){
        //хешмап для городов и их поясов
        HashMap<String, Double> cityTime = new HashMap<String, Double>();
        cityTime.put("Los Angeles", -8.);
        cityTime.put("New York", -5.);
        cityTime.put("Caracas", -4.5);
        cityTime.put("Buenos Aires", -3.);
        cityTime.put("London", 0.);
        cityTime.put("Rome", 1.);
        cityTime.put("Moscow", 3.);
        cityTime.put("Tehran", 3.5);
        cityTime.put("New Delhi", 5.5);
        cityTime.put("Beijing", 8.);
        cityTime.put("Canberra", 10.);
        
        //хешмап для месяцев и их номеров
        HashMap<String, Integer> monthes = new HashMap<String, Integer>();
        monthes.put("January", 0);
        monthes.put("February", 1);
        monthes.put("March", 2);
        monthes.put("April", 3);
        monthes.put("May", 4);
        monthes.put("June", 5);
        monthes.put("July", 6);
        monthes.put("Augest", 7);
        monthes.put("September", 8);
        monthes.put("October", 9);
        monthes.put("November", 10);
        monthes.put("December", 11);

        //словая для месяцев с количеством дней 31
        int[] day31 = {-1,0,2,4,6,7,9,11};


        //парсинг месяца, дня, года, часа и минут в заданном городе
        int month = monthes.get(dateTime.split(",")[0].split(" ")[0]);
        int day = Integer.parseInt(dateTime.split(",")[0].split(" ")[1]);
        int year = Integer.parseInt(dateTime.split(", ")[1].split(" ")[0]);
        double hour = Integer.parseInt(dateTime.split(", ")[1].split(" ")[1].split(":")[0]);
        int minutes = Integer.parseInt(dateTime.split(", ")[1].split(" ")[1].split(":")[1]);

        //нахождение количества часов, которое будет в другом городе
        hour = hour - cityTime.get(cityA) + cityTime.get(cityB);

        double allMinutes = minutes + hour * 60;

        //случай наступления нового дня
        if (allMinutes>=24*60){
            allMinutes -= 24*60; //новый час
            day+=1; //новый день
            if (month==1){//если февраль
                int maxFebDays=28; //флаг високосности

                if ((year%4==0 & year%100!=0) | (year%400==0)){ //условие високосности
                    maxFebDays = 29;
                }

                if (day>maxFebDays){ //выход за границы февраля
                    day -= maxFebDays;
                    month+=1;
                }
            }
            else if (isFound(day31, month)){//если 31 день
                if (day>31){
                    day-=31;
                    month+=1;
                    if (month>11){
                        month-=12;
                        year+=1;
                    }

                }
            }
            else{//все остальные месяцы
                if (day>30){
                    day-=30;
                    month+=1;
                }
            }

        }//случая возвращения в прошлое
        else if (allMinutes<0){
            allMinutes = 24*60 + allMinutes;
            day-=1;
            if ((month-1)==1){//случай, если предыдущий месяц февраль
                int maxFebDays=28; //флаг високосности

                if ((year%4==0 & year%100!=0) | (year%400==0)){ //условие високосности
                    maxFebDays = 29;
                }

                if (day<=0){ //выход за границы февраля
                    day = maxFebDays;
                    month-=1;
                }
            }
            else if (isFound(day31, month-1)){//случай, если в предыдущем месяце 31 день
                if (day<=0){
                    day=31;
                    month-=1;
                    if (month<0){
                        month=11;
                        year-=1;
                    }

                }
            }
            else{//случай, если в предыдущем месяце 30 дней
                if (day<=0){
                    day=30;
                    month-=1;
                }
            }
        }
        return String.join("-", ""+year,""+(month+1), ""+day) + " " + formatTime((int) allMinutes/60, ((int) allMinutes)%60);
    }

    public static boolean isFound(int[] arr, int num){ //функция для проверки, есть ли элемент в массиве
        for (int i:arr){
            if (i==num){
                return true;
            }
        }
        return false;
        
    }

    public static String formatTime(int hour, int minutes){
        return String.join(":", hour<10?"0"+hour:""+hour, minutes<10?"0"+minutes:""+minutes);
    }

    public static boolean isNew(int num){
        ArrayList<Character> digits = new ArrayList<>();
        String tempNum = "" + num;
        String newNum = "";
        char tempDigit = tempNum.charAt(0);
        for (int i=0; i<tempNum.length(); i++){
            digits.add(tempNum.charAt(i));
            if (tempNum.charAt(i)!='0'){
                tempDigit = (char) Math.min(tempDigit, tempNum.charAt(i));
            }
        }
        newNum += tempDigit;
        digits.remove(Character.valueOf(tempDigit));
        for (int i=1; i<tempNum.length(); i++){
            tempDigit = digits.get(0);
            for (int j=1; j<digits.size(); j++){
                tempDigit = (char) Math.min(tempDigit, digits.get(j));
            }
            newNum+=tempDigit;
            digits.remove(Character.valueOf(tempDigit));
        }
        if (Integer.parseInt(newNum)<num){
            return false;
        }
        else{
            return true;
        }
    }
}
