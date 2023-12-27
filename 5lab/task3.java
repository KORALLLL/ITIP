import java.util.regex.*;

public class task3 {
    public static void main(String[] args){
        String text = "some text with common link www.google.com, strange link chat.openai.gov , link with protokol https://vk.com, link with packages vk.com/dir1/dir2/dir3";
        System.out.println(text);
        System.out.println(replacer(text));
    }

    public static String replacer(String s){
        String regex = "\\b(?:https?://)?(?:www\\.)?([a-zA-Z0-9-]+\\.[a-z]{2,})\\b";

        // \\b обозначение границы группы
        // ?: - обозначение группы, которой мы не захватываем. То есть, если у нас есть https, то мы
        // этот https не берём.
        // последовательность http
        // s? может быть в этой последотвательности, а может и не быть
        // :// = часть адреса
        // (?:https?://)? знак вопроса означает, что эта часть может быть, а может и не быть
        // (?:www\\.)? - всё по аналогии

        //([a-zA-Z0-9-]+\\.[a-z]{2,}(?:/[a-zA-Z0-9-]+)*) домен
        // [a-zA-Z0-9-]+ может быть один или более симоволов
        // \\.[a-z]{2,} точка и значения после точки. После точки должно быть минимум две буквы в нижнем регистре
        // \\b обозначение границы
        Pattern pattern = Pattern.compile(regex);
        // паттерн для поиска по тексты
        Matcher matcher = pattern.matcher(s);
        // метчер для поиска совпаденией

        StringBuffer result = new StringBuffer();
        // Объект для построение строки с изменённой ссылкой

        while (matcher.find()) {
            String link = matcher.group(1);
            // поиск первого совпадение
            String replacement = "https://" + link;
            //изменение этого куска
            matcher.appendReplacement(result, replacement);
            // в резалт мы добавляем всю строку до группы + то, что изменили
        }

        matcher.appendTail(result);
        //Добавление оставшейся части текста

        return result.toString();
    }
    
}
