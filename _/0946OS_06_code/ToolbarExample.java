import org.eclipse.swt.SWT;

import org.eclipse.swt.widgets.*; 
public class ToolbarExample { 
	public static void main(String[] args) { 
	    Display display = new Display(); 
	    Shell shell = new Shell(display); 
	    ToolBar toolBar = new ToolBar(shell, SWT.HORIZONTAL); 
	    ToolItem item = new ToolItem(toolBar, SWT.DROP_DOWN); 
	    item.setText("Drop Down Behavior (Combo)"); 
	    toolBar.pack(); 
	    shell.pack(); 
	    shell.open(); 
	    while (!shell.isDisposed()) { 
	        if (!display.readAndDispatch()) display.sleep(); 
	    } 
	    display.dispose(); 
	}
}