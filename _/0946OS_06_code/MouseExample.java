import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.widgets.*; 
public class MouseExample { 
	public static void main(String[] args) { 
		Display display = new Display(); 
		final Shell s = new Shell(display); 
		s.setSize(500,400); 
		s.setText("MouseEvent"); 
		s.open(); 

		s.addMouseListener(new MouseListener() { 
			public void mouseDown(MouseEvent e) { 
				System.out.println("Position:" + e.x + " " + e.y); 
			} 
			public void mouseUp(MouseEvent e) { 
				System.out.println("Position2:" + e.x + " " + e.y);
			} 
			public void mouseDoubleClick(MouseEvent e) {
				System.out.println("Double click");                                
			} 
		});       
		while(!s.isDisposed( )){ 
			if(!display.readAndDispatch( )) 
				display.sleep( ); 
		} 
		display.dispose( ); 
 
	}
}