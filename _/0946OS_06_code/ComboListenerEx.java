import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*; 
public class ComboListenerEx {    
	public static void main(String[] args) { 
		Display display = new Display(); 
		Shell s = new Shell(display); 

		s.setSize(500,400); 
		s.setText("Combo KeyListener"); 
		s.setLayout(new RowLayout( )); 
		final Combo c = new Combo(s, SWT.DROP_DOWN | SWT.BORDER); 
		c.add("Brazil"); 
		c.add("Argentina"); 
		c.add("Spain"); 

		c.addKeyListener(new KeyListener( ) { 
			String selectedItem = ""; 
			public void keyPressed(KeyEvent e) { 
				if(c.getText( ).length( ) > 0) { 
					return; 
				} 
				String key = Character.toString(e.character); 
				String[] items = c.getItems( ); 
				for(int i =0;i<items.length;i++) { 
					if(items[i].toLowerCase( ).startsWith(key.toLowerCase( ))) { 
						c.select(i); 
						selectedItem = items[i]; 
						return; 
					} 
				} 
			} 
			public void keyReleased(KeyEvent e) { 
				if(selectedItem.length( ) > 0) 
					c.setText(selectedItem); 
				selectedItem = ""; 
			} 
		});        
		s.open( ); 
		while(!s.isDisposed( )) { 
			if(!display.readAndDispatch( )) 
				display.sleep( ); 
		} 
		display.dispose( ); 
	}
}