
### Service Diplôme – CI/CD Pipeline (Jenkins + Docker)

Ce projet est une application backend Spring Boot permettant la gestion des diplômes.
L’objectif principal de ce travail est la mise en place d’une chaîne CI/CD complète à l’aide de Jenkins, Maven et Docker.

Le pipeline automatise :

le build du projet
les tests
la génération du package
la création d’une image Docker
le push vers Docker Hub

### Technologies utilisées
Java 17
Spring Boot
Maven
Docker
Jenkins (CI/CD)
GitHub (SCM)

### Architecture CI/CD

Le pipeline est structuré comme suit :

Récupération du code depuis GitHub
Compilation avec Maven
Exécution des tests
Packaging de l’application
Build de l’image Docker
Authentification Docker Hub
Push de l’image Docker

### Pipeline Jenkins

Le pipeline est défini dans le fichier Jenkinsfile à la racine du projet.

Exemple de fonctionnement :
Build automatique à chaque commit
Exécution des tests unitaires
Génération de l’image Docker
Publication sur Docker Hub

### Pipeline réussi

<img width="1918" height="774" alt="image" src="https://github.com/user-attachments/assets/81ffff7e-98ad-4d7a-a725-789aa38a7d06" />

<img width="1915" height="924" alt="image" src="https://github.com/user-attachments/assets/8c7f8088-8eea-44f2-94a8-e9a57169aed7" />

### Docker Image

<img width="1052" height="199" alt="image" src="https://github.com/user-attachments/assets/d1072a57-7583-4186-9c8c-89209634afe4" />


