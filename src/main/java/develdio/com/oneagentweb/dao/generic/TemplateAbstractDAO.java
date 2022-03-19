package develdio.com.oneagentweb.dao.generic;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("templateAbstractDao")
public abstract class TemplateAbstractDAO
{
	@Autowired
	@Qualifier("template")
	protected ProducerTemplate template;

	@SuppressWarnings("unchecked")
	public ProducerTemplate getTemplate()
	{
		return template;
	}

	@SuppressWarnings("unchecked")
	public void setTemplate( ProducerTemplate template )
	{
		this.template = template;
	}
}
