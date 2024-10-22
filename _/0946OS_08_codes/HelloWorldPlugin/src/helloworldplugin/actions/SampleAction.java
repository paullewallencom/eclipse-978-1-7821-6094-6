package helloworldplugin.actions;

import helloworldplugin.IMessageProvider;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;

/**
 * Our sample action implements workbench action delegate.
 * The action proxy will be created by the workbench and
 * shown in the UI. When the user tries to use the action,
 * this delegate will be created and execution will be 
 * delegated to it.
 * @see IWorkbenchWindowActionDelegate
 */
public class SampleAction implements IWorkbenchWindowActionDelegate {
	private IWorkbenchWindow window;
	/**
	 * The constructor.
	 */
	public SampleAction() {
	}

	/**
	 * The action has been activated. The argument of the
	 * method represents the 'real' action sitting
	 * in the workbench UI.
	 * @see IWorkbenchWindowActionDelegate#run
	 */
public void run(IAction action) {

	String helloMessage = null; 
	IExtensionRegistry extensionRegistry = Platform.getExtensionRegistry();
	IConfigurationElement[] elements = extensionRegistry.getConfigurationElementsFor("com.packt.messageProvider");
	try{
		for (IConfigurationElement element : elements) {
			Object object = element.createExecutableExtension("message_provider");
			if (object instanceof IMessageProvider){
				IMessageProvider messageProvider = (IMessageProvider)object;
				helloMessage = messageProvider.getHelloMessage();
			}
		}
	} catch (CoreException e){
		e.printStackTrace();
	}
	
	if(helloMessage == null){
		helloMessage = "No providers found";
	}

	System.out.println(helloMessage);
	MessageDialog.openInformation(
		window.getShell(),
		"HelloWorldPlugin",
		helloMessage);
}

	/**
	 * Selection in the workbench has been changed. We 
	 * can change the state of the 'real' action here
	 * if we want, but this can only happen after 
	 * the delegate has been created.
	 * @see IWorkbenchWindowActionDelegate#selectionChanged
	 */
	public void selectionChanged(IAction action, ISelection selection) {
	}

	/**
	 * We can use this method to dispose of any system
	 * resources we previously allocated.
	 * @see IWorkbenchWindowActionDelegate#dispose
	 */
	public void dispose() {
	}

	/**
	 * We will cache window object in order to
	 * be able to provide parent shell for the message dialog.
	 * @see IWorkbenchWindowActionDelegate#init
	 */
	public void init(IWorkbenchWindow window) {
		this.window = window;
	}
}