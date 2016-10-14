package net.devstudy.framework.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/*
 * С помощью данной анотации мы будем указывать, что контейнер должен внедрить зависимость указаного класса по типу
 * При использовании аннотации контейнер будет создавать компонент автоматически нашел класс, который реализует данный интерфейс
 * создал объект этого класса И ДОБАВИЛ этот объект через рефлексию в это поле. Для этого поля должны быть не final
 * И должен быть конструктор по умолчанию 
 * 
 * Спомощью Autowired внедряем зависимость 
 * */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Autowired {
}