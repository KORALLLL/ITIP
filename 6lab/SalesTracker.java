import java.util.*;
/*
Программа должна позволять добавлять проданные товары в коллекцию,
выводить список проданных товаров, а также считать общую сумму
продаж 
Использовать TreeSet для хранения списка проданных
товаров.
 */

 /*
TreeSet в Java является реализацией интерфейса Set, который расширяет SortedSet. Он представляет собой набор уникальных элементов, 
отсортированных в порядке возрастания. Вот основные характеристики TreeSet:
1.	Уникальность элементов: TreeSet не допускает наличие дубликатов. Если вы пытаетесь добавить элемент, который уже присутствует в 
множестве, операция добавления просто проигнорируется.
2.	Сортировка элементов: Элементы в TreeSet автоматически сортируются в возрастающем порядке на основе их значений или с 
использованием компаратора, предоставленного при создании множества.
3.	Бинарное дерево поиска: Внутри TreeSet использует структуру данных, называемую бинарным деревом поиска. Это эффективная структура 
для хранения и поиска отсортированных данных.
4.	Операции добавления, удаления и поиска: Операции добавления, удаления и поиска элементов в TreeSet выполняются в среднем 
за логарифмическое время, что делает его эффективным для больших объемов данных
  */
public class SalesTracker {
    private TreeSet<String> soldProducts;
    private int counter = 0;

    public SalesTracker(){
        soldProducts = new TreeSet<>();
        //конструтктов
    }

    public void addSale(String product){
        soldProducts.add(product);
        counter++;
        //Добавление элемента
    }

    public void displaySales(){
        for (String i:soldProducts){
            System.out.println(i);
        }
        // Итерация по всем объектам и их вывод
    }

    public double calculateTotalSales(){
        return counter;
    }

    public static void main(String[] args) {
        SalesTracker salesTracker = new SalesTracker();

        salesTracker.addSale("book");
        salesTracker.addSale("jacket");
        salesTracker.addSale("cup");
        salesTracker.addSale("book"); // Продажа еще одной книги

        //список проданных товаров с количеством
        salesTracker.displaySales();

        // Общее количество продаж
        System.out.println(salesTracker.calculateTotalSales());

    }
}