Réalisé avec : Pierre BERNARD, Antonia IVANOVA, Abdel-Kader EL HOUSSAMI, Dila MEMIL et [Arthur MILLET](https://github.com/milletarthur)

Compilation sous Eclipse : 

Pour réaliser ce projet nous avons utilisé Eclipse avec les configurations que nous avions déjà utilisés dans POO.

Compilation sous Java 11. 




Structuration du code : 

Notre code est structuré en 4 parties tels que chacune d'entre elles répond à une problématique particulière.

Différentes parties et leurs fonctionnalités : 
	- Model : met en place toutes les structures de données/objects nécessaires au jeu (le terrain, les entités, ...).
	- Controller : décide du comportement de chaque entité en fonction des entrée qui lui sont données (clavier et automates).
	- BOT/Automates : implémente un visiteur pour le parseur. Cette partie fait le lien entre les automates en GAL (et leur parseur) et le Controller en Java. 
	- View : permet d'afficher le jeu. 
	
Nous avons un paquet toolkit qui centralise toutes classes utilisées dans les quatre parties.

Le paquet sound ne sert qu'à rajouter la musique au jeu. 





Instructions de lancement : 

Pour lancer un jeu, il faut exécuter le main qui est dans la classe Game dans le paquet game.info3.game.
Pour cela il faut aller dans le dossier info3.game.given.2021 et tapper la commande suivante (après compilation via eclipse) :
java -cp bin:resources/config/json-20210307.jar info3.game.Game

Lors du lancement de ce dernier une interface vous demandera si vous voulez le lancer le moteur en mode labyrinthe ou en mode arène. 
Les différence sont la densité des murs (réglable dans le fichier de configuration) et les automates des entités.

Le moteur de jeu est configurable de deux manières différentes : 
 - Au moyen d'un fichier de configuration qui permet de régler les propriétés des différentes entités et du terrain (côté Model);
 - Au moyen d'automates qui définissent le comportement des différentes entités (côté Controller).

Ces deux moyens doivent être cumulés pour pouvoir générer un jeu.
 
Pour simplifier l'utilisation, nous avons fourni deux fichiers de configuration (l'un pour une arène et l'autre pour un labyrinthe) ainsi que deux fichiers d'automates : jeu1.gal et jeu2.gal.

Avec les configurations que nous fournissons, nous générons les deux jeux présentés dans le contrat. 




Instructions pour les controlles :

Joueur 1
Z : aller au Nord / s'orrienter vers le Nord
Q : aller à l'Ouest / s'orrienter vers l'Ouest
S : aller au Sud / s'orrienter vers le Sud
D : aller à l'Est / s'orrienter vers l'Est
A : Frapper / utiliser l'objet en main
W : Reccuperer en main l'objet courrement selectionné dans l'inventaire
C : Cycler parmis les objets de l'inventaire
E : Poser devant soi l'objet en main
Premier jeu uniquement :
X : Mettre dans l'inventaire l'objet en main
Deuxième jeu uniquement :
V : passer en mode selection / sortir du mode selection

Joueur 2
FU : aller au Nord / s'orrienter vers le Nord
FL : aller à l'Ouest / s'orrienter vers l'Ouest
FD : aller au Sud / s'orrienter vers le Sud
FR : aller à l'Est / s'orrienter vers l'Est
L : Frapper / utiliser l'objet en main
O : Reccuperer en main l'objet courrement selectionné dans l'inventaire
P : Cycler parmis les objets de l'inventaire
M : Poser devant soi l'objet en main
Premier jeu uniquement :
I : Mettre dans l'inventaire l'objet en main
Deuxième jeu uniquement :
I : passer en mode selection / sortir du mode selection

Les cases de selections se deplacent soit avec ZQSD soit les fleches diretionnelles selon le joueur




Lien vers la vidéo : https://youtu.be/SI_tEioPQh0




Lien vers le Journal de Bord : https://docs.google.com/document/d/1i-li4hJKb3Ap3xVwqmdMGF-XPCaPDserZwos3-hA4n8/edit?usp=sharing




Pourcentage de participation : 
	- Pierre BERNARD : 1/6
	- Antonia IVANOVA : 1/6
	- Chloé MERCIER : 1/6
	- Abdel-Kader EL HOUSSAMI : 1/6
	- Dila MEMIL : 1/6
	- Arthur MILLET : 1/6
