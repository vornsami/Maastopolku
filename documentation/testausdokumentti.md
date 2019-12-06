
Toteutettujen algoritmien nopeuksien vertailu:

Kaikki testit alkavat kuvan vasemmasta yläkulmasta pisteestä 1;1. Päätepisteenä on oikean alakulman piste, joka esimerkiksi kartassa blank100 olisi 99;99. 
Karttoja on kahta tyyppiä. blank-tyyppiset kartat ovat täysin tyhjiä. test-tyyppisissä kartoissa on musta neliö keskellä karttaa. Kartan perässä oleva luku viittaa kartan reunojen pituuteen.

Käytetty yksikkömitta kaikissa testeissä on 1. 

Bellman-Ford:	

	| Kartta           | Laskettu etäisyys  | Solmujen määrä | Kulunut aika |
	| ---------------- | ------------------ |:--------------:| ------------:|
	| blank100         | 138.59292911256324 | 10312          | 28ms         |
	| blank500         | 704.2783540618058  | 272528         | 275ms        |
	| blank1000        | 1411.385135248359  | 1034558        | 628ms        |
	| blank5000        | 7068.239384740933  | 28106424       | 26172ms      |
	| test100          | 173.7401153701775  | 7247           | 25ms         |
	| test500          | 880.0142853498738  | 182985         | 242ms        |
	| test1000         | 1762.856997824495  | 675473         | 453ms        |
	| test5000         | 8825.598697621466  | 17161490       | 13928ms      |

Dijkstra: 	

	| Kartta           | Laskettu etäisyys  | Solmujen määrä | Kulunut aika |
	| ---------------- | ------------------ |:--------------:| ------------:|
	| blank100         | 138.59292911256324 | 10119          | 35ms         |
	| blank500         | 704.2783540618058  | 271526         | 272ms        |
	| blank1000        | 1411.385135248359  | 1032544        | 1325ms       |
	| test100          | 173.7401153701775  | 7052           | 37ms         |
	| test500          | 880.0142853498738  | 181991         | 234ms        |
	| test1000         | 1762.856997824495  | 673468         | 567ms        |
A*: 	
	
	| Kartta           | Laskettu etäisyys  | Solmujen määrä | Kulunut aika |
	| ---------------- | ------------------ |:--------------:| ------------:|
	| blank100         | 138.59292911256324 | 99             | 1ms          |
	| blank500         | 704.2783540618058  | 499            | 5ms          |
	| blank1000        | 1411.385135248359  | 999            | 28ms         |
	| test100          | 173.7401153701775  | 10410          | 16ms         |
	| test500          | 880.0142853498738  | 249384         | 200ms        |
	| test1000         | 1762.856997824495  | 991737         | 728ms        |

Erityisen huomattavaa on, kuinka A* tutkii huomattavasti enemmän solmuja esteiden läsnäollessa. A* tutkii esteen kanssa kaikista eniten solmuja, mutta suurin osa niistä ilmeisesti hylätään, ottaen huomioon ajankäytön.
Dijkstra tutkii melkein koko kartan, mikä johtuu valituista pisteistä. Mielenkiintoista on, kuinka dijkstra oli Bellman-Fordia nopeampi 500x500 kartoissa, mutta ei muissa.
Mielenkiinoista on myös, kuinka A* on kaikista hitain esteellisessä 1000x1000-kartassa. 

