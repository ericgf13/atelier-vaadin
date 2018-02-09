package ericgf13.ateliervaadin;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import ericgf13.ateliervaadin.view.AtelierView;
import ericgf13.ateliervaadin.view.CorrectionView;

/**
 * This UI is the application entry point. A UI may either represent a browser
 * window (or tab) or some part of a html page where a Vaadin application is
 * embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is
 * intended to be overridden to add component to the user interface and
 * initialize non-component functionality.
 */
@SuppressWarnings("serial")
@Theme("mytheme")
@Title("Atelier Vaadin")
public class MainUI extends UI {

	@Override
	protected void init(VaadinRequest vaadinRequest) {

		// Menu
		final MenuBar menu = new MenuBar();
		final MenuBar.Command menuCommand = selectedItem -> {
			UI.getCurrent().getNavigator().navigateTo(selectedItem.getText());
		};
		menu.addItem("Atelier", menuCommand);
		menu.addItem("Correction", menuCommand);

		// View layout
		final CssLayout viewContainer = new CssLayout();

		// Navigator
		final Navigator navigator = new Navigator(this, viewContainer);
		navigator.addView("", new AtelierView());
		navigator.addView("Atelier", new AtelierView());
		navigator.addView("Correction", new CorrectionView());

		// Global layout
		final VerticalLayout layout = new VerticalLayout(menu, viewContainer);
		layout.setExpandRatio(viewContainer, 1);
		layout.setSizeUndefined(); // Necessary to get scrollbars

		setContent(layout);
	}

	@WebServlet(urlPatterns = "/*", name = "MainUIServlet", asyncSupported = true)
	@VaadinServletConfiguration(ui = MainUI.class, productionMode = false)
	public static class MainUIServlet extends VaadinServlet {
	}
}
