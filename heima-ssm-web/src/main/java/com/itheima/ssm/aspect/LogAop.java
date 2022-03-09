package com.itheima.ssm.aspect;

import com.itheima.ssm.domain.SysLog;
import com.itheima.ssm.service.SysLogService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.multipart.support.AbstractMultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.sql.Time;
import java.util.Date;

/**
 * 系统日志处理的AOP切面:
 *      一：获取用户访问的操作信息
 *      二：操作完成后将访问的操作信息保存到数据库中
 */
@Component
@Aspect
public class LogAop {
    @Autowired
    private HttpServletRequest request;//request对象
    @Autowired
    private SysLogService sysLogService;

    private Date visitTime;//访问的时间
    private Class clazz;//访问的类
    private Method method;//访问方法对象

    /**
     * 定义切入点：拦截controller层中所有的方法
     */
    @Pointcut("execution(* com.itheima.ssm.controller.*.*(..))")
    public void pt(){
    }

    /**
     * 前置通知：执行控制器方法之前的通知
     *      主要获取开始时间，
     *      执行的控制器类，
     *      执行的哪个控制器方法
     *
     * @param joinPoint 连接点
     */
    @Before("pt()")
    public void before(JoinPoint joinPoint) throws NoSuchMethodException {
        //1.获取开始访问时间
        visitTime=new Date();
        //2.获取具体访问的执行类
        clazz=joinPoint.getTarget().getClass();//获取连接点的目标类，来获取具体访问执行的类
        
        String methodName=joinPoint.getSignature().getName();//获取连接点对应的方法名称

        Object[] args = joinPoint.getArgs();//获取连接点方法的参数

        if (args.length == 0 || args == null) {//判断连接点方法参数是否为null，为null获取无参方法对象
            method = clazz.getMethod(methodName);//通过获取连接点目标类，获取该类对象的指定名称的无参方法对象
        }else {//不为空，获取有参方法对象
            Class[] classArgs=new Class[args.length];//参加数组对象，保存连接点方法对象
            for (int i = 0; i <args.length ; i++) {
                classArgs[i]=args[i].getClass();
            }
            //获取具体访问的方法
            method=clazz.getMethod(methodName,classArgs);//获取有参的目标类对象有参的方法
        } 

    }

    /**
     * 后置通知：执行控制器方法之后的通知
     *      一：
     *          主要获取执行时长:
     *              实现方式：通过后置通知的当前时间-前置通知的时间
     *          访问的ip:getRemoteAddr()方法获取客户端的ip地址
     *              通过request对象获取，当我request对象，由监听器，监听request的创建和销毁
     *
     *          访问的请求资源url:
     *              通过反射机制实现,获取目标控制器类和连接点控制器方法上的注解对象值
     *
     *          访问的用户名:
     *              通过从springsecurity中获取用户名/从request的session会话在获取用户信息
     *       二：封装获取到的日志信息，保存到数据库中
     * @param joinPoint
     */
    @After("pt()")
    public void after(JoinPoint joinPoint){
        //获取执行时长
        long executionTime = new Date().getTime() - visitTime.getTime();
        //获取访问的url
        String url="";
        if (clazz!=null&&method!=null&&clazz!=LogAop.class) {//判断目标类和方法不为Null,并且目标类不能为LogApp切面类
            //获取目标类上的注解对象,也就是获取控制器类上的注解@RequestMapping("/")
            RequestMapping clazzannotation = (RequestMapping)clazz.getAnnotation(RequestMapping.class);
            //获取目标方法上的注解对象，也就是获取控制器类方法中的注解@RequestMapping("/")
            RequestMapping methodannotation=(RequestMapping)method.getAnnotation(RequestMapping.class);
            if (clazzannotation != null) {//判断注解类对象也不能为null
                String czvalue = clazzannotation.value()[0];//获取类注类解中的值
                if (methodannotation != null) {
                    String mzvalue = methodannotation.value()[0];//获取连接点方法上的注解对象
                    //获取到访问的url
                    url=czvalue+mzvalue;
                }
            }
        }
        //获取访问的ip
       String ip = request.getRemoteAddr();
        //获取访问的用户名！

        //封装用户访问的日志信息
        SysLog sysLog=new SysLog(visitTime,"",ip,url,executionTime,"[类名]:"+clazz.getName()+"[方法名]:"+method.getName());
        this.sysLogService.saveLog(sysLog);
    }
}
