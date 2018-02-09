package ericgf13.ateliervaadin.form;

import java.time.LocalDate;

import com.vaadin.data.Binder;
import com.vaadin.ui.DateField;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.TextField;

import ericgf13.ateliervaadin.bean.Person;

@SuppressWarnings("serial")
public class PersonForm extends FormLayout {

	private TextField nameField = new TextField("Nom");
	private TextField countryField = new TextField("Pays");
	private DateField birthDateField = new DateField("Date de naissance");

	private Binder<Person> binder = new Binder<>(Person.class);

	public PersonForm() {
		binder.forField(nameField).asRequired("Le nom doit être renseigné").bind(Person::getName, Person::setName);
		binder.forField(countryField).asRequired("Le pays doit être renseigné").bind(Person::getCountry,
				Person::setCountry);
		binder.forField(birthDateField).asRequired("La date de naissance doit être renseignée")
				.withValidator(value -> value.isBefore(LocalDate.now()), "La date de naissance doit être dans le passé")
				.bind(Person::getBirthDate, Person::setBirthDate);

		initPerson();

		addComponents(nameField, countryField, birthDateField);
	}

	public void initPerson() {
		binder.setBean(new Person());
	}

	public void setPerson(Person person) {
		binder.setBean(person);
	}

	public Person createPerson() {
		if (binder.validate().isOk()) {
			return binder.getBean();
		}
		return null;
	}
}
