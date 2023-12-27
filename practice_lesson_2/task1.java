public class task1 {
    public static void main(String[] args){ //основная функция
        System.out.printf("%s %s %s\n", 
            convert(5), 
            convert(3), 
            convert(8)); //метод при решении задачи несколько раз по всем входным данными
        System.out.println("-------------");

        System.out.printf("%s %s %s\n", 
            fitCalc(15, 1), 
            fitCalc(24, 2), 
            fitCalc(41, 3));
        System.out.println("-----------");

        System.out.printf("%s %s %s\n",
            containers(3, 4, 2),
            containers(5, 0, 2),
            containers(4, 1, 4));
        System.out.println("-----------");

        System.out.printf("%s \n %s \n %s \n %s\n",
            triangleType(5, 5, 5),
            triangleType(5, 4, 5),
            triangleType(3, 4, 5),
            triangleType(5, 1, 1));
        System.out.println("--------------");

        System.out.printf("%s %s %s\n",
            ternaryEvaluation(8, 4),
            ternaryEvaluation(1, 11),
            ternaryEvaluation(5, 9));
        System.out.println("-----------");

        System.out.printf("%s %s %s\n",
            howManyItems(22, 1.4, 2),
            howManyItems(45, 1.8, 1.9),
            howManyItems(100, 2, 2));
        System.out.println("--------------");

        System.out.printf("%s %s %s\n",
            factorial(3),
            factorial(5),
            factorial(7));
        System.out.println("------------");

        System.out.printf("%s %s %s\n",
            gcd(48, 18),
            gcd(52, 8),
            gcd(259, 28));
        System.out.println("---------");

        System.out.printf("%s %s %s\n",
            ticketSaler(70, 1500),
            ticketSaler(24, 950),
            ticketSaler(53, 1250));
        System.out.println("------");

        System.out.printf("%s %s %s\n",
            tables(5,2),
            tables(31,20),
            tables(123,58));
    }

    public static float convert(int x)//возврат дробного числа
    {
        return x * 3.785f; //f указывает яснов что число float
    }

    public static int fitCalc(int minutes, int intensity){
        return minutes * intensity;
    }

    public static int containers(int count_box, int count_bags, int count_barrels){
        int box_capacity = 20;
        int bag_capacity = 50;
        int barrel_capacity = 100;
        return count_box * box_capacity + count_bags * bag_capacity + count_barrels * barrel_capacity;
    }  

    public static String triangleType(int a, int b, int c){
        if ((a+b<c) || (a+c<b) || (b+c<a)){
            return "not a triangle";
        }
        else if ((a == c) && (c == b) && (b ==a)){
            return "equilateral";
        }
        else if ((a == b) || (b==c) || (a==c)){
            return "isosceles";
        }
        else{
            return "different-sided";
        }
    }

    public static int ternaryEvaluation(int a, int b){
        return a > b ? a : b;
    }

    public static int howManyItems(int n, double w, double h){
        return (int) (n / 2 / w /h);
    }

    public static int factorial(int a){
        int fact = 1;
        for (int i = 1; i <= a; i++){
            fact *= i;
        }
        return fact;
    }

    public static int gcd(int a, int b){
        while ((a != 0) && (b != 0)) {
            if (a>b){
                a %= b;
            }
            else{
                b %= a;
            }
        }
        return(a + b);
    }

    public static int ticketSaler(int a, int b){
        return (int) (a * b * 0.72);
    }

    public static int tables(int students, int desks){
        desks *= 2;
        if (students <= desks){
            return 0;
        }
        else{
            if (students % 2 == 0){
                return (students - desks) / 2;
            }
            else{
                return (students - desks + 1) / 2;
            }
        }
    }
}


/* 
byte, int, float, char типы данных

static ключевое слово, говорящее о том, что чтобы этот метод заработал, его можно
просто позвать по имени

int x = 7; - инициализация переменной 

ветвление if(условие){} else if(){}

три цикла
while(условие){блок кода}

do {блок кода} while(условие)

for(int i=0; i<10; i++)


тип данных чар
char x='x'

если вернуть строку, то пишем
public static String ---- 
*/ 