import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.*; 
public class ComboExample { 
	public static void main(String[] args) { 
		Display display = new Display ();
		Shell shell = new Shell (display);
		Combo combo = new Combo (shell, SWT.SIMPLE | SWT.READ_ONLY);
		combo.setItems(new String [] {"Three", "Six", "Eight"});
		combo.setSize(200, 50);
		shell.pack ();
		shell.open ();
		while (!shell.isDisposed ()) {
			if (!display.readAndDispatch ()) display.sleep ();
		}
		display.dispose ();
	}
}