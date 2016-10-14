package net.devstudy.framework.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/*
 * ƒанна€ анотаци€ отвечает за то что класс €вл€етс€ компонентом и за то что данный класс должен автоматически создан
 * контейнером, таким компонентом будут выступать все сервисы, FacebookSocialService, OrderServiceImpl, ProductServiceImpl,
 *  
 *   омпонетн говорит, что данный класс €вл€етс€ компонентом он должен быть обработан 
 * */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Component {
}
