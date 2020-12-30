package contactslist.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.PlatformUI;

import contactslist.model.Contact;
import contactslist.views.ContactListView;

public class NewContactHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Contact contact = new Contact("New Contact", "", "");
		IViewPart view = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView("ContactsList.ContactsListView");
		((ContactListView) view).addEntry(contact);
		return null;
	}
}
