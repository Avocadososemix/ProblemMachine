<u><b>Käyttöohjeet</b>

Ohjelman käyttö</u>

Ohjelman käynnistämisen jälkeen voi käyttäjä valita jonkin kolmesta eri tehtäväsarjasta ohjelman oikeasta yläkulmasta. Painikkeen painaminen lataa kyseiset tehtävät ohjelman käyttöön.

Kun jokin tehtäväsarja on ladattu käyttöön, voi käyttäjä vastata ylimmäisessä tekstialueessa näkyvään tehtävään Vastaus-sanalla merkittyyn tekstikenttään. Mikäli vastaus sisältää desimaaliluvun, tulee käyttäjän vastata 2 desimaalipisteen tarkkuudella. Käyttäjä voi halutessaan kirjoittaa vastauksen yksiköt vastausalueelle, mutta tämä ei ole tarpeellista oikean vastauksen saavuttamiseksi. Oikea numeerinen arvo riittää vastaukseksi.

Kun käyttäjä on tyytyväinen vastaukseensa, voi tämä lukita vastauksensa vastauskentän oikeanpuolisella "Lukitsen vastaukseni!"-painikkeella, joka tarkistaa vastauksen oikeellisuuden. Oikeasta vastauksesta käyttäjä saa yhden pisteen. Vastaamalla oikein näyttää ohjelma myös alemmassa tekstialueessa mallivastauksen tehtävään.

Käyttäjä voi halutessaan pyytää ohjelmalta oikean vastauksen ilman mallivastausta ja laskutoimituksia painamalla "Vastaus!"-painiketta, tai pyytää mallivastausta käyttämällä "Mallivastaus"-painiketta, joka palauttaa tyypillisesti menetelmän jolla voidaan laskea oikea vastaus.

Painamalla "Vaihda Kysymystä!"-painiketta käyttäjä voi vaihtaa ohjelman kysymää kysymystä saman tehtäväsarjan sisällä, eli mikäli käyttäjä on ladannut kemian tehtävät "Vaihda Kysymystä!"-painike vaihtaa toiseen kemian tehtävään. Vaihtamalla kysymystä voidaan saada myös sama tehtävä kuin mitä käyttäjä teki aiemmin, mutta todennäköisyys on pienempi saada tehtävä johon on jo vastattu onnistuneesti. Saadun tehtävän laskut ovat kuitenkin muuttuneet, vaikka saadaan sama tehtävä, sillä tehtäviin arvotaan aina uudet muuttujien arvot kun ne ladataan.

Ohjelman sulkeminen tapahtuu raksista yläoikeassa kulmassa.

Käyttäjä näkee pisteidensä määrän vasemmasta yläkulmasta.

<u>Uusien tehtävien luonti</u>

Mikäli käyttäjä haluaa lisätä uusia tehtäviä ohjelmaan, syntaksi uusien tehtävien luomiseen on vastaavanlainen. Kirjoitetaan haluttuun kysymystiedostoon uusi rivi, jossa on '|'-merkkien jakamana kysymyksen luontiin vaaditut neljä osaa. Ensimmäinen osa on itse kysymys, toinen osa on vastaus, jota vertaillaan käyttäjän antamaan vastaukseen. Mikäli vastaus sisältää numeroita, vastauksen vertailija tarkastelee vain numeroita molemmissa vastauksissa, muutoin vastauksen vertailija tarkastelee mikäli koko vastausteksti on sama kuin ohjelman pyytämä vastaus. Kolmannen osan sisältämässä tekstistä löytyy kysymykseen mallivastaus, jossa avataan kysymyksen ratkominen käyttäjälle. Viimeinen osa sisältää kysymyksen muuttujien mahdolliset arvot. Arvot luetellaan niiden muuttujien aakkosjärjestyksessä, pienemmästä arvosta suurempaan, ja uusien arvojen välille asettaen pilkun. Esim. 5-50, 2.0-4.5 (tässä $A:n arvo kokonaisluku 5 <= A <= 50). 

Kysymyksen muuttujat merkitään $-merkillä. Kun kirjoitamme ison kirjaimen jota edeltää dollarimerkki, muutetaan tämä merkkiyhdistelmä lopullisessa tehtävänannossa, vastauksessa ja mallivastauksessa joksikin arvoksi siltä arvoväliltä joka kyseiselle muuttujalle halutaan antaa. Muuttujat täytyy merkitä aakkosjärjestyksessä, ei voida antaa muuttujaa $C ennen kuin $A ja $B on käytetty. Muuttujien järjestyksellä itse kysymyksessä ei ole kuitenkaan väliä.

Mikäli haluamme laskea jonkin laskun vastauksen tai mallivastauksen sisällä, käytämme kaarisulkuja { ja } laskun ympärillä, jolloin ohjelma tunnistaa laskun laskettavaksi. Voimme siis kirjoittaa vaikka 1+2 = {1+2}, jolloin ohjelman tulostus olisi 1+2 = 3. Tällöin voimme mallivastauksessa kirjoittaa laskuja ja päättää mitkä laskut haluamme laskea ja mitkä jättää esimerkeiksi. Esimerkki kaiken tämän solveltamisesta näkyy alla.

Usain bolt juoksee $Am $Bm/s nopeudella, montako sekuntia kestää Boltilla juosta kysytty matka? | {$A/$B} sekuntia | Laskemalla $Am jaettuna Boltin nopeudella $Bm/s saamme laskutoimitukseksi $Am/$Bm/s = {$A/$B}s. | 100-1000, 8.0-12.5


