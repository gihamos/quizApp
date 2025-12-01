# 📱 QuizApp by Taïse De Thèse NGANGA YABIE

Une application Android de quiz développée dans le cadre d’un projet personnel.  
Elle permet aux utilisateurs de répondre à des questions, consulter leurs résultats et garder un historique des parties.
les données viennent directement sur le site de [jomoreschi](https://quizzapi.jomoreschi.fr/) ou voir [le github de l'api](https://github.com/Eromnoj/quizzAPIv2)


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
<pre>
app/
└── src/
    └── main/
        ├── java/
        │   └── com/example/quizapp/
        |       ├── data/ 
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

</pre>
## 🏗️ Architecture du projet

- **`java/com/example/quizapp/`**
-  - `data/`  Contient les ** fichers pour la creation la base de données,le model et  de l'api**  de l’application : 
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

## 📸 Aperçu
<img width="200" height="300" alt="demarrage" src="https://github.com/user-attachments/assets/c20c2e37-c7b4-49f4-8bbb-9d2eea151735" />

<img width="200" height="300" alt="acceuil" src="https://github.com/user-attachments/assets/764ac91f-26b8-4302-93c4-c822b1c02f52" />

<img width="200" height="300" alt="question" src="https://github.com/user-attachments/assets/9aee9980-0c66-4615-8151-970f1950c3d7" />

<img width="200" height="300" alt="score" src="https://github.com/user-attachments/assets/5dfdd018-8d3c-4826-bbcc-343f975bc324" />

<img width="200" height="300" alt="historique" src="https://github.com/user-attachments/assets/92962a10-ffd5-46b6-b038-5d0d4f0a7f11" />




## 📦 Installation
1. `Pré-requis`: vous d'abord installer [java](https://www.oracle.com/java/technologies/downloads/) et [android studio](https://developer.android.com/studio?hl=fr)

2. Clone le projet :
   ```bash
   git clone https://github.com/gihamos/QuizApp.git
3. Ouvre le projet dans Android Studio
4. Compile et lance sur un émulateur ou un appareil Android


## 👨‍💻 Auteur
Développé par Taïse De Thèse NGANGA YABIE
Projet personnel de développement Android


## 📜 Licence
Ce projet est sous licence MIT – libre d’utilisation et de modification.




