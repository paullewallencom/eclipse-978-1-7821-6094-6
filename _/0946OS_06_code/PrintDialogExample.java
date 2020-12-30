import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.printing.PrintDialog;
import org.eclipse.swt.printing.Printer;
import org.eclipse.swt.printing.PrinterData;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;


public class PrintDialogExample { 
	public static void main(String[] args) { 
		Display display = new Display(); 
		Shell shell = new Shell(display); 

		shell.setSize(500,400); 
		shell.setLayout(new FillLayout( )); 
		
		PrintDialog printDialog = new PrintDialog(shell, SWT.NONE); 
		printDialog.setText("Print"); 
		PrinterData printerData = printDialog.open(); 
		Printer p = new Printer(printerData); 
		p.startJob("PrintJob");    
		p.startPage(); 
		Rectangle trim = p.computeTrim(0, 0, 0, 0);
		Point dpi = p.getDPI();
		int leftMargin = dpi.x + trim.x;
		int topMargin = dpi.y / 2 + trim.y;
		GC gc = new GC(p);
		Font font = gc.getFont();
		String printText = "printExample";
		
		gc.drawString(printText, leftMargin, topMargin + font.getFontData()[0].getHeight());
		p.endPage(); 
		p.endJob(); 
		p.dispose();
		shell.open( ); 
		while(!shell.isDisposed()){ 
			if(!display.readAndDispatch( )) 
				display.sleep( ); 
		} 
		display.dispose();
	}
}