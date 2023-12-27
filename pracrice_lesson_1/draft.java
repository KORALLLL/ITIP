public class draft{
    public static void main(String[] args){
        System.out.println(tables(123,58));
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