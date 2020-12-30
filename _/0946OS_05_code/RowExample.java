import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*; 
public class RowExample { 
	public static void main(String[] args) { 
		Display display = new Display();
		Shell shell = new Shell(display);
		RowLayout layout = new RowLayout(SWT.HORIZONTAL);
		layout.wrap = true;
		layout.fill = false;
		layout.justify = true;
		shell.setLayout(layout);

		Button b = new Button(shell, SWT.PUSH);
		b.setText("Button 1");

		b = new Button(shell, SWT.PUSH);
		b.setText("Button 2");

		RowData data = new RowData();
		b.setLayoutData(data);

		b = new Button(shell, SWT.PUSH);
		b.setText("150 vertical");
		data = new RowData();
		data.height = 150;
		b.setLayoutData(data);

		b = new Button(shell, SWT.PUSH);
		b.setText("150 horizontal");
		data = new RowData();
		data.width = 150;
		b.setLayoutData(data);

		shell.pack();
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}
}