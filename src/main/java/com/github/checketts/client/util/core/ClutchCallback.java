package com.github.checketts.client.util.core;


/**
 * The basic building block for asynchronous calls to the server.  
 * 
 * @author clintchecketts
 *
 * @param <T> The type of the POJO your json will represent.
 */
public abstract class ClutchCallback<T>{
    
    // the AutoBeanCodex needs the class of our domain object to convert it.
    private Class<T> resultClass;

    public ClutchCallback(Class<T> resultClass) {
        this.resultClass = resultClass;
    }

    /**
     * The code to be executed when the call returns from the server with your data.  
     * @param data Your data from the server call
     */
    public abstract void onComplete(T data);


    public void onError(Throwable exception) {
      //Clutch notifies the user by default, so not required
    }
    
    public final Class<T> getResultClass() {
        return resultClass;
    }
}
