# Promotion-Marjane

Gestion des Promotions Marjane

## Contexte du projet

L’hypermarché Marjane Maroc souhaite simplifier la gestion des promotions de ses produits au niveau de tous les centres du royaume. Pour se faire l’admin général du groupe Marjane va prendre en charge la gestion de chaque admin du centre par ville, cette dernière peut avoir 1 ou plusieurs centre et chaque centre est géré par un seul Admin. La gestion de promotion est gérée chaque jour au niveau du centre, à partir de son interface l’admin (déjà crée par l’admin général email et mot de passe provisoir envoyé par email) crée une liste des promotions par catégorie des produits, par exemple dans la catégorie multimédia on va ajouter une promotion des pc portable qui va être de 10% avec 100dhs gagné sur la carte fidélité Par la suite un responsable de rayon(crée par l’admin, email et mot de passe provisoire envoyé par email) multimédia se connecte à son interface pour consulter sa liste des promotions pour accepter ou refuser selon la quantité du stock disponible dans le centre, si par exemple la quantité du stock des pc portable est de 80 unités, il va accepter la promotion en ajoutant un commentaire qui détermine la quantité des produits disponible.
L’admin du Marjane consulte par la suite toutes les promotions appliquées et non appliquées à son centre.
Pour une meilleure gestion des promotions Marjane exige que toutes les promotions soient consultables par les responsable des rayon seulement entre 8h-12h00 du matin, si un responsable de rayon se connecte hors cet intervalle les promotions seront indisponible et si le responsable du rayon ne fait aucune action la promotion sera non traitée est affichée chez l’admin.

### Une Règle générale s’applique à toutes les promotions du Groupe Marjane Maroc :

- Chaque promotion ne doit pas dépasser 50% du prix du produit
- Chaque 5% de réduction vaut 50dhs de points de fidélité gagnés
- La promotion des produits multimédia ne doit pas dépasser 20% Chaque opération faite dans le système est enregistrée dans fichier de journalisation et dans la base  de données l'Admin général du groupe marjane souhaite visualiser les statistiques des promotions appliquées et non apliquées sur son interface Chaque Promotion est valable selon la quantité du stock disponible et consultable une fois entre 8h-12h , si par exemple un Admin lance une application à 8h00, elle sera vue seulement par le responsable du rayon de 8hà 12h s'il n'a pas traité sera non appliqué dans le système

> NB : Chaque promotion une durée de validité modifiée par l'admin du centre marjane

### Travail demandé par Marjane :

-Réaliser la partie Backend en JAVA/JPA/Hibernate(utilisation des lambda expression + streams)
-Ajouter les tests unitaires nécessaires
-Ajouter une base de données PostgreSQL adéquate au système
-Organiser votre projet avec un outil de votre choix

### Compétences visées
- Créer une base de données.
- Développer des composants d’accès aux données.
- Développer la partie back-end d’une interface utilisateur web.
- Planifier le travail à effectuer individuellement et en équipe afin d’optimiser le travail nécessaire à l’atteinte de l’objectif visé.


