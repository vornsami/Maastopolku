
Ohjelma rakentuu seuraavanlaisesti:

Main.java
    - Ohjelman käynnistys, arvojen syöttäminen ja suorituksen järjestelyt

map

- MapHandler.java
    - käsittelee kartan lataamisen, mittaamisen ja lukemisen

functions

- PathFinder.java
    - Rajapinta algoritmeille

- Algoritmien toteutukset:
    - Dijkstra.java
    - BellmanFord.java
    - AStar.java

- Tools.java
    - satunnaisia algoritmien yhteisesti käytettäviä työkaluja 


resources-kansioon tulevat karttakuvat.

Kartoissa käytettävät värit ovat seuraavanlaiset:

- Musta: ei kuljettava, heksadesimaali \#000000
- Valkoinen: kuljettava, heksadesimaali \#FFFFFF
- Sininen: nopeasti kuljettava, heksadesimaali \#0000FF
- Vihreä: hitaasti kuljettava, heksadesimaali \#00FF00
- Punainen: hyvin hitaasti kuljettava, heksadesimaali \#FF0000

Muut värit käyttäytyvät kuten valkoinen.

Toteutettujen algoritmien nopeuksien vertailu:
 
Bellman-Ford:	

	| Kartta           | Laskettu etäisyys  | Solmujen määrä | Kulunut aika |
	| ---------------- | ------------------ |:--------------:| ------------:|
	| map1             | 57.94112549695426  | 4210           | 21ms         |
	| map1             | 86.08326112068518  | 4210           | 20ms         |
	| maze             | 733.0193359837574  | 54226          | 69ms         |
	| sc_FloodedPlains | 293.00714267493635 | 99212          | 100ms        |
	| sc_FloodedPlains | 691.3889603929562  | 99212          | 128ms        |
	| sc_FloodedPlains | 1381.4103884177687 | 99212          | 100ms        |

Dijkstra: 	

	| Kartta           | Laskettu etäisyys  | Solmujen määrä | Kulunut aika |
	| ---------------- | ------------------ |:--------------:| ------------:|
	| map1             | 57.94112549695426  | 2023           | 29ms         |
	| map1             | 86.08326112068518  | 3371           | 38ms         |
	| maze             | 733.0193359837574  | 38156          | 258ms        |
	| sc_FloodedPlains | 293.00714267493635 | 6747           | 137ms        |
	| sc_FloodedPlains | 691.3889603929562  | 36118          | 2057ms       |
	| sc_FloodedPlains | 1381.4103884177687 | 75580          | 3439ms       |
A*: 	
	
	| Kartta           | Laskettu etäisyys  | Solmujen määrä | Kulunut aika |
	| ---------------- | ------------------ |:--------------:| ------------:|
	| map1             | 57.94112549695426  | 462            | 5ms          |
	| map1             | 86.08326112068518  | 1252           | 20ms         |
	| maze             | 733.0193359837574  | 27498          | 399ms        |
	| sc_FloodedPlains | 290.00714267493635 | 2255           | 37ms         |
	| sc_FloodedPlains | 688.3889603929562  | 6214           | 364ms        |
	| sc_FloodedPlains | 1381.4103884177687 | 49196          | 12408ms      |



