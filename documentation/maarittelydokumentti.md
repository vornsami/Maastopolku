Projektin tavoitteena on luoda ohjelma, joka etsii annetulla kartalla nopeimmin kuljettavan reitin kahden pisteen välillä.

Ohjelmalle annetaan kuva, jossa on eri väreillä määritelty maaston kuljettavuus. Ohjelman suorituksessa annetaan kuvan nimi, aloituspiste ja päätepiste sekä mittayksikkö verkonmuodostukseen.
Ohjelma suorituksensa päätteeksi palauttaa nopeimman reitin kuvana.

Ohjelma toteutetaan djikstran algoritmilla, koska haluamme minimoida kaarien käytön. Tavoitteena on, että ohjelma suorittaa toimintansa O(n+mlogn)-ajassa.