package net.devstudy.framework.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/*
 * ������ �������� �������� �� �� ��� ����� �������� ����������� � �� �� ��� ������ ����� ������ ������������� ������
 * �����������, ����� ����������� ����� ��������� ��� �������, FacebookSocialService, OrderServiceImpl, ProductServiceImpl,
 *  
 *  ��������� �������, ��� ������ ����� �������� ����������� �� ������ ���� ��������� 
 * */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Component {
}
