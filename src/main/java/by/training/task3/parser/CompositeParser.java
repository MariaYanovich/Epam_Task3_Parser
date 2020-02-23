package by.training.task3.parser;

import by.training.task3.enums.TextComponentType;
import by.training.task3.entity.impl.TextComposite;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CompositeParser {
    private CompositeParser() {
    }

    public static TextComposite parseComposite(String textToParse,
                                               TextComponentType type,
                                               String regex,
                                               Parser nextParser) {
        TextComposite composite = new TextComposite(type);
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(textToParse);
        TextComposite component;
        while (matcher.find()) {
            component = nextParser.parse(matcher.group());
            composite.add(component);
        }
        return composite;
    }
}
