import java.util.concurrent.Semaphore;

public class WarehouseTransfer {
    public static void main(String[] args) {
        int[] array = {30,30,30,30,30,30, 50, 123, 100, 30};
        int numThreads = 3;

        // Общая переменная суммы
        SumHolder sumHolder = new SumHolder();

        // Создаем семафор для общей переменной суммы
        Semaphore sumSemaphore = new Semaphore(1);

        // Создаем семафоры для каждого элемента массива
        Semaphore[] elementSemaphores = new Semaphore[array.length];
        for (int i = 0; i < array.length; i++) {
            elementSemaphores[i] = new Semaphore(1);
        }

        // Создаем и запускаем потоки
        for (int i = 0; i < numThreads; i++) {
            new Thread(new Worker(i, array, sumHolder, sumSemaphore, elementSemaphores)).start();
        }
    }
}

class Worker implements Runnable {
    private final int id; //айди рабочего
    private final int[] array; //Массив, из которого мы будем брать значения
    private final SumHolder sumHolder; //общая сумма
    private final Semaphore sumSemaphore; //семафор для работы с общей суммой
    private final Semaphore[] elementSemaphores; //семафор для доступа к элементама массива

    public Worker(int id, int[] array, SumHolder sumHolder, Semaphore sumSemaphore, Semaphore[] elementSemaphores) {
        this.id = id;
        this.array = array;
        this.sumHolder = sumHolder;
        this.sumSemaphore = sumSemaphore;
        this.elementSemaphores = elementSemaphores;
    }

    @Override
    public void run() {
        while (true) { //идти будет всё по кругу, чтобы гарантированно забрать все грузы со склада
            for (int i = 0; i < array.length; i++) {
                try {
                    int flag=0; //флаг того, что можно грузить товар
                    // Пытаемся захватить семафор для элемента массива
                    if (elementSemaphores[i].tryAcquire()) {//Если получилось, то мы элемент захватили
                        int element = array[i]; //Получаем этот элемента

                        // Захватываем семафор для общей переменной суммы
                        sumSemaphore.acquire(); //Для того, чтобы один грузчик работал с суммой, а не все сразу, мы даём ему доступ
                        if (sumHolder.getSum()+element <=150){//Можем ли мы добавить
                            
                            sumHolder.add(element);
                            System.out.println("Worker " + id + ": Added " + element + ", Current weight: " + sumHolder.getSum());
                        }
                        else{flag=1;elementSemaphores[i].release();}//Если не может, то мы разблокируем этот семафор для других грузчиков
                        sumSemaphore.release(); //Разрешаем другим грузчикам работать с переменной суммы

                        // Если сумма превышает 150, обнуляем сумму
                        if (flag==1) { //отгрузка товара на другой склад
                            sumSemaphore.acquire(); 
                            sumHolder.reset();
                            System.out.println("Worker " + id + ": can't bring weight. They're/he's going to another warehouse. Current weight = 0");
                            sumSemaphore.release();
                            flag=0;
                        }
                        Thread.sleep(200);//Имитация загрузки, чтобы демонстрировать, что рабочие работают одновременное

                        
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // Если все семафоры элементов заблокированы, завершаем поток
            boolean allSemaphoresBlocked = true;
            for (Semaphore semaphore : elementSemaphores) {
                if (semaphore.availablePermits() > 0) {
                    allSemaphoresBlocked = false;
                    break;
                }
            }

            if (allSemaphoresBlocked) {
                System.out.println("Worker " + id + " finished its work");
                break;
            }
        }
    }
}

// Несколько потоков будут работать с одной и той же переменной, поэтому необходимо синхронизировать доступ к этому ресурсу
class SumHolder {
    private int sum = 0;

    public synchronized void add(int value) {
        sum += value;
    }

    public synchronized void reset() {
        sum = 0;
    }

    public synchronized int getSum() {
        return sum;
    }
}
