	Page de présentation
	Dédicaces
	Remerciements

	Table des matières
Introduction
Chapitre I : organisation et analyse du projet
I.1 présentation rapide (préambule)
I.2 définitions (IA, interface...)
I.3 ressources humaines (fréquence de travail, répartition des tâches)
I.4 ressources logiciels (pour le projet, écriture du code, écriture du rapport)
Chapitre II : création du jeu
II.1 notes sur "The Battle of Polytopia"
II.2 structure du moteur de jeu
II.3 choix de l'interface de jeu
II.4 choix d'enregistrement des données
II.5 application
Chapitre III : création du cerveau de l'IA
III.1 étude préliminaire des stratégies de jeu
III.2 établissement des hypothèses
III.3 structure de l'IA
III.4 choix d'enregistrement des données
III.5 application
Chapitre IV : Entraînement et analyse
IV.1 choix de la méthode d'entrainement de l'IA
IV.2 plannification et lancement de l'entrainement
IV.3 analyse des données
Conclusion
Références (Rapport - L1ST - APOO - Projet TP 2023)

	Introduction
Ce rapport présente le travail réalisé dans le cadre d'un projet personnel. Celui-ci donnera l'occasion de manipuler des compétences de développement, d'analyse de données, et d'élaboration de stratégies gagnantes.

	Chapitre I : organisation et analyse du projet
	présentation rapide

Ca fait un moment que j'y pense : ajouter des IA plus performantes à mes projets.
Pour commencer on va s'occuper du jeu "The Battle of Polytopia".
J'aime pas mal ce jeu, il est simple mais peu demander beaucoup de stratégie, voir même des métas pour certains modes de jeu.
Donc l'idée de voir des IA's choisir les voies de la guerre de la plus grande puissance ou de la diplomatie est particulièrement exitante.

	définitions
	ressources humaines
		fréquence de travail
Aucune fréquence de travail n'est fixée, celle-ci sera simplement spontanée. Pour tout dire : je m'ennuyais juste un peu.
		répartition des tâches
Dans un soucis d'efficacité, pour ne pas perdre ce projet de tête, on commencera par réaliser le coeur du projet, les sujets présentés aux chapitres II et III. Ensuite seulement l'entrainement sera lancé, durant lequel ce rapport sera complété, relu et corrigé
	ressources logiciels
		pour le projet
Le projet est spontané et sans grande importance, à par combler mon manque d'amusement apparant, ainsi il sera ajouté à ma page GitHub uniquement après ou durant sa réalisation si l'envie me prend.
		écriture du code
Dans un soucis d'amélioration de la rigoureusité dans la manière d'écrire le code, je me fixe une contrainte depuis un certain temps : coder sur Scite pour avoir à écrire le moindre symbole, sous Java 1.8 pour aucune raison particulière.
		écriture du rapport
Dans le même soucis d'efficacité le rapport sera déjà écrit sous forme de notes, pour garder une trace au fur et à mesure de l'avancement du projet, puis réecrit avec LateX sur TexMaker.

	Chapitre II : création du jeu
	notes sur "The Battle of Polytopia"
		global
C'est un jeu de str&tégie au tour par tour primé sur la construction d'une civilisation et le combat. Les joueurs dirigent l'une des tribus, explore le monde carré, construisent des viles, développent des technologies et font la guerre à d'autres joueurs pour prendre le contrôle de la terre mythique de Polytopia.
		tribus de base
Nom		technologie de départ	couleur
Xin-xi		Escalade		#CC0000
Imperius	Organisation		#0000FF
Bardur		Chasse			#352514
Oumanji		Equitation		#ffff00

		modes de jeu
Nom		Nombre de tour	Gagnant
Perfection	30		la tribu avec le plus de points
Domination	sans limite	la dernière tribu restante (qui aura éliminer toutes les autres)
Infinité	sans limite	sans gagnant particulier, la partie ne cesse d'évoluer sans arrêt prédéfini

		carte
Le monde est une matrice carré de tuiles de terrain (Minuscule 121, Petite 196, Normale 256, Grande 324, Enorme 400, Immense 900).
			Taux d'apparition des tuiles
"Centre-ville" fait référence aux tuiles qui sont adjacentes à une ville ou à un village, "Ville extérieure" fait référence à celles qui ne le sont pas.
Nom			Centre-ville	Ville extérieure
Champ (total)		46%		46%
fruit			20%		6%
culture			20%		6%
plaine vide		6%		34%

Forêt (total)		34%		34%
animal			17%		6%
forêt vide		17%		28%

Montagne (total)	20%		20%
Metal			17%		3%
montagne vide		3%		17%

Le taux d'apparition standard des poissons est de 50 % parmi les tuiles d'eau peu profonde. Le taux d'apparition des baleines est de 33 % parmi les tuiles océaniques ; ce taux ne varie pas selon la tribu, contrairement à ceux des autres ressources.

			Variation des taux par tribu
Tribu		Modifs
Xin-xi		1.5x montagne	1.5x metal
Imperius	0.5x animal	2.0x fruit
Bardur		1.5x fruit	0x culture
Oumanji		0.2x forêt	0.2x animal	0.5x montagne	0.5x eau
			Règles d'apparition des tuiles
- Les villages n'apparaissent pas sur les bords de la carte et pas plus d'un village n'apparaîtra dans une zone 3x3. Les ressources n'apparaissent que dans un rayon de deux cases autour des villages.
- Les ruines n'apparaissent pas à côté d'une capitale ou à côté d'une autre ruine.
- Toute tuile d'eau qui partage un bord avec une tuile de terre est une tuile d'eau peu profonde. Les autres tuiles Eau, y compris celles en diagonale des tuiles Terre, sont des tuiles Océan.
- Les cultures, le métal et les baleines ne sont pas visibles tant que l'organisation (ou l'agriculture), l'escalade ou la pêche n'ont pas été recherchées, respectivement.
- Toutes les tribus sont garanties d'avoir au moins deux ressources identiques dans leur capitale. Pour Bardur et Imperius, ce sont les ressources liées à leur technologie de départ. Xin-xi est garanti deux métaux, Oumaji deux fruits. Les ressources sont générées de force en remplaçant les tuiles par une tuile contenant la ressource si la génération initiale du monde ne fournit pas au moins deux des ressources.
- Les baleines n'apparaissent pas à côté d'une ville ou à côté d'une autre baleine.

			Processus de génération de terrain
1. les capitales sont générées aléatoirement dans le domaine de chaque joueur.
2. sur tous les types de cartes sauf Waterland, nous générons 1 à 2 banlieues par capitale. Ce sont des villages aussi proches que possible de la capitale qui sont reliés de force à la capitale par la masse terrestre. Dans les situations où il est tout simplement impossible d'ajouter une autre banlieue à une capitale, cette capitale est plutôt connectée à la banlieue ou à la capitale de quelqu'un d'autre. Afin de nous assurer que nous n'obtenons jamais d'îles désertes. Ensuite, nous plaçons au hasard environ un tiers des villages. Également avant la génération du terrain, la seule chose dont nous devons tenir compte lors de leur placement est de nous assurer qu'ils sont à au moins deux tuiles de toute autre ville.
3. Après cela, nous avons généré du terrain à partir du bruit lissé (où les tuiles de la ville sont forcées d'acquérir des valeurs, et sont donc susceptibles de répandre des terres autour d'elles grâce au lissage).
4. Nous plaçons au hasard des villes sur ces emplacements tant qu'il en reste ou jusqu'à ce que nous atteignions ou nombre de villes maximum (par exemple, sur les terres arides, nous définissons le nombre maximum de villes un peu en dessous du maximum potentiel afin que la carte ne soit pas complètement modèle prévisible de villages). Le nombre de domaines dépend du nombre de joueurs. 1-4 joueurs -> 4 domaines. max villages n'est pas déterministe et est différent selon la carte. la plupart des configurations de carte génèrent 30 % des villages maximum théoriques avant de générer le terrain, puis tentent d'attribuer 60 % après la génération du terrain. Dryland ne crée pas de villages avant le terrain, mais crée 80% du maximum après la génération du terrain. le monde de l'eau n'attribue que 10% avant la génération de terrain.
