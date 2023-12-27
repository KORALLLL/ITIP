import java.io.*;

public class TaskTwo {
    public static void main(String[] args){
        String sourceFilePath = "input.txt";
        String targetFilePath = "output.txt";
        try(
            FileInputStream in = new FileInputStream(sourceFilePath);
            // поток для чтения файла
            FileOutputStream out = new FileOutputStream(targetFilePath, false);
            // поток для записи файла
        ){
            int bytesRead;
            // переменная для хранения количества прочитанный байт
            byte[] buffer = new byte[1024];
            // массив для временного хранения прочитанных данных
            while ((bytesRead = in.read(buffer))!=-1){
                // присвоили в переменную количество прочитанный байт
                out.write(buffer, 0, bytesRead);
                //buffer - что вставить
                // 0 - с какого элемента вставить
                //bytesRead - сколько элементов вставить
            }

            System.out.println("Файл успешно скопирован");
        }
        catch(IOException e){
            System.out.println("Ошибка ввода/вывода: "+ e.getMessage());
        }
    }
}
