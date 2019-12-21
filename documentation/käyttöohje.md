__Ohjelman suorittaminen__

Ohjelman voi suorittaa joko käyttämällä gradlea jai suoraan jar-tiedostosta.

Gradlea käytettäessä siirry komentokehotteessa kansioon "maastopolku", ja suorita komento
	
	gradle run

Jar-tiedostoa käytettäessä siirry komentokehotteessa kansioon, jonne olet sen asettanut, ja suorita komento

	java -jar maastopolku.jar


__Kartat__

Käytettävät kartat laitetaan kansioon maastopolku/maps. 
Jar-tiedostoa käytettäessä maps-kansio tulee olla samassa kansiossa kuin jar-tiedosto.

Kaikkien karttojen tulee olla .png -muodossa

Karttojen värit tulevat olla täsmälleen niitä, mitä toteutusdokumentissa on määritelty.

Kansiossa on jo muutama kartta valmiina, joita on käytetty ohjelman testaukseen.


__Käyttö__


Ohjelma pyytää ensin kartan nimeä. Nimi tulee antaa ilman tyyppitunnistetta .png.

Seuraavaksi ohjelma pyytää ns. yksikkömittaa (unit distance). Yksikkömitta väliä, jolla ohjelma tarkastelee karttaa.
Suuremmat arvot johtavat nopeampaan suoritukseen, mutta tarkkuus kärsii. Ohjelma saattaa myös hypätä "seinien yli", mikäli luku on liian suuri.

Esiin tulee ruutu, jossa on kuva avatusta kartasta. Klikkaa kartasta sieltä, minne haluat aloituspisteen. Tämän jälkeen klikkaa sieltä, minne haluat lopetuspisteen.
Tämän jälkeen ruutu sulkeutuu. Ohjelma laskee reitit kolmella eri algoritmilla, ja tulostaa tulokset komentokehotteeseen. 
Kansioon "results" tulee karttakuva nopeimmasta reitistä. Kartalla on keltaisella merkittynä kaikki algoritmien käsittelemät karttapisteet. Harmaalla piirretty viiva kuvaa nopeinta reittiä.