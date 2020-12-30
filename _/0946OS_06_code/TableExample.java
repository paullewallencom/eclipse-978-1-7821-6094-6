import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.*; 
public class TableExample { 
	public static void main(String[] args) { 
        Display display = new Display(); 
        Shell shell = new Shell(display); 
        
        shell.setSize(500,400); 
        shell.setText("Table Example"); 
        shell.setLayout(new FillLayout( )); 
        
        Table table = new Table(shell, SWT.BORDER); 
        TableColumn tc1 = new TableColumn(table, SWT.CENTER); 
        TableColumn tc2 = new TableColumn(table, SWT.CENTER); 
        TableColumn tc3 = new TableColumn(table, SWT.CENTER); 
        tc1.setText("Name"); 
        tc2.setText("Age"); 
        tc3.setText("Country"); 
        tc1.setWidth(80); 
        tc2.setWidth(40); 
        tc3.setWidth(80); 
        table.setHeaderVisible(true); 
        TableItem item1 = new TableItem(table,SWT.NONE); 
        item1.setText(new String[] {"Rodrigo","28","France"}); 
        TableItem item2 = new TableItem(table,SWT.NONE); 
        item2.setText(new String[] {"Vinicius","28","USA"}); 
        TableItem item3 = new TableItem(table,SWT.NONE); 
        item3.setText(new String[] {"Rafael","28","Brazil"}); 
        shell.open( ); 
        while(!shell.isDisposed()){ 
            if(!display.readAndDispatch( )) 
                display.sleep( ); 
        } 
        display.dispose();
	}
}