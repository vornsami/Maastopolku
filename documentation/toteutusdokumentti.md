
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


Blanks, across			100				250				500				750				1000
---------------------------------
bellman-ford   		|	20ms, 10132 visited 	|	82ms, 73694 visited 	|	155ms, 271564 visited 	|	228ms, 589600 visited 	|	525ms, 1032584 visited 
dijkstra   		|	12ms, 10132 visited 	|	55ms, 73693 visited 	|	322ms, 271559 visited 	|	281ms, 589590 visited 	|	536ms, 1032566 visited 
aStar   		|	2ms, 100 visited 	|	1ms, 250 visited 	|	1ms, 500 visited 	|	1ms, 750 visited 	|	2ms, 1000 visited 

Blanks, middle			100				250				500				750				1000
---------------------------------
bellman-ford   		|	5ms, 10132 visited 	|	24ms, 73694 visited 	|	157ms, 271564 visited 	|	196ms, 589600 visited 	|	746ms, 1032584 visited 
dijkstra   		|	2ms, 3531 visited 	|	11ms, 25878 visited 	|	46ms, 102750 visited 	|	107ms, 220166 visited 	|	180ms, 378543 visited 
aStar   		|	0ms, 50 visited 	|	0ms, 125 visited 	|	0ms, 250 visited 	|	1ms, 375 visited 	|	0ms, 500 visited 

Blocks, across			100				250				500				750				1000
---------------------------------
bellman-ford   		|	2ms, 7620 visited 	|	15ms, 47428 visited 	|	89ms, 184415 visited 	|	115ms, 390692 visited 	|	205ms, 677376 visited 
dijkstra   		|	3ms, 7147 visited 	|	20ms, 46236 visited 	|	122ms, 182020 visited 	|	180ms, 387085 visited 	|	311ms, 672559 visited 
aStar   		|	6ms, 6279 visited 	|	35ms, 37597 visited 	|	95ms, 173745 visited 	|	242ms, 348464 visited 	|	266ms, 576784 visited 


Huomioita:

- Erityisen huomattavaa on, kuinka A* tutkii huomattavasti enemmän solmuja esteiden läsnäollessa. Tutkittujen solmujen määrä lähestyy muita algoritmeja
- Bellman-Ford on huomattavasti nopeampi Blanks, middle -testissä kuin Blanks, across -testissä. Tämä varmaan johtuu suoritusjärjestyksestä. Ensimmäisten Bellman-Ford -kutsujen aikana saattaa olla sovelluksen muita suorituksia edelleen meneillään, hidastaen algoritmin suoritusta.
- Blocks-testeissä Bellman-Ford vaikuttaisi olevan nopein. Tämä johtunee siitä, että se käsittelee yksittäisen solmun nopeiten, ja Blocks-kartat saavat kaikki algoritmit käsittelemään suurin piirtein saman määrän solmuja.
- Blocks-testeissä Dijkstran ja A*:n nopeudet ovat hyvin lähellä toisiaan. 


__Tulosten oikeellisuus__

Kaikki algoritmit antavat oikean tuloksen kartalla, joissa kuljettava alue on vain yhtä väriä. 
A* voi antaa pidempiä reittejä kartoilla, joissa on useampia kulkunopeuksia, mikäli algoritmi jättää nämä reitit tutkimatta. Tämä on ongelma, joka johtuu A* algoritmin toimintatavasta. 
Dijkstra ja Bellman-Ford antavat aina oikean tuloksen kartasta riippumatta.
