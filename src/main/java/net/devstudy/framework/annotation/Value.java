package net.devstudy.framework.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/*
 * Аннотация value будет говорить, что нужно считать конфигурационный параметр с конфик файла и этот параметр установить
 * в переменную нашего компонента.
 * С помощью аннотации value мы будем конфигурировать. Мы будем хотеть чтобы контейнер считал свойства из application.properties
 * и установил их в параметр.
 * 
 * С помощью Value считываем свойства проперти файла 
 * 
 * */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Value {
String value();
}
