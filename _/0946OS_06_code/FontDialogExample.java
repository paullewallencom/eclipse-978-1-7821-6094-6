import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FontDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;


public class FontDialogExample { 
	public static void main(String[] args) { 
		Display display = new Display(); 
		Shell shell = new Shell(display); 

		shell.setSize(500,400); 
		shell.setLayout(new FillLayout( )); 
		Text text = new Text(shell, SWT.CENTER | SWT.BORDER);


		FontDialog fd = new FontDialog(shell, SWT.NONE); 
		fd.setText("Font Selection"); 
		fd.setRGB(new RGB(0,0,255)); 
		FontData defaultFont = new FontData("Verdana",10,SWT.BOLD); 
		fd.setFontData(defaultFont);     
		FontData newFont = fd.open( ); 
		text.setFont(new Font(display, newFont)); 
		text.setForeground(new Color(display, fd.getRGB()));

		shell.open( ); 
		while(!shell.isDisposed()){ 
			if(!display.readAndDispatch( )) 
				display.sleep( ); 
		} 
		display.dispose();
	}
}