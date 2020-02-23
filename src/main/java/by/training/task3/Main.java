package by.training.task3;

import by.training.task3.entity.impl.TextComposite;
import by.training.task3.parser.Parser;
import by.training.task3.parser.impl.TextParser;
import by.training.task3.reader.TextReaderFromFile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// Разобранный текст должен быть представлен в виде объекта, содержащего, например,
// абзацы, предложения, лексемы, слова, символы. Лексема – часть текста, ограниченная пробельными символами.
// Использовать Composite.
//  Классы с информацией являются классами сущностей
// и не должны быть перенагружены методами логики.
//  Разобранный текст необходимо
// восстановить в первоначальном виде. Пробелы и знаки табуляции при разборе могут заменяться одним пробелом.
//  Для деления текста на составляющие следует использовать регулярные выражения.
// Регулярные выражения для приложения определять как литеральные константы.
//  Код, выполняющий разбиение текста на составляющие части, следует оформить в виде классов-парсеров
// с использованием Chain of Responsibility.
//  При разработке парсеров, разбирающих текст, необходимо следить за количеством создаваемых объектов-парсеров.
//  Для записи логов использовать Log4J.
//  Реализовывать индивидуальные задания по работе над текстом.
public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class.getName());

    public static void main(String[] args) {

        TextReaderFromFile textReaderFromFile = new TextReaderFromFile();
        TextComposite textComponents;
        Parser parser;
        parser = new TextParser();
        textComponents = parser.parse(textReaderFromFile.getTextStr());
        LOGGER.debug(textComponents.getTextComponentsList());
    }
}
