import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.*; 
public class ListExample { 
	public static void main(String[] args) { 
		Display display = new Display ();
		Shell shell = new Shell (display);
		final List list = new List (shell, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL);
		for (int i=0; i<10; i++) list.add ("Item " + i);
		list.setSize(200, 200);
		list.addListener (SWT.Selection, new Listener () {
			public void handleEvent (Event e) {
				String string = "";
				int [] selection = list.getSelectionIndices();
				for (int i=0; i<selection.length; i++) 
					string += selection[i] + " ";
				System.out.println ("Selected: " + string);
			}
		});
		shell.pack ();
		shell.open ();
		while (!shell.isDisposed ()) {
			if (!display.readAndDispatch ()) display.sleep ();
		}
		display.dispose ();
	}
}