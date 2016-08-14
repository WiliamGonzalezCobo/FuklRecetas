package co.com.general.bean;

import javax.faces.context.FacesContext;

public class FacesUtils {
	
	@SuppressWarnings({"unchecked", "el-syntax"})
	public static <T> T getBean(String beanName) {
		FacesContext context = FacesContext.getCurrentInstance();
		return (T) context.getApplication().evaluateExpressionGet(context, "#{" + beanName+ "}", Object.class);
	}
	
}
