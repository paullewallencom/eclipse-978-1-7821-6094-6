package contactslist.views;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.ViewPart;

import contactslist.model.Contact;

public class ContactListView extends ViewPart implements IPropertyChangeListener {

	private TableViewer contactsViewer;
	private List<Contact> contacts;

	@Override
	public void createPartControl(Composite parent) {
		contactsViewer = new TableViewer(parent);
		contactsViewer.setContentProvider(new ArrayContentProvider());
		contactsViewer.setLabelProvider(new ContactLabelProvider());
		contacts = new ArrayList<Contact>();
		contactsViewer.setInput(contacts);
		contactsViewer
				.addDoubleClickListener(new ContactListDoubleClickListener());

	}

	@Override
	public void setFocus() {

	}

	public void addEntry(Contact contact) {
		contacts.add(contact);
		contactsViewer.refresh(true);

	}

	public void refreshEntries() {
		contactsViewer.refresh(true);
	}

	@Override
	public void init(IViewSite site) throws PartInitException {
		super.init(site);
	}

	@Override
	public void propertyChange(PropertyChangeEvent event) {
		refreshEntries();
	}
	
	

}
