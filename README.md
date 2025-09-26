🛍️ ENI Shop

Application Android développée en Kotlin avec Jetpack Compose permettant de gérer et afficher une liste d’articles (style mini e-commerce).
L’application inclut un système de filtres par catégories et une gestion simple des favoris.


---

🚀 Fonctionnalités

📋 Affichage d’une liste d’articles (nom, image, prix, catégorie, description).

🔍 Filtrage par catégories via des FilterChips dynamiques.

❤️ Sélection des favoris (checkbox graphique).

🖼️ Chargement des images depuis Internet avec Coil.

🧩 Architecture basée sur MVVM : ViewModel + Repository.

🎨 UI moderne grâce à Jetpack Compose Material 3.



---

🖥️ Captures d’écran

<img width="317" height="632" alt="image" src="https://github.com/user-attachments/assets/67477b8b-f153-4313-be21-028d4abd3e1a" />

<img width="315" height="630" alt="image" src="https://github.com/user-attachments/assets/68e73c06-d766-4a32-b085-7b0871860857" />


<img width="317" height="640" alt="image" src="https://github.com/user-attachments/assets/daf3c4a1-2f9f-40b2-b420-bd09eb6259b0" />




---

🛠️ Technologies utilisées

Kotlin

Jetpack Compose

Material 3

Coil (chargement d’images)

ViewModel + StateFlow

[Scaffold / LazyVerticalGrid / LazyRow] pour la structure UI



---

📂 Structure du projet

com.example.eni_shop
│
├── data/
│ ├── Article.kt
│ └── ArticleRepository.kt
│
├── viewmodel/
│ └── ArticleViewModel.kt
│
├── ui/
│ ├── theme/ (déjà généré par Compose)
│ ├── page/
│ │ ├── ArticlePage.kt
│ │ ├── ArticleDetailPage.kt
│ │ ├── ArticleFormPage.kt
│ │ └── CategoryFilterChip.kt
│ └── components/
│ ├── ArticleCard.kt
│ └── TopBar.kt
│
└── MainActivity.kt
