import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*; 
public class GridExample { 
	public static void main(String[] args) { 
		Display display = new Display ();
		Shell shell = new Shell (display);
		GridLayout layout = new GridLayout(4, false);
		shell.setLayout(layout);
		Button b = new Button(shell, SWT.PUSH);
		b.setText("LEFT, TOP");
		b.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, true, true, 1, 1));
		b = new Button(shell, SWT.PUSH);
		b.setText("LEFT, CENTER");
		b.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, true, 1, 1));
		b = new Button(shell, SWT.PUSH);
		b.setText("LEFT, BOTTOM");
		b.setLayoutData(new GridData(SWT.LEFT, SWT.BOTTOM, true, true, 1, 1));
		b = new Button(shell, SWT.PUSH);
		b.setText("LEFT, FILL");
		b.setLayoutData(new GridData(SWT.LEFT, SWT.FILL, true, true, 1, 1));
		b = new Button(shell, SWT.PUSH);
		b.setText("FILL, TOP");
		b.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, true, 1, 1));
		b = new Button(shell, SWT.PUSH);
		b.setText("FILL, CENTER");
		b.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, true, 1, 1));
		b = new Button(shell, SWT.PUSH);
		b.setText("FILL, BOTTOM");
		b.setLayoutData(new GridData(SWT.FILL, SWT.BOTTOM, true, true, 1, 1));
		b = new Button(shell, SWT.PUSH);
		b.setText("FILL, FILL");
		b.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		shell.open ();
		while (!shell.isDisposed ()) {
			if (!display.readAndDispatch ()) display.sleep ();
		}
		display.dispose ();
	}
}