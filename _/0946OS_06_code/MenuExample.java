import org.eclipse.swt.SWT;

import org.eclipse.swt.widgets.*; 
public class MenuExample { 
	public static void main(String[] args) { 
	    Display display = new Display(); 
	    Shell shell = new Shell(display); 
	    Menu menuBar = new Menu(shell, SWT.BAR); 
	    shell.setMenuBar(menuBar); 
	    MenuItem fileItem = new MenuItem(menuBar, SWT.CASCADE); 
	    fileItem.setText("File"); 
	    MenuItem editItem = new MenuItem(menuBar, SWT.CASCADE); 
	    editItem.setText("Edit"); 
	    Menu fileMenu = new Menu(shell, SWT.DROP_DOWN); 
	    fileItem.setMenu(fileMenu); 
	    String [] fileStrings = {"New", "Exit"}; 
	    for (int i=0; i<fileStrings.length; i++) { 
	          MenuItem item = new MenuItem(fileMenu, SWT.PUSH); 
	          item.setText(fileStrings [i]); 
	    } 
	    Menu editMenu = new Menu(shell, SWT.DROP_DOWN); 
	    String [] editStrings = {"Copy", "Paste"}; 
	    editItem.setMenu(editMenu); 
	    for (int i=0; i<editStrings.length; i++) { 
	          MenuItem item = new MenuItem(editMenu, SWT.PUSH); 
	          item.setText(editStrings [i]); 
	    } 
	    shell.pack(); 
	    shell.open(); 
	    while (!shell.isDisposed()) { 
	        if (!display.readAndDispatch()) display.sleep(); 
	    } 
	    display.dispose(); 
	}
}