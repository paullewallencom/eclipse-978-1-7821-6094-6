import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;


public class FileDialogExample { 
	public static void main(String[] args) { 
		Display display = new Display(); 
		Shell shell = new Shell(display); 

		shell.setSize(500,400); 
		shell.setLayout(new FillLayout( )); 


		FileDialog fd = new FileDialog(shell, SWT.OPEN); 
		fd.setText("Open"); 
		fd.setFilterPath("/"); 
		String[] filterExt = {"*.txt"}; 
		fd.setFilterExtensions(filterExt); 
		String selected = fd.open( ); 
		System.out.println(selected);

		shell.open( ); 
		while(!shell.isDisposed()){ 
			if(!display.readAndDispatch( )) 
				display.sleep( ); 
		} 
		display.dispose();
	}
}