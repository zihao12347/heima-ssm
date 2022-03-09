package com.itheima;

/**
 * SpringSecurity基础实现：
 *      1.导入springSecurity的坐标依赖：
 *      2.在web.xml配置文件中：配置springSecurity拦截器:delegatingFilterProxy
 *          <filter>
 *              拦截器名称必须为：springSecurityFilterChain
 *              <filter-name>springSecurityFilterChain</filter-name>
 *              <filter-class>org.springframework.web.filter.DelegatingFilterProxy</filter-class>
 *          </filter>
 *       3.配置spring-security的配置文件
 *
 *
 */
public class App {
}
