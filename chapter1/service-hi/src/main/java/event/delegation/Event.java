package event.delegation;

import java.lang.reflect.Method;

public class Event {
	private Object obj;
	private String methodName;
	private Object[] params;
	private Class[] paramTypes;
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	public Object[] getParams() {
		return params;
	}
	public void setParams(Object[] params) {
		this.params = params;
	}
	public Class[] getParamTypes() {
		return paramTypes;
	}
	public void setParamTypes(Class[] paramTypes) {
		this.paramTypes = paramTypes;
	}
	public Event() {
		
	}
	public Event(Object obj,String methodName,Object...args) {
		this.obj= obj;
		this.methodName = methodName;
		this.params = args;
		contractParamTypes(this.params);
	}
	 private void contractParamTypes(Object[] params){     
        this.paramTypes=new Class[params.length];     
        for(int i=0;i<params.length;i++){     
            this.paramTypes[i]=params[i].getClass();     
        }     
    }
	 public void invoke() throws Exception {
		Method method=obj.getClass().getMethod(this.getMethodName(), this.getParamTypes());     
        if(null==method){     
            return;     
        }     
        method.invoke(this.getObj(), this.getParams());     
	 }
	
}
