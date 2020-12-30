import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.*; 
public class LabelExample { 
	public static void main(String[] args) { 
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setText("Label Sample");
		shell.setSize(300,200);
		Label label = new Label(shell, SWT.CENTER);
		label.setText("Nothing But The Rain");
		label.setSize(300,300);

		shell.open(); 
		while (!shell.isDisposed()) { 
			if (!display.readAndDispatch()) 
				display.sleep(); 
		} 
		display.dispose(); 
	}
}