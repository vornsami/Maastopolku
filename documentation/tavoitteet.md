Projektin tavoitteena on luoda ohjelma, joka etsii annetulla kartalla lyhyimmän reitin kahden pisteen välillä.

Ohjelmalle annetaan kuva, jossa on eri väreillä merkitty maaston kuljettavuus. Ohjelma sitten etsii nopeimman reitin kahden karttapisteen välillä, ja palauttaa sen kuvana.

Käytettävät värit tulevat olemaan seuraavanlaiset:

- Musta: ei kuljettava
- Valkoinen: kuljettava
- Sininen: nopeasti kuljettava
- Vihreä: hitaasti kuljettava
- Punainen: hyvin hitaasti kuljettava


Jokaisesta ksrttapisteestä pystytään kulkemaan kahdeksaan suuntaan, yhden yksikkömitan ylös, alas oikealle ja vasemmalle ja neliöjuuri 2 yksikköä viistoihin.
Näin kartalle on muodostettavissa verkko, jossa kulkemiseen voidaan soveltaa polunetsintäalgoritmeja. 
Kuljettavan yksikkömitan pituutta tulee pystyä säätää ohjelmaa käynnistäessä.