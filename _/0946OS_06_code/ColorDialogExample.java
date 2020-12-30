import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.ColorDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;


public class ColorDialogExample { 
	public static void main(String[] args) { 
		Display display = new Display(); 
		Shell shell = new Shell(display); 

		shell.setSize(500,400); 
		shell.setLayout(new FillLayout( )); 


		Text text = new Text(shell, SWT.CENTER | SWT.BORDER);
		text.setSize(200,25);
		ColorDialog cd = new ColorDialog(shell); 
		cd.setText("ColorDialog"); 
		cd.setRGB(new RGB(255,255,255)); 
		RGB newColor = cd.open( ); 
		text.setBackground(new Color(display, newColor));

		shell.open( ); 
		while(!shell.isDisposed()){ 
			if(!display.readAndDispatch( )) 
				display.sleep( ); 
		} 
		display.dispose();
	}
}