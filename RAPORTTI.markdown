# Raportit tehtävistä

Kirjaa tähän tiedostoon **jokaiseen** tehtävään liittyvät omat raporttisi ja analyysisi. Muista että raportti on myös kurssilla **arvosteltava tehtävä**.

Voit sisällyttää raporttiin tekstimuotoisia taulukoita (tasaukset välilyönnein):

```
n     Fill     Search   Total
500   7        700      707
1000  9        288      297
```

Ja näihin liittyviä kuvatiedostoja:

![Esimerkkikuva](report-sample-image.png)

Nämä näkyvät sitten VS Coden Preview -näkymässä (tai oman repositorysi webbisivulla) oikein muotoiltuna. Käytä tässä dokumentissa olevia muotoiluja esimerkkinä kun kirjoitat raporttiasi. 

Huomaa että jos laitat kuvatiedostot vaikka omaan alihakemistoonsa, Markdown -muotoilussa on oltava suhteellinen polku tiedostoon, esimerkiksi `images/report-sample-image.png`. **Älä** käytä absoluuttisia polkuja `C:\Users\tippaleipa\kurssit\TIRA\kuva.png`, koska nämä eivät tietenkään toimi opettajan koneella. Ei kannata laittaa linkkiä etärepoosikaan, vaan nimenomaan paikalliseen tiedostoon.

Voit myös sisällyttää *lyhyitä* koodinpätkiä vaikkapa Java -formaatilla:

```Java
	@Override
	public int hashCode() {
		// Oma nerokas hajautufunktioni!
	}
```
Tarvittaessa käytä myös paremmin muotoiltuja taulukoita:

| n	| Fill	| Search	| Total |
|-----|--------|--------|-------|
| 500	 | 7	| 700	| 707 |
| 1000 |	9	| 288	| 297 | 

Alaluvut jokaisen tehtävän raportille löydät alta.


## 01-TASK

Tehtävän tekemisessä opin/kertasin, miten javalla iteroidaan taulukoiden läpi ja miten niitä järjestellään ilman ArrayList:ia.

Toteuttamani lajittelualgoritmin aikakompleksisuusluokka on O(n^2).

Toteuttamani reverse-algoritmin aikakompleksisuusluokka on O(n).

Kannattaa kääntää sen järjestys, koska kääntämisalgoritmin aikakompleksisuusluokka on lineaarinen n ja lajittelualgoritmin eksponentiaalinen n^2. Tällä on suuri merkitys erityisesti suuria taulukoita lajitellessa.

## 02-TASK

Suoritin askeleen 3 testin 2 kertaa. Vasemmalla kuvassa on ensimmäisen testin tulokset fill ja search aikojen suhteista n kokoon. Oikealla on otettu kahden testin keskiarvot jokaiselle arvolle ja asetettu ne taulukkon n kanssa.
![Taulukko](taulukko_task2.png)
Toisen testin tulokset
```
n		Fill	Search	Total
500		25		1415	1440
1000	21		404		425
1500	11		491		502
2000	14		659		673
2500	24		704		728
3000	31		353		384
3500	35		630		665
4000	48		216		264
4500	61		659		720
5000	73		141		214
5500	90		272		362
6000	104		374		478
6500	122		318		440
7000	141		324		465
7500	175		1468	1643
8000	193		393		586
8500	209		416		625
9000	237		414		651
9500	263		477		740
10000	297		469		766
10500	359		547		906
11000	411		476		887
11500	399		569		968
12000	453		1065	1518
12500	586		632		1218
13000	654		611		1265
13500	672		665		1337
14000	611		604		1215
14500	669		664		1333
15000	789		853		1642
15500	635		426		1061
16000	837		783		1620
16500	903		903		1806
17000	968		837		1805
17500	1091	929		2020
18000	1383	881		2264
18500	1374	922		2296
19000	1479	932		2411
19500	1512	1015	2527
20000	1494	1055	2549
20500	1582	1250	2832
21000	1754	1807	3561
21500	1799	2627	4426
22000	1911	1226	3137
22500	2178	1287	3465
23000	2374	1312	3686
23500	1400	673		2073
24000	2540	2232	4772
24500	2566	2717	5283
25000	2847	1661	4508
25500	3026	1915	4941
26000	3101	3227	6328
26500	3386	1644	5030
27000	3536	3151	6687
27500	3677	3091	6768
28000	3868	1871	5739
28500	4143	1936	6079
29000	4259	3278	7537
29500	2834	1278	4112
30000	4738	2350	7088
30500	4907	2265	7172
31000	5176	3515	8691
31500	6177	4425	10602
32000	6293	2682	8975
```
Käyristä näyttäisi, että molempien aikojen kasvavan eksponentiaalisesti n kasvaessa. SimpleContainen.add -algoritmi ei sisällä sisäkkäisiä looppeja, vaan pelkkiä yksittäisiä looppeja, joten sen aikakompleksisuusluokka on O(n). Mutta, kun add-algoritmia kutsutaan toisesta loopista LinearFindTest.fillContainer:ssa n kertaa on koko lisäyksen aikakompleksisuusluokka O(n^2). Siksi kulunut aika kasvaa eksponentiaalisesti.
Totetuttamani hakualgoritmit sisältävät kaikki vain yhden for loopin, joten niiden kaikkien aikakompleksisuusluokka on O(n). Myös hakualgoritmeja kutsutaan testissä ulommasta loopista, joten koko haun aikakompleksisuusluokka on myös O(n^2). Siksi myös se vaikuttaisi kasvavan eksponentiaalisesti.

Tehtävää tehdessä muistui mieleen Javan luokkien ja rajapintojen toiminta. Vaikeaa oli juuri käytännön toteutus, kun Javan syntaksi ei ole hyvin muistissa. Helppoa oli itse koodin kirjoittaminen. For silmukat oli helppo toteuttaa.

Käytetään 10 000 koodarin tiedostoa.
Lajittelu on nopeaa (~1ms) silloin, kun vaihdetaan järjestys laskevasta nousevaan tai toisin päin. Hitaampaa (~700ms) silloin, kun järjestetään taulukko uudestaan eri perusteella eli koko nimestä koodarimeen tai toisin päin. Nimien vaihtaminen laskevasta nousevaan on nopeaa, koska reverse-algoritmin aikakompleksisuusluokka on O(n), eli sen suoritusaika kasvaa lineaarisesti tiedoston koon kasvaessa. Uudelleen lajittelu on taas hitaampaa, koska siinä käytetään toteuttamaani insertionSort-algoritmia, jonka aikakompleksisuusluokka on O(n^2). Näin ollen siis lajitteluun kuluva aika kasvaa eksponentiaalisesti tiedoston koon kasvaessa.

Yleisesti, jos on taulukko valmiiksi lajiteltuna, niin kannattaa alkioiden järjestys vaihtaa päinvastaiseksi aina reverse-algoritmilla juuri sen takia, että sen aikakompleksisuusluokka on O(n), eli se toimii nopeasti, vaikka tiedostokoko olisi suuri.

Toteuttamiani hakualgoritmeja kutsutaan lineaarisiksi, koska ne sisältävät kaikki vain yhden for silmukan, joka käydään läpi maksimissaan n kertaa. Hakualgoritmit eivät siis sisällä sisäkkäisiä looppeja. Algoritmien aikakompleksisuusluokka on siis O(n).

## 03-TASK
![Graafit_testeistä](graafit_task_3.png)
```
n		Fill	Sort	Search	Total
500		2		0		1833	1835
1000	12		8		121		141
1500	10		20		37		67
2000	20		45		34		99
2500	20		20		69		109
3000	29		33		41		103
3500	33		48		37		118
4000	50		40		42		132
4500	60		64		34		158
5000	63		70		34		167
5500	90		86		35		211
6000	110		106		55		271
6500	120		130		66		316
7000	136		167		30		333
7500	160		171		32		363
8000	184		199		53		436
8500	210		226		58		494
9000	257		277		27		561
9500	256		285		27		568
10000	344		341		69		754
10500	341		359		22		722
11000	339		422		21		782
11500	361		425		21		807
12000	405		545		44		994
12500	571		529		86		1186
13000	506		615		20		1141
13500	543		706		24		1273
14000	702		668		20		1390
14500	868		816		20		1704
15000	762		812		20		1594
15500	728		901		37		1666
16000	954		887		20		1861
16500	832		941		20		1793
17000	892		1085	26		2003
17500	944		1085	21		2050
18000	1013	1169	21		2203
18500	1162	1227	23		2412
19000	1131	1328	21		2480
19500	1309	1378	24		2711
20000	990		1299	22		2311
20500	1458	1546	24		3028
21000	1487	1705	22		3214
21500	1549	1653	21		3223
22000	1760	1773	26		3559
22500	1705	1959	21		3685
23000	1834	2005	22		3861
23500	2138	2080	25		4243
24000	2139	2079	22		4240
24500	2091	2150	28		4269
25000	2076	2270	22		4368
25500	2198	2371	24		4593
26000	2318	2473	23		4814
26500	1535	1952	36		3523
27000	2678	2668	26		5372
27500	2794	2837	26		5657
28000	2877	2994	23		5894
28500	2987	3100	24		6111
29000	3244	3139	26		6409
29500	3386	3428	23		6837
30000	3461	3550	25		7036
30500	3661	3634	38		7333
31000	3831	3789	31		7651
31500	4002	3957	26		7985
32000	3372	3769	24		7165
```

Tein graafit vain nousevan järjestyksen testien tuloksista, koska laskevan järjestyksen testeistä tuli lähes samat arvot. Graafeista huomataan, että hakuun kulunut aika on pieni myös isoilla n arvoilla toisin kuin viime tehtävässä käytetyllä lineaarisella hakualgoritmilla.

Tehdään testejä 50 000 koodarin tiedostolla

Översti haku kesti 60ms
Översti Avani Thierry fast search kesti 0ms
Tuomala haku kesti 30ms
Tuomala McLay Sajjad fast search kesti 0ms
Liitiä haku kesti 20ms
Liitiä Bertie Otto fast search kesti 0ms
Häkki haku kesti 10ms
Häkki Jiao Joynul fast search kesti 0ms
Aalo haku kesti 0ms
Aalo Dalton Cormack fast search kesti 0ms

Huomataan, että kun mennään aakkosissa lähemmäs loppupäätä, lineaarisen haun aika kasvaa suurin piirtein lineaarisesti. Tämä johtuu siitä, että lineaarinen hakualgoritmi käy jokaisen nimen läpi ja palauttaa lopulta oikean. Lineaarisen haun aikakopleksisuusluokka on O(n).

Nopea haku binäärihaulla taas kestää sijainnista riippumatta aina lähes yhtä kauan, ja huomattavasti vähemmän aikaa, kuin lineaarinen haku loppupäässä. Binäärihaku ei käy jokaista listan alkiota läpi, vaan jakaa listan aina kahteen osaan. Siksi binäärihaku toimii nopeasti myös isoilla tiedostoilla. Binäärihaun aikakopleksisuusluokka on O(log(n)). Binäärihakua voi ja kannattaa siis aina käyttää, kun halutaan etsiä jotain valmiiksi järjestetystä listasta.

Suoritin binäärihaun myös rekursiivisena binarySearchR. Ilman vertailuoliota ja sen kanssa.

## 04-TASK

Tehtävää tehdessä opin, miten E tyypin listat toimivat ja miten stackeja käytetään hyväksi. Vaikeaa oli toteuttaa StackFactoryn luontimetodit. Helppoa oli parenthesischeck metodin koodin kirjoittaminen, kun oli ymmärtänyt pohjimmaisen idean.

capacity(): O(1).
push(): O(1) paitsi kun joudutaan reallokoimaan: O(n).
pop(): O(1).
peek(): O(1).
size(): O(1).
isEmpty(): O(1).
clear(): O(1).
toString(): O(n).

Kaikkien totetuttamieni algoritmien aikakompleksisuusluokka on O(1) paitsi toSting, joka on O(n), ja reallokointialgoritmin myös O(n). Ne ovat ainoat, joissa on looppeja (1 molemmisa).

ParenthesisCheck ei toimi oikein, mikäli heittomerkit ei ole merkitty oikein, koska algortimi ohittaa kaikki heittomerkin jälkeen tulevat merkit, seuraavaan heittomerkkiin asti. Eli jos alussa on yksi heittomerkki, eikä seuraavaa tule, ei algoritmi testaa ensimmäisen heittomerkin jälkeen mitään seuraavia merkkejä. 

## 05-TASK

Tehtävää tehdessä opin tekemään Exception luokkia ja palautin muistiin niiden käyttöä. Opin myös tapoja, jolla voidaan vähentää luokkakohtaisten muuttujien määrää queueImplementation luokassa. Vaikeinta oli saada toString toimimaan.

Linkitetty lista on parempi, kuin taulukkopohjainen toteutus silloin, kun listaan tehdään paljon muutoksia. Lisäyksiä ja poistoja päihin tai keskelle ja silloin, kun halutaan välttyä allokoinnilta. Linkitettyyn listaan lisääminen ja siitä poistaminen on halpaa, koska pitää vain muuttaa nodejen linkkejä allokointia ei siis tarvita. Jos tiedetään, että listaan laitettava data tulee olemaan pieni, tarjoaa linkitetty lista parempaa joustavuutta.

Taulukkopohjainen toteutus on parempi silloin, kun lisättävää on paljon ja poistettavaa vähän. Eli silloin, kun halutaan pääsääntöisesti lukea jonossa olevaa dataa sen täyttämisen jälkeen. Modernit tietokoneet suosivat taulukkopohjaista toteutusta koska siinä data on sijoitettu peräkkäisiin muistipaikkoihin toisin kuin linkitetyissä listoissa, joissa datan elementtejä on ympäri ramia.

Kaikki toteuttamani metodit noudattavat annettuja aikakompleksisuusmääreitä.

## 06-TASK

Tehtävää tehdessä opin tekemään nopeita algoritmeja. Helppoa oli tiedon löytäminen ja algoritmien kirjoittaminen. Vaikeaa oli saada heapsort toimimaan muulloinkin, kuin että alkuindeksi on 0.

Testien tulokset eri algoritmeille
![Graafit](task6-data.PNG)
![mergeSort](mergeSort.png)

Huomataan, että quicksort, heapsort ja mergesort ovat huomattavasti tehokkaampia isojen tiedostojen avaamisessa, kuin insertion sort.

Quicksort on tässä hieman nopeampi, kuin heapsort. Molempien aikakompleksisuusluokka on teorian mukaan O(n*log(n)). Graafit tukevat myös tätä väitettä. Ne eivät ole aivan lineaariset, mutta eivät myöskään kasva yhtä eksponentiaalisesti, kuin insertion sortin graafi.

Toteutin Quicksortin siten, että pivot saa aina keskimmäisen arvon. Tämän ansiosta quicksortin aikakompleksisuusluokka ei voi olla huonoimmassakaan tapauksessa O(n^2)

Toteutin mergesortin jälkeenpäin ja tein sen testin eri koneella, joka on hieman nopeampi kuin se jolla tein testit muille algoritmeille. Mutta testasin samalla koneella myös quick- ja heapsortteja ja totesin, että mergesort on kaikista nopein tässä käyttötarkoituksessa. Mergesortin aikakompleksisuusluokka on O(n*log(n)) niin huonoimmassa, kuin parhaassakin tapauksessa.

## 07-TASK

Tehtävää tehdessä opin paljon Javan rajapintojen toiminnasta. Opin toteuttamaan ja käyttämään BST:tä. Vaikeaa oli saada toArray sekä remove toimimaan. Helppoa oli rekusrsiivisten algoritmien toteutus.

BST-optimaalinen syvyys on aina log(n). Muutin BSTPerformanceTests testejä niin, että koodareiden lisäämisen jälkeen tulostetaan puun maksimisyvyys ja puun optimaalinen syvyys kullakin solmumäärällä.
 Max depth in bst is 12, optimal depth for 100 nodes is 6
 Max depth in bst is 21, optimal depth for 1000 nodes is 9
 Max depth in bst is 28, optimal depth for 5000 nodes is 12
 Max depth in bst is 29, optimal depth for 10000 nodes is 13
 Max depth in bst is 39, optimal depth for 50000 nodes is 15
 Max depth in bst is 37, optimal depth for 100000 nodes is 16
 Max depth in bst is 50, optimal depth for 1000000 nodes is 19
 Max depth in bst is 52, optimal depth for 2000000 nodes is 20

Käytin laskemisessa luokassa BinaryTree toteuttamaani maxDepth laskuria.

```java
System.out.format(" Max depth in bst is %d, optimal depth for %d nodes is %d%n", 
fastBST.getMaxDepth(), fastBST.size(), 
(int)Math.floor(Math.log(fastBST.size())/Math.log(2)));
```
Lisäsin testiin tämän koodipätkän.

Huomataan tulostuksista, että Puun todellinen syvyys on joka kerralla hieman yli puolet enemmän, kuin puun optimaalinen syvyys.

Toteutin kaikki metodit rekursiivisesti eli tyylillä A. Metodit indexOf ja getIndex toteutin tyylillä D hyödyntäen lapsisolmujen määrää kussakin haarassa. Valitsin rekursiivisen toteutustavan, koska se on minulle kaikista selkein. Valitsin tavan D silloin, kun oli mahdollista, koska se on huomattavasti nopeampi, kuin kaikkien solmujen läpikäynti yksitellen. O(n) vs O(log(n))

Jos toteuttaisin uudestaan, niin toteuttaisin hyödyntämällä visitoria, koska se vaikuttaa kätevältä.

Data simplecontainer testeistä. 1000000 koodarin tiedoston käsittely oli liian hidasta, joten jätin sen pois. (Ei suoriutunut 20 minuutissa)
![SimpleContainer](compare_simpleContainer_data.png)

Data bst-lle. 2000000 koodarin tiedoston käsittelyssä tuli OutOfMemoryException, joten nostin kekomuistin määrää testeille.
![bst_graph](bst_graph.png)

Huomataan, että binäärisen hakupuun add-algoritmi on huomattavasti nopeampi, kuin SimpleConainerissa toteutettu add-algoritmi. Binäärisen hakupuun lisäämisen aikakompleksisuusluokka on O(log(n)) ja SimpleContainerin O(n). Myös graafit tukevat tätä väitettä.

Etsiminen on suunnilleen yhtä nopeaa molemmissa toteutuksissa. Molempien aikakompleksisuusluokka on O(n).

Get(index) on hieman nopeampi SimpleContainerissa, koska sen aikakompleksisuusluokka on O(1) kun taas hakupuussa se on minun toteuttamalla tavalla O(log(n)).

Molempien toteutuksien toArray-algoritmin aikakompleksisuusluokka on O(n), joten ne ovat myös graafeissa suunnilleen yhtä nopeat.

Ylimääräisinä tehtävinä toteutin Removen, D tavan toteutuksen indexOf ja getIndex algoritmeissä. Toteutin duplikaattien lisäämisen linked list toteutuksella. BinaryTree-luokasta löytyy ylimääräinen metodi removeFromLinkedList, jota en käytä koodissa, mutta joka poistaisi halutun arvon omaavan solmun halutusta linkitetystä listasta.

## 08-TASK

Tehtävää tehdessä opin, miten hajauttaminen ja tiivistäminen toimii. Opin, miten hajautustaulu toteutetaan open adressing and probing -menetelmällä. Opin, miten reallokoinnin täyttökerroin ja taulukon koko suhteessa elementtien määrään vaikuttavat hajautustaulun tehokkuuteen. Hajautusta voi tehdä tehokkaamman pienentämällä täyttökerrointa tai kasvattamalla allokointikerrointa, mutta tämä taas johtaa kasvavaan muistin tarpeeseen. Kaikista tärkein tekijä tehokkuuden maksimointiin ja muistinkäytön vähentämiseen on hyvät hajautus ja tiivistysfunktiot.

Hajautustaulun testeissä kesti yhteensä 86 sekuntia.

```
Avainarvojen törmäysten kokonaismäärä eri tiedostoilla.
Törmäykset		Elementit tiedostossa
32				100
514				1000
3916			5000
7878			10000
15759			50000
30407			100000
456348			1000000
910906			2000000
```
Kerätty data hajautustaulujen testeistä.
![HashTableData](HashTableData.png)

Graafit datasta
![HashTableGraphs](HashTableGraphs.png)

Aikakompleksisuus hajautustauluun lisäämiselle, etsimiselle ja toArraylle on O(n). Lisäksi taulukon lajittelun aikakompleksisuus on O(nlog(n)). Tästä johtuu, että kaikkien datojen graafit ovat suurin piirtein lineaarisia. Isompiin hajautustauluihin lisääminen kesti hieman kauemmin, mikä johtuu uuden muistitilan allokoinnista, jonka aikakompleksiuus on O(n).

Kun verrataan saatua dataa task-7:n hakupuun dataan, huomataan, että lisääminen molempiin on suurin piirtein yhtä nopeaa. Hajautustaulu oli vain vähän nopeampi. Hakupuuhun lisäämisen aikakompleksisuus on O(log(n)) ja hajautustauluun lisäämisen O(1). Mutta koska hajautustauluun pitää välillä allokoida lisämuistia, ei siihen lisääminen ole paljon hakupuuhun lisäämistä nopeampaa.

Hajautustaulusta hakeminen sen sijaan on hakupuusta hakemista nopeampaa. Hakujen aikakompleksisuudet ovat molemille samat kuin lisäämisellekkin, mutta hakemisessa ei tarvi allokoida lisämuistia, joten hajautustaulu on tehokkaampi elementtien hakemisessa.

Lisäksi hajautustaulusta poistaminen on nopeampaa kuin hakupuusta samasta syystä kuin hakeminenkin.

Hakupuun muuttaminen järjestetyksi taulukoksi on nopeampaa, koska se on valmiiksi järjestyksessä eikä tarvi kuin suorittaa toArray, jonka kompleksisuus on O(n). Hajautustaulu sen sijaan muutetaan ensin taulukoksi O(n) jonka jälkeen se vielä järjestetään oikeaan järjestykseen O(n*log(n)). Eli koko prosessin aikakompleksisuus on O(n*log(n)).

Hajautustauluja käytetään yleisesti enemmän kuin hakupuita, koska niiden kyky käsitellä suuria tiedostoja on usein parempi. Hakupuita käytetään kuitenkin joskus totetutksissa, joissa tiedostokoot eivät ole suuria, tai joissa elementtien pitäminen järjestyksessä on tärkeää. Hakupuut käyttävät pienillä tiedostoilla vähemmän ylimääräistä muistia, kuin hajautustaulut.

Kerätty data ja graafit SimpleKeyedTable testeistä
![SimpleKeyedTableData](SimpleKeyedContainerData.png)

Huomataan, että hitaaseen taulukkototeutukseen lisääminen on nopeaa, koska elementti lisätään aina seuraavaan tyhjään tilaan taulukossa. Taulukosta etsiminen sen sijaan on erittäin hidasta. 100 000 elementin etsimiseen meni yli 2 minuuttia ja 1 000 000 elementin etsimiseen oli kulunut jo puoli tuntia, kunnes päätin sulkea testin. Taulukosta n elementin etsimisen aikakompleksisuus on O(n^2), joten etsimiseen tarvittava aika kasvaa eksponentiaalisesti taulukon koon kasvaessa.


CodeWordCounter laski TiRan kansiosta 100 yleisintä sanaa näin.
```	
Sanat				Määrä
the       	   		1004
import         		729
int     	    	562
array         		534
new         		486
string         		486
if         			481
pubic         		457
coder         		447
return         		431
system         		401
to         			377
test         		365
index         		354
not         		330
null         		327
in         			304
size         		299
static         		294
tira         		284
out         		274
oy         			271
java         		269
interact        	269
for         		255
graph         		250
void         		246
private         	240
of         			236
comparator      	231
this         		227
org         		226
is         			222
vertex         		218
from         		208
api         		207
jupiter         	206
junit         		206
coders         		202
must         		202
be         			201
value         		200
start         		189
util         		188
assertequals    	182
and         		180
queue         		180
testgraph       	177
integer         	173
element         	166
append         		165
length         		161
println         	158
override        	154
add         		154
tostring        	153
container       	150
count         		150
class         		148
file         		148
should         		147
stack         		147
edge         		134
currenttimemillis   133
key         		131
order         		130
writer         		130
throw         		128
testarray         	122
final         		122
with        	 	122
timeout         	121
format         		120
list         		119
capacity         	112
bst         		106
threadmode         	106
json         		105
assertdoesnotthrow 	105
throws         		104
long         		103
first         		103
get         		102
else         		102
number         		102
search         		102
queuetotest        	100
assertions          99
it          		97
pair          		97
student          	97
stacktotest         96
empty          		95
node          		93
that          		91
package          	91
displayname         91
result          	88
duration          	87
equals          	83
```

Laskemisessa kesti alle 100ms.

Suoritin lisätehtävänä myös poistofunktion.

## 09-TASK