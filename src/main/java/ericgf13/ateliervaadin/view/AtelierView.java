package ericgf13.ateliervaadin.view;

import com.vaadin.navigator.View;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class AtelierView extends VerticalLayout implements View {

	public AtelierView() {
		Label label = new Label("Bienvenue à l'atelier Vaadin !");
		addComponent(label);
	}
}
