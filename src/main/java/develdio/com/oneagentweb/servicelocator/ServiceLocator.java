package develdio.com.oneagentweb.servicelocator;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ServiceLocator implements ApplicationContextAware
{
	private static ServiceLocator instance;
	private ApplicationContext ac;

	public void setApplicationContext( ApplicationContext arg0 )
			throws BeansException 
	{
		instance = this;
		ac = arg0;
	}

	public static ServiceLocator getInstance()
	{
		return instance;
	}

	public Object getBean( String beanName )
	{
		Object result = ac.getBean(beanName);
		return result;
	}

	public Object getBean( String beanName, Class requiredType )
	{
		Object result = ac.getBean( beanName, requiredType );
		return result;
	}
}
