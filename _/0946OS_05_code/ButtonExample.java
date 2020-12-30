import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*; 
public class ButtonExample { 
	public static void main(String[] args) { 
		Display display = new Display ();
		Shell shell = new Shell (display);
		Label label = new Label (shell, SWT.NONE);
		label.setText ("Enter your name:");
		Text text = new Text (shell, SWT.BORDER);
		text.setLayoutData (new RowData (100, SWT.DEFAULT));
		final Label resultLabel = new Label(shell, SWT.BORDER);
		resultLabel.setText("Nothing pressed");
		Button ok = new Button (shell, SWT.PUSH);
		ok.setText ("OK");
		ok.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				resultLabel.setText("OK pressed");
			}
		});
		Button cancel = new Button (shell, SWT.PUSH);
		cancel.setText ("Cancel");
		cancel.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				resultLabel.setText("Cancel pressed");
			}
		});
		shell.setLayout (new RowLayout ());
		shell.pack ();
		shell.open ();
		while (!shell.isDisposed ()) {
			if (!display.readAndDispatch ()) display.sleep ();
		}
		display.dispose ();
		}
}