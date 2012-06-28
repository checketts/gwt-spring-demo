package com.github.checketts.client.util.core;


/**
 * Helper class to include printing the window, also can add methods for printing various 
 * DOM section via: http://code.google.com/p/gwt-print-it/source/browse/trunk/src/br/com/freller/tool/client/Print.java
 *  
 * @author clintchecketts
 *
 */
public class Print {

    public static native void printWindow() /*-{
		$wnd.print();
    }-*/;
    
}
