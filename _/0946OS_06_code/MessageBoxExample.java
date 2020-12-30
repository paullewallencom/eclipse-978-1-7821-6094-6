import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;


public class MessageBoxExample { 
	public static void main(String[] args) { 
		Display display = new Display(); 
		Shell shell = new Shell(display); 

		shell.setSize(500,400); 
		shell.setLayout(new FillLayout( )); 


		MessageBox messageBox = new MessageBox(shell, SWT.ICON_QUESTION | SWT.YES | SWT.NO); 
		messageBox.setMessage("Do you really want to quit?"); 
		messageBox.setText("Exiting Application"); 
		int response = messageBox.open( ); 
		if (response==SWT.YES) {
			shell.dispose();
			System.exit(0);
		}

		shell.open( ); 
		while(!shell.isDisposed()){ 
			if(!display.readAndDispatch( )) 
				display.sleep( ); 
		} 
		display.dispose();
	}
}