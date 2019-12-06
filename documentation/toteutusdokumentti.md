
__Ohjelman rakenne:__

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


__Toteutettujen algoritmien nopeuksien vertailu:__


Kaikki testit alkavat kuvan vasemmasta yläkulmasta pisteestä 0;0. Päätepisteenä on oikean alakulman piste across-taulukoissa, joka esimerkiksi kartassa blank100 olisi 99;99. 
Middle-taulukossa päätepiste on kartan keskellä, joka olisi blank 100:ssa 49;49. 
Karttoja on kahta tyyppiä. blank-tyyppiset kartat ovat täysin tyhjiä. test-tyyppisissä kartoissa on musta neliö keskellä karttaa. Kartan perässä oleva luku viittaa kartan reunojen pituuteen.

Käytetty yksikkömitta kaikissa testeissä on 1. 

Testit voi suorittaa itse kirjoittamalla "run tests", kun ohjelma kysyy karttaa.


Blanks, across			100				500				1000
---------------------------------
bellman-ford   		|	33ms, 10132 visited 	|	267ms, 271564 visited 	|	584ms, 1032584 visited 
dijkstra   		|	14ms, 10132 visited 	|	417ms, 271559 visited 	|	905ms, 1032566 visited 
aStar   		|	1ms, 100 visited 	|	3ms, 500 visited 	|	2ms, 1000 visited 

Blanks, middle			100				500				1000
---------------------------------
bellman-ford   		|	5ms, 10132 visited 	|	89ms, 271564 visited 	|	590ms, 1032584 visited 
dijkstra   		|	1ms, 3531 visited 	|	52ms, 102750 visited 	|	214ms, 378543 visited 
aStar   		|	0ms, 50 visited 	|	0ms, 250 visited 	|	2ms, 500 visited 

Tests, across			100				500				1000
---------------------------------
bellman-ford   		|	3ms, 7148 visited 	|	67ms, 182023 visited 	|	333ms, 672584 visited 
dijkstra   		|	4ms, 7147 visited 	|	93ms, 182021 visited 	|	451ms, 672574 visited 
aStar   		|	7ms, 10481 visited 	|	153ms, 249544 visited 	|	1217ms, 995340 visited 

Erityisen huomattavaa on, kuinka A* tutkii huomattavasti enemmän solmuja esteiden läsnäollessa. A* tutkii esteen kanssa kaikista eniten solmuja jokaisessa karttakoossa. 
Bellman-Ford on huomattavasti nopeampi kahdessa jälkimmäisessä testissä kuin Blanks-across -testissä. Tämä varmaan johtuu suoritusjärjestyksestä. Ensimmäisten Bellman-Ford -kutsujen aikana saattaa olla sovelluksen muita suorituksia edelleen meneillään, hidastaen suoritusta.
A* vaikuttaa olevan kaikista hitain esteen kanssa. 

