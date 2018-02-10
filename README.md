Présentation du framework Vaadin avec une application très simple.

Installation
==============

Compiler le projet : `mvn install`  
Démarrer l'application : `mvn jetty:run`  
Ouvrir http://localhost:8080/  

Atelier
==============

 **1. Formulaire**

Créer 3 champs "Nom", "Pays", "Date de naissance" et un bouton "Créer".  
*Utiliser le composant `DateField` pour un champ de type date.*  
*La méthode `addComponent()` permet d'ajouter des composants à un layout (`AtelierView` est un layout !).*  
*Avancé : Utilisation d'un `FormLayout` (classe `PersonForm` dans le projet).*  

 **2. Création d'une personne**

Au clic sur le bouton, insérer un objet `Person` dans une liste si tous les champs sont remplis. Afficher une notification selon le succès ou l'échec de l'ajout.  
*Le bean `Person` existe déjà dans le projet.*  

 **3. Table**

Créer une table permettant d'afficher les personnes présentes dans la liste.  
*Utiliser le composant `Grid<Person>`.*  
*Utiliser la méthode `getDataProvider().refreshAll()` sur le grid afin de rafraichir la liste.*  
Aide : https://vaadin.com/docs/framework/v8/components/components-grid.html  

 **4. Layout**

Disposer la table sur la droite du formulaire et intégrer le tout dans un panel.  

 **5. Style**

 - Modifier la taille de la police de l'application.  
*Editer la feuille de style `mytheme.scss`*  

 - Modifier la couleur du bouton et lui assigner le raccourci de la touche entrée.  
*Utiliser la méthode `setStyleName()`*  

 - Centrer le bouton par rapport au formulaire.  
*L'aligment se fait au niveau du layout*  

 **6. Bonus**

Permettre l'édition d'une personne via le formulaire lors de la sélection dans la table.  
