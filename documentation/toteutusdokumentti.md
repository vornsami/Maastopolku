
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

