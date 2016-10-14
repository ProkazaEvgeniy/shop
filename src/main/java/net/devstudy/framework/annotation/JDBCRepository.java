package net.devstudy.framework.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/*
 * анная аннотация будет говрить данный интерфейс является репозиторием JDBCRepository и соответственно нужно создать
 * автоматически динамический JDBCRepository прокси. Эти аннотации нужно поставить над интерфейсами.
 * 
 * С помощью JDBCRepository говорим о том, что данный интерфейс является у нас репозиторием
 * */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface JDBCRepository {
}