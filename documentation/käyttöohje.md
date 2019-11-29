__Kartat__

Käytettävät kartat laitetaan kansioon maastopolku/src/main/resources/maps.

Kaikkien karttojen tulee olla .png -muodossa

Karttojen värit tulevat olla täsmälleen niitä, mitä toteutusdokumentissa on määritelty.

Kansiossa on jo muutama kartta valmiina, joita on käytetty ohjelman testaukseen.


__Käyttö__

Ohjelma pyytää ensin kartan nimeä. Nimi tulee antaa ilman tyyppitunnistetta .png.

Seuraavaksi ohjelma pyytää ns. yksikkömittaa (unit distance). Yksikkömitta väliä, jolla ohjelma tarkastelee karttaa.
Suuremmat arvot johtavat nopeampaan suoritukseen, mutta tarkkuus kärsii. Ohjelma saattaa myös hypätä "seinien yli", mikäli luku on liian suuri.

Lopuksi ohjelma pyytää aloitus, ja lopetuspisteet. Ne annetaan muodossa x;y, missä x on pikselin x-koordinaatti ja y pikselin y-koordinaatti.
Huomatkaa, että pikselit lasketaan kuvan vasemmasta yläreunasta.