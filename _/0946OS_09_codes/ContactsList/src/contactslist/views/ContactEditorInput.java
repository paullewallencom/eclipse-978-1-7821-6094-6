package contactslist.views;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPersistableElement;

import contactslist.model.Contact;

public class ContactEditorInput implements IEditorInput {
	
	private Contact contact;

	public ContactEditorInput(Contact contact) {
		super();
		this.contact = contact;
	}
	
	public Contact getContact(){
		return contact;
	}
	
	@Override
	public String getToolTipText() {
		return contact.getName();
	}
	
	@Override
	public String getName() {
		return contact.getName();
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof ContactEditorInput){
			if(((ContactEditorInput)obj).getContact().equals(this.contact)){
				return true;
			}
		}
		return false;
	}
	
	@Override
	public Object getAdapter(@SuppressWarnings("rawtypes") Class adapter) {
		return null;
	}

	@Override
	public boolean exists() {
		return false;
	}

	@Override
	public ImageDescriptor getImageDescriptor() {
		return null;
	}

	@Override
	public IPersistableElement getPersistable() {
		return null;
	}
}
