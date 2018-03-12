package model.hibernate;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;

@WebFilter(
		urlPatterns={"/*"},
		initParams={
			@WebInitParam(name="sessionFactoryBeanName", value="sessionFactory")
		}
)
public class OpenSessionInViewFilter implements Filter {
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		try {
			sessionFactory.getCurrentSession().beginTransaction();			//呼叫Servlet之前的前置作業
			chain.doFilter(request, response);								//呼叫Servlet		
			sessionFactory.getCurrentSession().getTransaction().commit();	//呼叫Servlet之後的後續工作
		} catch (HibernateException e) {
			e.printStackTrace();
			sessionFactory.getCurrentSession().getTransaction().rollback();
			chain.doFilter(request, response);								//呼叫Servlet
		}
	}
	
	private SessionFactory sessionFactory;
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		ServletContext application = filterConfig.getServletContext();
		ApplicationContext context = (ApplicationContext)
				application.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
		
		String sessionFactoryBeanName = filterConfig.getInitParameter("sessionFactoryBeanName");
		if(sessionFactoryBeanName==null || sessionFactoryBeanName.length()==0) {
			sessionFactoryBeanName = "sessionFactory";
		}
		
		sessionFactory = (SessionFactory) context.getBean(sessionFactoryBeanName);
	}
	@Override
	public void destroy() {

	}
}
