# 📱 QuizApp by Taïse De Thèse NGANGA YABIE

Une application Android de quiz développée dans le cadre d’un projet personnel.  
Elle permet aux utilisateurs de répondre à des questions, consulter leurs résultats et garder un historique des parties.
les données viennent directement sur `https://quizzapi.jomoreschi.fr/`


## 🚀 Fonctionnalités

- 🎬 **Écran de démarrage animé (Splash Screen)** avec ton nom et une animation moderne  
- 👤 **ProfileActivity** : gestion du profil utilisateur  
- 📝 **MainActivity** : quiz interactif avec questions/réponses  
- 🏆 **ResultActivity** : affichage des scores et résultats  
- 📜 **HistoryActivity** : historique des parties jouées  
- 🎨 **Mode clair/sombre** avec Material3  
- 🖼️ **Icône personnalisée** pour l’application  


## 🛠️ Technologies utilisées

- **Langage** : Kotlin  
- **Framework** : Android SDK  
- **UI** : Material Design 3  
- **Architecture** : Activities + Layouts XML  
- **Animations** : XML (fade, slide, zoom)  
- **Gestion des thèmes** : `themes.xml` (clair/sombre)  



## 📂 Structure du projet
```
app/
└── src/
    └── main/
        ├── java/
        │   └── com/example/quizapp/
        │       ├── SplashActivity.kt
        │       ├── ProfileActivity.kt
        │       ├── MainActivity.kt
        │       ├── ResultActivity.kt
        │       └── HistoryActivity.kt
        │
        ├── res/
        │   ├── layout/
        │   │   ├── activity_splash.xml
        │   │   ├── activity_profile.xml
        │   │   ├── activity_main.xml
        │   │   ├── activity_result.xml
        │   │   └── activity_history.xml
        │   │
        │   ├── anim/
        │   │   ├── zoom_in_fade.xml
        │   │   ├── fade_in.xml
        │   │   ├── fade_out.xml
        │   │   ├── slide_in_right.xml
        │   │   └── slide_out_left.xml
        │   │
        │   └── values/
        │       ├── themes.xml
        │       └── strings.xml
        │
        └── AndroidManifest.xml

```
## 🏗️ Architecture du projet

- **`java/com/example/quizapp/`**  
  Contient les **Activities** principales de l’application :  
  - `SplashActivity.kt` → écran de démarrage animé  
  - `ProfileActivity.kt` → gestion du profil utilisateur  
  - `MainActivity.kt` → logique du quiz (questions/réponses)  
  - `ResultActivity.kt` → affichage des résultats et scores  
  - `HistoryActivity.kt` → historique des parties jouées  

- **`res/layout/`**  
  Fichiers XML définissant l’interface utilisateur (UI) pour chaque écran.  

- **`res/anim/`**  
  Animations XML utilisées pour les transitions (fade, slide, zoom).  

- **`res/values/`**  
  - `themes.xml` → gestion du thème clair/sombre  
  - `strings.xml` → textes et ressources multilingues  

- **`AndroidManifest.xml`**  
  Déclare les activités, permissions et configuration globale de l’application.  


## 📦 Installation

1. Clone le projet :
   ```bash
   git clone https://github.com/gihamos/QuizApp.git
2. Ouvre le projet dans Android Studio
3. Compile et lance sur un émulateur ou un appareil Android


## 👨‍💻 Auteur
Développé par Taïse De Thèse NGANGA YABIE
Projet personnel de développement Android


## 📜 Licence
Ce projet est sous licence MIT – libre d’utilisation et de modification.




