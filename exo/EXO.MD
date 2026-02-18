# Objectif

Le but est de compléter en **1 h** le code en respectant les consignes suivantes :

- Utiliser uniquement **Gemini CLI** ou **Code Assist** en mode "Agent".
- Garder le code simple et lisible.
- Ne pas ajouter de fonctionnalités non demandées.
- Ne pas supprimer de code existant.

---

# Remarques globales

- L’intégralité du code doit être documentée à la fois en **anglais** et en **français**, avec des commentaires clairs expliquant la logique et les étapes de l’implémentation.  
  Les commentaires doivent être placés au-dessus des sections de code correspondantes pour une meilleure lisibilité.
- On utilisera **Spring MVC** pour la partie web.  
  Les contrôleurs retourneront des objets Java qui seront automatiquement convertis en JSON grâce à l’annotation `@RestController` de Spring.
- Réaliser l’ensemble des tests unitaires.

---

# Étapes pour l’implémentation

## 1. Génération du fichier CSV

- Générer un fichier CSV de 50 lignes représentant une liste de clients avec les champs suivants :
  - `id`
  - `nom`
  - `prenom`
  - `email`
  - `date_inscription`
- Utiliser des données fictives pour remplir les champs.
- Le fichier CSV doit être nommé **`clients.csv`** et être enregistré dans le répertoire : `src/main/resources/data`


---

## 2. Chargement des données au démarrage

- Lire ce fichier CSV au démarrage de l’application.
- Parser le contenu du fichier et stocker les données dans une liste d’objets `Client` en mémoire  
  (pas de base de données pour cet exercice).
- Afficher la liste des clients dans la console au démarrage de l’application.

---

## 3. Exposition des endpoints REST

L’application doit exposer les endpoints suivants :

- `GET /clients`  
  → Retourne la liste de tous les clients.

- `GET /clients/{id}`  
  → Retourne les détails d’un client spécifique en fonction de son `id`.

- `POST /clients`  
  → Permet d’ajouter un nouveau client à la liste.  
  Les données du client seront envoyées dans le corps de la requête au format JSON.

- Générer l’ensemble des tests d’intégration pour ces endpoints en utilisant **JUnit** et **MockMvc** (avec Spring).

---

## 4. Génération d’un PDF

Ajouter un endpoint :

- `GET /clients/pdf`  
  → Génère un PDF contenant la liste de tous les clients et le retourne en réponse.

Contraintes :

- Le PDF doit être formaté de manière lisible.
- Il doit contenir une table avec les colonnes :
  - `id`
  - `nom`
  - `prenom`
  - `email`
  - `date_inscription`
- Utiliser la librairie **PDFBox** pour générer le PDF.

---

## 5. Recherche de clients

Ajouter une fonctionnalité de recherche :

- `GET /clients/search?query={query}`  

Ce endpoint :

- Retourne une liste de clients dont le nom ou le prénom correspond à la requête.
- La recherche doit être **insensible à la casse**.
- Il doit être possible de rechercher par :
  - nom
  - prénom
  - ou les deux en même temps

Exemple :

Une recherche pour `"Jean"` doit retourner :
- Jean Dupont
- Marie Jeanne
- etc.

---

## 6. Architecture et documentation

### Schéma UML

- Générer le schéma architectural de l’application en utilisant un outil de modélisation UML  
  (comme **PlantUML** ou **Mermaid**).
- Le schéma doit inclure :
  - Les différentes classes
  - Leurs relations
  - Les endpoints exposés
- Le schéma doit être clair et compréhensible pour un développeur non familier avec le projet.

### Documentation fonctionnelle

- Générer la documentation fonctionnelle au format **Markdown**.
- Expliquer :
  - Les fonctionnalités de l’application
  - Les endpoints disponibles
  - Les étapes pour démarrer et utiliser l’application
- Inclure des exemples d’utilisation pour chaque endpoint.
