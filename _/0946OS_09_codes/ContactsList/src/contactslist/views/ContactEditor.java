package contactslist.views;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPartConstants;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.EditorPart;

import contactslist.model.Contact;

public class ContactEditor extends EditorPart {
	
	private boolean dirty = false;
	private Text addressText;
	private Text nameText;
	private Text phoneText;
	private IViewPart contactsView;
	
	@Override
	public void init(IEditorSite site, IEditorInput input)
			throws PartInitException {
		setSite(site);
		setInput(input);
	}
	
	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new GridLayout(2, false));
		Label nameLabel = new Label(parent, SWT.NONE);
		nameLabel.setText("Name");
		nameLabel.setLayoutData(new GridData());
		nameText = new Text(parent, SWT.BORDER | SWT.FILL);
		nameText.setLayoutData(new GridData());
		
		Label addressLabel = new Label(parent, SWT.NONE);
		addressLabel.setText("Address");
		addressLabel.setLayoutData(new GridData());
		addressText = new Text(parent, SWT.BORDER);
		addressText.setLayoutData(new GridData());
		
		Label phoneLabel = new Label(parent, SWT.NONE);
		phoneLabel.setText("Phone number");
		phoneLabel.setLayoutData(new GridData());
		phoneText = new Text(parent, SWT.BORDER );
		phoneText.setLayoutData(new GridData());
		
		ContactEditorInput editorInput = (ContactEditorInput)getEditorInput();
		if(editorInput != null){
			Contact contact = editorInput.getContact();
			nameText.setText(contact.getName());
			this.setPartName(contact.getName());
			addressText.setText(contact.getAddress());
			phoneText.setText(contact.getPhoneNumber());
		}
		
		nameText.addModifyListener(new ContactEditorModifyListener());
		addressText.addModifyListener(new ContactEditorModifyListener());
		phoneText.addModifyListener(new ContactEditorModifyListener());
		
		contactsView = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView("ContactsList.ContactsListView");
	}
	
	@Override
	public void doSave(IProgressMonitor monitor) {
		dirty = false;
		firePropertyChange(IWorkbenchPartConstants.PROP_DIRTY);
		
		ContactEditorInput editorInput = (ContactEditorInput)getEditorInput();
		if(editorInput != null){
			Contact contact = editorInput.getContact();
			contact.setName(nameText.getText());
			contact.setAddress(addressText.getText());
			contact.setPhoneNumber(phoneText.getText());

			this.setPartName(contact.getName());
			if(contactsView != null){
				if (contactsView instanceof IPropertyChangeListener){
					PropertyChangeEvent changeDirty = new PropertyChangeEvent(this, "isDirty", true, false);
					((IPropertyChangeListener)contactsView).propertyChange(changeDirty);
				}
			}
			
		}
	}

	@Override
	public boolean isDirty() {
		return dirty;
	}
	
	@Override
	public void doSaveAs() {
	}

	@Override
	public boolean isSaveAsAllowed() {
		return false;
	}

	@Override
	public void setFocus() {
	}
	
	private class ContactEditorModifyListener implements ModifyListener {
		@Override
		public void modifyText(ModifyEvent e) {
			dirty = true;
			firePropertyChange(IWorkbenchPartConstants.PROP_DIRTY);
		}
	}
}
