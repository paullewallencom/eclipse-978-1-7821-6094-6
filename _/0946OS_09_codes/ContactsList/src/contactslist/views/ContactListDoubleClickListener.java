package contactslist.views;

import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import contactslist.model.Contact;

public class ContactListDoubleClickListener implements IDoubleClickListener {

	@Override
	public void doubleClick(DoubleClickEvent event) {
		TableViewer viewer = (TableViewer) event.getSource();
		StructuredSelection selection = (StructuredSelection) viewer.getSelection();
		Contact contact = (Contact) selection.getFirstElement();
		try {
			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().openEditor(new ContactEditorInput(contact), "ContactsList.ContactEditor");
		} catch (PartInitException e) {
			e.printStackTrace();
		}
	}
}
