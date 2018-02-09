package ericgf13.ateliervaadin.view;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.navigator.View;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

import ericgf13.ateliervaadin.bean.Person;
import ericgf13.ateliervaadin.form.PersonForm;

@SuppressWarnings("serial")
public class CorrectionView extends HorizontalLayout implements View {

	public CorrectionView() {

		// Fields
//		TextField nameField = new TextField("Nom");
//		TextField countryField = new TextField("Pays");
//		DateField birthDateField = new DateField("Date de naissance");
		PersonForm personForm = new PersonForm();

		// Grid
		Grid<Person> grid = new Grid<>();
		grid.addColumn(Person::getName).setCaption("Nom");
		grid.addColumn(Person::getCountry).setCaption("Pays");
		grid.addColumn(Person::getBirthDate).setCaption("Date de naissance");
		grid.asSingleSelect().addValueChangeListener(event -> {
			personForm.setPerson(event.getValue());
		});

		List<Person> personList = new ArrayList<>();
		grid.setItems(personList);

		// Button
		Button button = new Button("Créer");
		button.setClickShortcut(KeyCode.ENTER);
		button.setStyleName(ValoTheme.BUTTON_PRIMARY);
//		button.setStyleName("blue"); .v-button-blue
		button.addClickListener(event -> {
			
//			if (nameField.isEmpty() || countryField.isEmpty() || birthDateField.isEmpty()) {
//				Notification.show("Tous les champs doivent être remplis !", Notification.Type.ERROR_MESSAGE);
//			} else {
//				personList.add(new Person(nameField.getValue(), countryField.getValue(), birthDateField.getValue()));
//				grid.getDataProvider().refreshAll();
//				Notification.show("Personne créée !", Notification.Type.TRAY_NOTIFICATION);
//			}
			
			Person newPerson = personForm.createPerson();
			if (newPerson != null) {
				if (!personList.contains(newPerson)) {
					personList.add(newPerson);
				}
				grid.asSingleSelect().clear();
				grid.getDataProvider().refreshAll();
				Notification.show("Personne créée !", Notification.Type.TRAY_NOTIFICATION);
				personForm.initPerson();
			}
		});

//		VerticalLayout formLayout = new VerticalLayout(nameField, countryField, birthDateField, button);
		VerticalLayout formLayout = new VerticalLayout(personForm, button);
		formLayout.setComponentAlignment(button, Alignment.MIDDLE_CENTER);
		VerticalLayout gridLayout = new VerticalLayout(grid);

		// Main layout
		HorizontalLayout panelLayout = new HorizontalLayout(formLayout, gridLayout);

		// Main panel
		Panel mainPanel = new Panel("Personnes", panelLayout);

		addComponent(mainPanel);
	}
}
