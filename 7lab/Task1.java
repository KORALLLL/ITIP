import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Task1 {
    /*
    Реализация многопоточной программы для вычисления суммы
    элементов массива.
    Вариант 2. Создать пул потоков с помощью класса ExecutorService и
    разделить массив на равные части, каждую из которых будет
    обрабатывать отдельный поток. После завершения работы всех потоков
    результаты будут складываться в главном потоке.
     */
    public static void main(String[] args){
        int [] array = new int[10000];
        for (int i=0; i<10000; i++){
            array[i] = i;
        }
        
        //количество потоков в пуле
        int numThreads = 3;

        // Сам пул потоков
        //executorService описывает сервис для запуска runnable и callable задач
        //в качестве возвращаемого значения Future
        //callable возвращает значение.
        ExecutorService executorService = Executors.newFixedThreadPool(numThreads);

        // мы будем разбивать массив на части. Это часть массива
        int chunkSize = array.length / numThreads;

        //Массив для хранения результатов выполнения каждого потока
        Future<Integer>[] results = new Future[numThreads];

        //запуск потоков для обработки частей массива
        for (int i=0; i<numThreads; i++){
            int start = i*chunkSize;
            int end = (i == numThreads-1) ? array.length : (i+1)*chunkSize;

            // Создаём задачу для каждого потока и передаём ей часть массива
            ArraySumTask task = new ArraySumTask(array, start, end);

            // помещаем задачу в пул потоков и сохраняем результат выопленения

            results[i] = executorService.submit(task);
        }

        // Завершение работы пула потоков

        executorService.shutdown();

        // Суммируем результаты выполнения потоков
        int totalSum = 0;
        try {
            for (Future<Integer> result : results){
                totalSum += result.get();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        System.out.println(totalSum);
    }
}

class ArraySumTask implements java.util.concurrent.Callable<Integer>{
    private int[] array;
    private int startIndex;
    private int endIndex;

    public ArraySumTask(int[] array, int start, int end){
        this.array = array;
        this.startIndex = start;
        this.endIndex = end;
    }

    @Override
    public Integer call(){
        int sum = 0;
        for (int i=startIndex; i<endIndex; i++){
            sum+=array[i];
        }
        return sum;
    }
}