import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.*; 
public class TextExample { 
	public static void main(String[] args) { 
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setSize(200,200);
		final Text text = new Text(shell, SWT.CENTER | SWT.BORDER);
		text.setSize(200,25);
		final Label label = new Label(shell, SWT.CENTER);
		label.setLocation(0,100);
		label.setSize(200,25);
		text.addListener(SWT.Modify, new Listener() {
			public void handleEvent(Event event) {
				label.setText(Integer.toString(text.getText().length()));
			}
		});
		shell.pack();
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) display.sleep();
		}
		display.dispose();
	}
}