Le but est de compléter en 1H le code en respectant les consignes suivantes :
- Utiliser uniquement gemini CLI ou Code Assist en mode "Agent"
- Garder le code simple et lisible
- Ne pas ajouter de fonctionnalités non demandées
- Ne pas supprimer de code existant


Remarques globales :
- L'intégralité du code doit être documenté à la fois en Englais et en Français, avec des commentaires clairs expliquant la logique et les étapes de l'implémentation. Les commentaires doivent être placés au-dessus des sections de code correspondantes pour une meilleure lisibilité.
- On utilisera Spring MVC pour la partie web. Les controlleurs retourneront des objets Java qui seront automatiquement convertis en JSON grâce à l'annotation @RestController de Spring.
- Faire l'ensemble des tests unitaires


Etapes pour l'implémentation :
# 1
- Générer un fichier csv de 50 lignes representant une liste de clients avec les champs suivants : id, nom, prenom, email, date_inscription
- Utiliser des données fictives pour remplir les champs
- Le fichier csv doit être nommé "clients.csv" et être enregistré dans le répertoire "src/main/resources/data"


# 2
- Lire ce fichier csv au démarrage de l'application
- Parser le contenu du fichier et stocker les données dans une liste d'objets Client en mémoire (pas de base de données pour cet exercice)
- Afficher la liste des clients dans la console au démarrage de l'application


# 3
- Cette application doit exposer les endpoints suivants :
  - GET /clients : retourne la liste de tous les clients
  - GET /clients/{id} : retourne les détails d'un client spécifique en fonction de son id
  - POST /clients : permet d'ajouter un nouveau client à la liste (les données du client seront envoyées dans le corps de la requête au format JSON)
- Générer l'ensemble des tests d'intégration pour ces endpoints en utilisant JUnit et MockMvc (En utilisant Spring)


# 4
- On aura également un endpoint qui retourne un PDF:
  - GET /clients/pdf : génère un PDF contenant la liste de tous les clients et le retourne en réponse. Le PDF doit être formaté de manière lisible, avec une table contenant les informations des clients (id, nom, prenom, email, date_inscription).
  - Utiliser la librairie PDFBox pour générer le PDF


# 5
- Ajouter une fonctionnalité de recherche de clients par nom ou prénom :
  - GET /clients/search?query={query} : retourne une liste de clients dont le nom ou le prénom correspond à la query de recherche (la recherche doit être insensible à la casse). On doit pouvr rechercher par nom ou par prénom, ou les deux en même temps. Par exemple, une recherche pour "Jean" doit retourner tous les clients dont le nom ou le prénom contient "Jean" (ex: Jean Dupont, Marie Jeanne, etc.)


  # 6
- Générer le schema d'architectural de l'application en utilisant un outil de modélisation UML (comme PlantUML ou Mermaid). Le schéma doit inclure les différentes classes, leurs relations, ainsi que les endpoints exposés par l'application. Le schéma doit être clair et facile à comprendre pour un développeur qui n'est pas familier avec le projet.
- Générer la documentation fonctionnelle de l'application au format Markdown, en expliquant les différentes fonctionnalités de l'application, les endpoints disponibles, ainsi que les étapes pour démarrer et utiliser l'application. La documentation doit être claire et concise, et doit inclure des exemples d'utilisation pour chaque endpoint.
