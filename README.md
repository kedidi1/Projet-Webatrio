# webatrio
 
Application web 
Cette partie est pratique.
L'objectif est ici de livrer une application comprenant quelques fonctionnalités basiques, afin de pouvoir effectuer une démonstration de son fonctionnement.  L’idée est d’utiliser un framework avec un ORM.
Choisissez une architecture API REST, pas besoin de réaliser le front, exposer les endpoints (qui pourront être appelables avec Postman) suffira.
----------------------------------------------------------------------------------------------------------------------------


1)  L'application permet de gérer des "Personnes" (nom, prénom, date de naissance) et leurs "Emplois" (nom de l'entreprise, poste occupé).

2) Créez les endpoints qui:
Sauvegardent une nouvelle personne. Attention, seules les personnes de moins de 150 ans peuvent être enregistrées. Sinon, renvoyez une erreur.
Permettent d'ajouter un emploi à une personne avec une date de début et de fin d'emploi. Pour le poste actuellement occupé, la date de fin n'est pas obligatoire. Une personne peut avoir plusieurs emplois aux dates qui se chevauchent.
Renvoient toutes les personnes enregistrées par ordre alphabétique, et indiquent également leur âge et leur(s) emploi(s) actuel(s).
Renvoient toutes les personnes ayant travaillé pour une entreprise donnée.
Renvoient tous les emplois d'une personne entre deux plages de dates.


3) Créez une structure d'application et une base de données répondant aux besoins énoncés ci-dessus

4) Générez une API DOC.
