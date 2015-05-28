/**
 * Lacus
 * hitwh.yxx.lacus.listeners
 * 
 */
package hitwh.zcc.CA.util;

import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author lacus .<br>
 * 2015年4月15日<br>
 * 说明：LacusListener是全局监听器<br>
 * 
 */
public class LacusListener implements ServletContextListener,ServletRequestListener
    ,ServletRequestAttributeListener,HttpSessionListener,HttpSessionAttributeListener{

    /**
     * 当应用结束时会调用的方法
     */
    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        String serverInfo = arg0.getServletContext().getServerInfo();
        System.out.println("来自Lacus监听器：" + serverInfo);
        System.out.println("*****************************************************************\n"
                +"                *            *          ****      *     *        **** \n"
                +"                *           * *       *            *     *       *       \n"
                +"                *          ****     *             *     *        **** \n"
                +"                *         *     *     *            *     *              *\n"
                +"                *****  *       *     *****      ****        ***** \n"
                +"应用已经停止!");
    }

    /**
     * 当应用启动时会调用的方法<br>
     * 输出包含的servlet信息和Attribute信息<br>
     */
    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        System.out.println("\t来自Lacus监听器：" );
        System.out.println("*******************************************************************\n"
                +"                *            *          ****      *     *        ****\n"
                +"                *           * *       *            *     *       *\n"
                +"                *          ****     *             *     *        ****\n"
                +"                *         *     *     *            *     *              *\n"
                +"                *****  *       *     *****      ****       *****\n"
                +"应用完成启动!");
        
        /*
        System.out.println("\nServlet信息：");
        while(servletInfo.hasMoreElements())
            System.out.println("\t"+ servletInfo.nextElement());
        
        System.out.println("\n\nAttribute信息：" + attributeInfo.toString());
        while(attributeInfo.hasMoreElements()){
            String attributeName = attributeInfo.nextElement();
            Object attribute = arg0.getServletContext().getAttribute(attributeName);
            
            Class clazz = attribute.getClass();

            System.out.printf("%70s : %70s",  attributeName ,clazz.getName() + "\n");  
        }
        */
        System.out.println("******************************************************************"); 
        System.out.println("******************************************************************\n"); 
    }

    /**
     * 请求销毁调用的方法
     */
    @Override
    public void requestDestroyed(ServletRequestEvent arg0) {
        HttpServletRequest request = (HttpServletRequest) arg0.getServletRequest();
        Enumeration<String> params = request.getParameterNames();
        Enumeration<String> attrs = request.getAttributeNames();
        String queryString = request.getQueryString();
        StringBuffer requestURL = request.getRequestURL();
        
        
        System.out.println("******************************************************************"); 
        System.out.println("\t来自Lacus监听器：");
        System.out.println("请求已销毁！");
        System.out.println("QueryString ：" + queryString);
        System.out.println("RequestURL  ：" + requestURL +"\n");
        
        System.out.println("请求参数：");
        while(params.hasMoreElements()){
            String para = params.nextElement();
            System.out.println("\t" + para + "\t" + request.getParameter(para));
        }
        
        System.out.println("请求属性：");
        while(attrs.hasMoreElements()){
            String attr = attrs.nextElement();
            System.out.println("\t" + attr + "\t" + request.getAttribute(attr));
        }
        System.out.println("******************************************************************\n"); 
        
    }

    /**
     * 请求初始化
     * */
    @Override
    public void requestInitialized(ServletRequestEvent arg0) {
        HttpServletRequest request = (HttpServletRequest) arg0.getServletRequest();
        Enumeration<String> params = request.getParameterNames();
        Enumeration<String> attrs = request.getAttributeNames();
        String queryString = request.getQueryString();
        StringBuffer requestURL = request.getRequestURL();
        
        
        System.out.println("\n\n******************************************************************"); 
        System.out.println("*******************************************************************\n"
                +"                *            *          ****      *     *        ****\n"
                +"                *           * *       *            *     *       *\n"
                +"                *          ****     *             *     *        ****\n"
                +"                *         *     *     *            *     *              *\n"
                +"                *****  *       *     *****      ****       *****\n"
                +"请求初始化中!");
        System.out.println("QueryString ：" + queryString);
        System.out.println("RequestURL  ：" + requestURL +"\n");
        
        System.out.println("请求参数：");
        while(params.hasMoreElements()){
            String para = params.nextElement();
            System.out.println("\t" + para + "\t" + request.getParameter(para));
        }
        
        System.out.println("请求属性：");
        while(attrs.hasMoreElements()){
            String attr = attrs.nextElement();
            System.out.println("\t" + attr + "\t" + request.getAttribute(attr));
        }
        System.out.println("******************************************************************\n"); 
    }

    @Override
    public void attributeAdded(ServletRequestAttributeEvent arg0) {
        String attr = arg0.getName();
        
        String value = null;
        if(arg0.getValue().toString().length() > 50){
            value = arg0.getValue().toString();
        }else{
            value = "Too Long To Show!";
        }
        
        Object source = arg0.getSource();
        
        System.out.println("******************************************************************"); 
        System.out.println("\t来自Lacus监听器：新添请求属性");
        System.out.println("From                ：" + ((HttpServletRequest)arg0.getServletRequest()).getRequestURL()  );
        System.out.println("Attribute Name：" + attr);
        System.out.println("Attribute Value：" + value);
        System.out.println("******************************************************************\n"); 
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent arg0) {
        String attr = arg0.getName();
        
        String value = null;
        if(arg0.getValue().toString().length() > 50){
            value = arg0.getValue().toString();
        }else{
            value = "Too Long To Show!";
        }
        
        Object source = arg0.getSource();
        
        System.out.println("******************************************************************"); 
        System.out.println("\t来自Lacus监听器：删除请求属性");
        System.out.println("From                ：" + ((HttpServletRequest)arg0.getServletRequest()).getRequestURL()  );
        System.out.println("Attribute Name：" + attr);
        System.out.println("Attribute Value：" + value);
        System.out.println("******************************************************************\n"); 
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent arg0) {
        String attr = arg0.getName();
        
        String value = null;
        if(arg0.getValue().toString().length() > 50){
            value = arg0.getValue().toString();
        }else{
            value = "Too Long To Show!";
        }
        
        Object source = arg0.getSource();
        
        System.out.println("******************************************************************"); 
        System.out.println("\t来自Lacus监听器：替代请求属性");
        System.out.println("From                ：" + ((HttpServletRequest)arg0.getServletRequest()).getRequestURL()  );
        System.out.println("Attribute Name：" + attr);
        System.out.println("Attribute Value：" + value);
        System.out.println("******************************************************************\n"); 
    }

    @Override
    public void sessionCreated(HttpSessionEvent arg0) {
        Object source = arg0.getSource();
        HttpSession session = arg0.getSession();
        Date createDateTime = new Date(session.getCreationTime());
        
        String sessionId = session.getId();
        int activeMinutes = session.getMaxInactiveInterval()/60;
        
        System.out.println("\n\n******************************************************************"); 
        System.out.println("*******************************************************************\n"
                +"                *            *          ****      *     *        ****\n"
                +"                *           * *       *            *     *       *\n"
                +"                *          ****     *             *     *        ****\n"
                +"                *         *     *     *            *     *              *\n"
                +"                *****  *       *     *****      ****       *****\n"
                +"\t来自Lacus监听器：会话启动!");
        System.out.println("Session ID    ：" + sessionId);
        System.out.println("Create Date  ：" + createDateTime);
        System.out.println("Active Time   ：" +  activeMinutes + " minutes");
        System.out.println("******************************************************************\n"); 
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent arg0) {
        HttpSession session = arg0.getSession();
        Date createDateTime = new Date(session.getCreationTime());
        
        String sessionId = session.getId();
        int activeMinutes = session.getMaxInactiveInterval()/60;
        
        System.out.println("******************************************************************"); 
        System.out.println("*******************************************************************\n"
                +"                *            *          ****      *     *        ****\n"
                +"                *           * *       *            *     *       *\n"
                +"                *          ****     *             *     *        ****\n"
                +"                *         *     *     *            *     *              *\n"
                +"                *****  *       *     *****      ****       *****\n"
                +"\t来自Lacus监听器：会话启动!");
        System.out.println("Session ID    ：" + sessionId);
        System.out.println("Create Date  ：" + createDateTime);
        System.out.println("Active Time   ：" +  activeMinutes + " minutes");
        System.out.println("******************************************************************\n"); 
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent arg0) {
        HttpSession session = arg0.getSession();

        String sessionId = session.getId();
        String name = arg0.getName();
        String value = null;
        if(arg0.getValue().toString().length() > 50){
            value = "TOO lONG!";
        }else{
            value = arg0.getValue().toString();
        }
 
        System.out.println("******************************************************************"); 
        System.out.println("\t来自Lacus监听器：添加会话属性");
        System.out.println("Session ID         ：" + sessionId);
        System.out.println("Attribute Name ：" + name);
        System.out.println("Attribute Value  ：" + value);
        System.out.println("******************************************************************\n"); 
        
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent arg0) {
        HttpSession session = arg0.getSession();

        String sessionId = session.getId();
        String name = arg0.getName();
        String value = null;
        if(arg0.getValue().toString().length() > 50){
            value = "TOO lONG!";
        }else{
            value = arg0.getValue().toString();
        }
 
        System.out.println("******************************************************************"); 
        System.out.println("\t来自Lacus监听器：删除会话属性");
        System.out.println("Session ID         ：" + sessionId);
        System.out.println("Attribute Name ：" + name);
        System.out.println("Attribute Value  ：" + value);
        System.out.println("******************************************************************\n"); 
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent arg0) {
        HttpSession session = arg0.getSession();

        String sessionId = session.getId();
        String name = arg0.getName();
        String value = null;
        if(arg0.getValue().toString().length() > 50){
            value = "TOO lONG!";
        }else{
            value = arg0.getValue().toString();
        }
 
        System.out.println("******************************************************************"); 
        System.out.println("\t来自Lacus监听器：替换会话属性");
        System.out.println("Session ID         ：" + sessionId);
        System.out.println("Attribute Name ：" + name);
        System.out.println("Attribute Value  ：" + value);
        System.out.println("******************************************************************\n"); 
    }
}
